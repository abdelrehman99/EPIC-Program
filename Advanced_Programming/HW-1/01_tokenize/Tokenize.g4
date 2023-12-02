lexer grammar Tokenize;

// ? -> Zero or one
// * -> Zero or more
// + -> One or more

SPACE: [ \t\n] -> skip;
// TODO: your lexer grammar here.
DECIMAL: [+-]?[1-9]+[0-9]+;
OCTAL: [+-]?[0][0-7]+;
HEXADECIMAL: [+-]?[0][x][0-9A-Fa-f]+;
FLOAT: [+-]?(([0-9]* [.] [0-9]* ([e][+-]?)? [0-9]*) | ([0-9]+[e][+-]?[0-9]+));
CHAR:
	['] (. | [\\]( ([\\nt'"]) | ([u][0-9A-Fa-f]*{4}))) ['];
STRING: ["] (([\\][\\]) | ([\\]["]) | ([\\]~["]) | (~["\\]) )+ ["];

