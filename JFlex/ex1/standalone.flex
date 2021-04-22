/* ------------------User code: empty ---------------------- */

%%

/* -----------------Options and Declarations---------------- */

%class PrintTokenStream
/*---name the generated lexer "PrintTokenStream"---*/

%standalone
/*---use generated lexer as a standalone application---*/


/* Macro Declarations */


/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */

num = 0 | [1-9][0-9]*


%%
/* --------------Lexical Rules---------------------- */

"+"  {System.out.print("<PLUS>");}

"*"  {System.out.print("<MULT>");}

{num}  {System.out.print("<NUM," + yytext() + ">");}
