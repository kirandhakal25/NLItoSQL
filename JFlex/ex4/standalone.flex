/* ------------------User code: empty ---------------------- */

%%

/* -----------------Options and Declarations----------------- */

%class PrintTokenStream
/*---name the generated lexer "PrintTokenStream"---*/

%standalone
/*---use generated lexer as a standalone application---*/


/* Macro Declarations */


/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */

int = 0 | [1-9][0-9]*

/* A literal float */
float = ("-")?[0-9]+ ("." [0-9]+)?


/* A identifier is a word beginning a letter between A and
   Z, a and z, or an underscore followed by zero or more letters
   between A and Z, a and z, zero and nine, or an underscore. */



id = [A-Za-z_][A-Za-z_0-9]*

%%
/* --------------Lexical Rules---------------------- */

"+"  {System.out.print("<PLUS>");}

"*"  {System.out.print("<MULT>");}

{id}  {System.out.print("<ID," + yytext() + ">");}

{int}  {System.out.print("<INT," + yytext() + ">");}

{float}  {System.out.print("<FLOAT," + yytext() + ">");}