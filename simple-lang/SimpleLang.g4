grammar SimpleLang;

@header{
    import java.util.*;
    import org.antlr.v4.runtime.*;
}

@members{
    SymbolTable sym = new SymbolTable();

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        SimpleLangLexer lexer = new SimpleLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);
        parser.start();
    }
}

start : program {
                System.out.println($program.code);
                }EOF;

program returns [Code code]
    @init { $code = Code.empty(); }
    : (stmt {
             $code.addAll($stmt.code);
           }) +
    ;

stmt returns [Code code]
    : assignmentStmt {$code = $assignmentStmt.code;}
    | printStmt      {$code = $printStmt.code;}
    | whileStmt      {$code = $whileStmt.code;}
    ;

assignmentStmt returns [Code code]
    @init {$code = Code.empty();}
    : 'let' ID '=' expr
      {
        // try to resolve variable.  Declare variable
        // if it's not in the symbol table
        int register = this.sym.resolve($ID.text);
        System.out.println("Adding: " + $expr.code);
        $code.addAll($expr.code);
        $code.add(Instruction.ISTORE(register));
      }
    ;

printStmt returns [Code code]
    @init { $code = Code.empty(); }
    : 'print' expr
      {
        $code.add(Instruction.getPrintStream());
        $code.addAll($expr.code);
        $code.add(Instruction.invokePrintln());
      }
    ;

whileStmt returns [Code code]
    @init { $code = Code.empty(); }
    : 'while' '(' cond ')' '{' program '}'
      {
        String start = Code.newLabel();
        String end   = Code.newLabel();
        $code.add(Instruction.Label(start));
        $code.addAll($cond.code);
        $code.add(Instruction.IFZERO(end));
        $code.addAll($program.code);
        $code.add(Instruction.GOTO(start));
        $code.add(Instruction.Label(end));
      }
    ;

expr returns [Code code]
    @init { $code = Code.empty(); System.out.println("Starts with empty"); }
    @after { System.out.println("expr returns " + $code); }
     : ID               { if(this.sym.containsKey($ID.text)) {
                            $code.add(Instruction.ILOAD(this.sym.get($ID.text)));
                          } else {
                            $code.add(Instruction.LDC(0));
                          }
                            System.out.println(">" + $code);
                        }
     | NUM              { $code.add(Instruction.LDC($NUM.text)); 
                             System.out.println("NUM" + $code);}
     | '(' expr ')'     { $code.addAll($expr.code); }
     | e1=expr OP e2=expr
                        { 
                            $code.addAll($e1.code);
                            $code.addAll($e2.code);
                            $code.add(Instruction.Op($OP.text));
                        }
     ;

cond returns [Code code]
     @init { $code = Code.empty(); }
     : e1=expr '<' e2=expr
       {
        String l1 = Code.newLabel();
        String l2 = Code.newLabel();
        $code.addAll($e1.code);
        $code.addAll($e2.code);
        $code.add(Instruction.Op("-"));
        $code.add(new Instruction("", "ifge", l1, ""));
        $code.add(Instruction.LDC(1));
        $code.add(Instruction.GOTO(l2));
        $code.add(Instruction.Label(l1));
        $code.add(Instruction.LDC(0));
        $code.add(Instruction.Label(l2));
       }
     ;

NUM : [0-9]+;
ID : [a-z]+;
OP : '+' | '-' | '*' | '/' ;
WS : [ \t\r\n]+ {skip();};
