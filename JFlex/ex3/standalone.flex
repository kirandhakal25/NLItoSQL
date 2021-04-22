/* ------------------User code: empty ---------------------- */

%%

/* -----------------Options and Declarations----------------- */

%class PrintTokenStream
/*---name the generated lexer "PrintTokenStream"---*/

%standalone
/*---use generated lexer as a standalone application---*/


/* Macro Declarations */


/* A identifier is a word beginning a letter between A and
   Z, a and z, or an underscore followed by zero or more letters
   between A and Z, a and z, zero and nine, or an underscore. */

/* id = [ab]*  
*/

id1 = a*b 

id2 = b*a

id = {id1}* | {id2}*

%%
/* --------------Lexical Rules---------------------- */



{id}  {System.out.print("<ID," + yytext() + ">");}

