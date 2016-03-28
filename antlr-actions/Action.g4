grammar Action;

@members {
    void echo(float f) {
        System.out.printf("%.4f\n", f);
    }
}

start : expr <EOF> {echo($expr.v);};

expr returns [float v]
     : Number { $v = Float.parseFloat($Number.text); }
     | e1=expr '+' e2=expr { $v = $e1.v + $e2.v; }
     | e1=expr '-' e2=expr { $v = $e1.v - $e2.v; }
     | e1=expr '*' e2=expr { $v = $e1.v * $e2.v; }
     | '(' e=expr ')'  { $expr.v = $e.v; }
     ;

Number  : [0-9]+ ('.' [0-9]+)? ;
WS      : [ \t\n\r]+ -> skip ;
