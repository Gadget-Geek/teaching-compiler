grammar Hello;

/* CFG productions */
start   : message+;
message : FirstWord Word* '.' ;

/* Lexer rules */
FirstWord : [A-Z] Word?;
Word      : [a-z]+;
WS        : [ \t\r\n]+ -> skip;
