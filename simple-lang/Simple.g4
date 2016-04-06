grammar Simple;

@members {
    SymbolTable sym = new SymbolTable();
    public void printCode(Code c) {
        System.out.println(".class public MyApp");
        System.out.println(".super java/lang/Object");
        System.out.println(".method public <init>()V");
        System.out.println("aload_0");
        System.out.println("invokenonvirtual java/lang/Object/<init>()V");
        System.out.println("return");
        System.out.println(".end method");

        System.out.println(".method public static main([Ljava/lang/String;)V");
        System.out.println(".limit stack 10");
        System.out.println(".limit locals 10");

        for(String i : c) {
            System.out.println(i);
        }

        System.out.println("return");
        System.out.println(".end method");
    }
}

start 
    : program { printCode($program.code); }
    ;

program returns [Code code]
    @init {
        $code = new Code();
    }
    : (
        stmt { $code.extend($stmt.code); }
      )+
    ;

stmt returns [Code code]
    : assignment { $code = $assignment.code; }
    | printStmt  { $code = $printStmt.code; }
    | whileStmt  { $code = $whileStmt.code; }
    ;

assignment returns [Code code]
    : 'let' ID '=' expr
      { int register = sym.resolve($ID.text, true);
        $code = new Code()
                    .extend($expr.code)
                    .append(I.ISTORE(register));

      }
    ;

printStmt returns [Code code]
    : 'print' expr
      { $code = new Code()
                    .append(I.GetPrintStream())
                    .extend($expr.code)
                    .append(I.invokePrintln());
      }
    ;

whileStmt returns [Code code]
    : 'while' '(' cond ')' '{' program '}'
      {
        String start = Code.newLabel();
        String end   = Code.newLabel();
        $code = new Code()
                    .append(I.Label(start))
                    .extend($cond.code)
                    .append(I.IFZERO(end))
                    .extend($program.code)
                    .append(I.GOTO(start))
                    .append(I.Label(end));
      }
    ;

expr returns [Code code]
    : ID    {  int register = sym.resolve($ID.text, false);
                $code = new Code();
                if(register < 0)
                    $code.append(I.LDC(0));
                else
                    $code.append(I.ILOAD(register));
            }
    | Num   {   $code = new Code().append(I.LDC($Num.text));
            }
    | '(' expr {
                $code = $expr.code;
            } ')'
    | e1=expr OP e2=expr
            {
                $code = new Code()
                            .extend($e1.code)
                            .extend($e2.code)
                            .append(I.Op($OP.text));
            }
    ;

cond returns [Code code]
    : e1=expr '<' e2=expr
            {
                String l1 = Code.newLabel();
                String l2 = Code.newLabel();
                $code = new Code()
                            .extend($e1.code)
                            .extend($e2.code)
                            .append(I.ISUB())
                            .append(I.IFGE(l1))
                            .append(I.LDC(1))
                            .append(I.GOTO(l2))
                            .append(I.Label(l1))
                            .append(I.LDC(0))
                            .append(I.Label(l2));
            }
    ;

Num : [0-9]+;
ID  : [a-z]+;
OP  : '+' | '-';
WS  : [ \t\r\n]+ {skip();};
