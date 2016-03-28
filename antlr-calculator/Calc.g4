grammar Calc;

@header{
import java.util.*;
}

@members{
  public static void main(String[] args) throws Exception {
    ANTLRInputStream input = new ANTLRFileStream("./test.txt");
    CalcLexer lexer = new CalcLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CalcParser parser = new CalcParser(tokens);
    parser.start();
  }

  double Number(String text) {
    return Double.parseDouble(text);
  }

  double Add(double x, double y) {
    return x + y;
  }

  double Sine(double x) {
    return Math.sin(x);
  }

  double Sum(List<Double> list) {
    double total = 0;
    for(double f : list) total += f;
    return total;
  }

  double DegreeToRad(double x) {
    return x / 360 * 2 * Math.PI;
  }

  void Print(String message, double x) {
    if(message == null) {
      message = "";
    }
    System.out.printf("%s> %.4f\n", message, x);
  }
}

start : ((s=String)? expr {this.Print($s.text, $expr.v);} ';')+
      ;

expr returns [double v]
     : Number                       {$v = this.Number($Number.text);}
     | e=expr 'deg'                 {$v = this.DegreeToRad($e.v);}
     | 'PI'                         {$v = Math.PI;}
     | e1=expr e2=expr '+'          {$v = this.Add($e1.v, $e2.v);}
     | '[' exprList ']' 'sum'       {$v = this.Sum($exprList.v);}
     | e=expr 'sin'                 {$v = this.Sine($e.v);}
     ;

exprList returns [List<Double> v]
     @init { $v = new Vector<Double>(); }
     : (expr {$v.add($expr.v);})+
     ; 

String : '"' [a-zA-Z ]* '"';
Number : [0-9]+ ('.' [0-9]*)? ;
WS : [ \t\r\n]+ -> skip;













