/* The following code was generated by JFlex 1.4_pre3 on 4/21/21 2:49 PM */



/* --------------------------Usercode Section------------------------ */
package src;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4_pre3
 * on 4/21/21 2:49 PM from the specification file
 * <tt>file:/media/kirandhakal25/Windows-SSD/AIT/Documents/Sem Four/NLI_to_SQL/Cup/ex6/flex/lcalc.flex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int YY_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] yycmap = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  2,  0,  3,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  4,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  9,  0, 22,  0,  0,  0,  0,  0,  5,  0,  0,  0, 
    14,  0,  0, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 30, 
     0, 12, 26, 28, 23, 16, 27, 29, 19,  6,  0,  0, 11, 25, 17, 20, 
    10,  0, 15,  7,  8, 24, 31, 21, 32, 13,  0,  0,  0,  0,  0,  0
  };


  /** 
   * Translates a state to a row index in the transition table (packed version)
   */
  final private static String yy_rowMap_packed = 
    "\0\0\0\41\0\102\0\41\0\41\0\143\0\204\0\245\0\306\0\347"+
    "\0\u0108\0\u0129\0\u014a\0\u016b\0\u018c\0\u01ad\0\u01ce\0\u01ef\0\u0210\0\u0231"+
    "\0\u0252\0\u0273\0\u0294\0\u02b5\0\u02d6\0\u02f7\0\41\0\u0318\0\u0339\0\u035a"+
    "\0\u037b\0\u039c\0\u03bd\0\u03de\0\u03ff\0\u0420\0\u0441\0\u0462\0\u0483\0\u04a4"+
    "\0\u04c5\0\u04e6\0\u0507\0\u0528\0\u0549\0\u056a\0\u058b\0\u05ac\0\u05cd\0\u05ee"+
    "\0\u060f\0\u0630\0\u0651\0\u0672\0\u0693\0\u06b4\0\u06d5\0\u06f6\0\u0717\0\41"+
    "\0\u0738\0\41\0\u0759\0\u077a\0\u079b\0\u07bc\0\u07dd\0\u07fe\0\41\0\u081f"+
    "\0\u0840\0\u0861\0\u0882\0\u08a3\0\u08c4\0\u08e5\0\u0906\0\u0927\0\u0948\0\u0969"+
    "\0\u098a\0\u09ab\0\u09cc\0\u09ed\0\u0a0e\0\u0a2f\0\u0a50\0\41\0\u0a71\0\u0a92"+
    "\0\u0ab3\0\u0ad4\0\u0af5\0\u0b16\0\u0b37\0\u0b58\0\u0b79\0\u0b9a\0\u0bbb\0\u0bdc"+
    "\0\u0bfd\0\41\0\u0c1e\0\u0c3f\0\u0c60\0\u0c81\0\u0ca2\0\u0cc3\0\u0ce4\0\u0d05"+
    "\0\u0d26\0\u0d47\0\u0d68\0\u0d89\0\u0daa\0\u0dcb\0\u0dec\0\u0e0d\0\u0e2e\0\u0e4f"+
    "\0\u0e70\0\u0e91\0\u0eb2\0\u0ed3\0\u0ef4\0\u0f15\0\u0f36\0\u0f57\0\u0f78\0\u0f99"+
    "\0\u0fba\0\u0fdb\0\u0ffc\0\u101d\0\u103e\0\u105f\0\u1080\0\41\0\u10a1\0\u10c2"+
    "\0\u10e3\0\u1104\0\u1125\0\u1146\0\u1167\0\u1188\0\u11a9\0\u11ca\0\u11eb\0\u120c"+
    "\0\u122d\0\u124e\0\u126f\0\u1290\0\u12b1\0\u12d2\0\u12f3\0\u1314\0\u0d89\0\u1335"+
    "\0\u1356\0\u1377\0\u1398\0\u13b9\0\u13da\0\u13fb\0\u141c\0\u143d\0\u145e\0\u147f"+
    "\0\u14a0\0\u14c1\0\u14e2\0\u1503\0\u1524\0\u1545\0\u1566\0\u1587\0\u15a8\0\u15c9"+
    "\0\u15ea\0\u160b\0\u162c\0\u164d\0\u166e\0\u168f\0\u16b0\0\u16d1\0\u16f2\0\u1713"+
    "\0\u1734\0\u1755";

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int [] yy_rowMap = yy_unpack_rowMap(yy_rowMap_packed);


  /** 
   * Unpacks the compressed row translation table.
   *
   * @param packed   the packed row translation table
   * @return         the unpacked row translation table
   */
  private static int [] yy_unpack_rowMap(String packed) {
    int [] map = new int[384];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 384) {
      int high = ((int) packed.charAt(i++)) << 16;
      map[j++] = high | packed.charAt(i++);
    }
    return map;
  }
  /** 
   * The packed transition table of the DFA (part 0)
   */
  private static final String yy_packed0 = 
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\2\1\20"+
    "\1\21\1\22\1\2\1\23\1\2\1\24\1\25\1\2"+
    "\1\26\1\27\1\30\1\31\4\2\43\0\1\4\44\0"+
    "\1\32\53\0\1\33\27\0\1\34\7\0\1\35\7\0"+
    "\1\36\3\0\1\37\27\0\1\40\23\0\1\41\46\0"+
    "\1\42\2\0\1\43\35\0\1\44\3\0\1\45\33\0"+
    "\1\46\13\0\1\47\4\0\1\50\2\0\1\51\21\0"+
    "\1\52\37\0\1\53\42\0\1\54\33\0\1\55\13\0"+
    "\1\56\33\0\1\57\50\0\1\33\13\0\1\60\52\0"+
    "\1\61\26\0\1\62\5\0\1\63\37\0\1\64\1\0"+
    "\1\33\31\0\1\65\51\0\1\66\4\0\1\67\23\0"+
    "\1\70\45\0\1\71\13\0\1\72\41\0\1\73\40\0"+
    "\1\74\32\0\1\75\35\0\1\76\27\0\1\77\40\0"+
    "\1\100\55\0\1\101\23\0\1\102\22\0\1\103\42\0"+
    "\1\104\17\0\1\105\56\0\1\106\26\0\1\107\41\0"+
    "\1\110\34\0\1\111\44\0\1\112\37\0\1\113\31\0"+
    "\1\114\61\0\1\115\33\0\1\116\35\0\1\117\26\0"+
    "\1\120\2\0\1\121\22\0\1\122\24\0\1\123\57\0"+
    "\1\123\24\0\1\124\33\0\1\125\41\0\1\126\50\0"+
    "\1\127\20\0\1\130\63\0\1\131\34\0\1\132\31\0"+
    "\1\133\44\0\1\134\26\0\1\135\35\0\1\136\66\0"+
    "\1\137\13\0\1\140\66\0\1\141\12\0\1\142\36\0"+
    "\1\143\56\0\1\144\33\0\1\145\40\0\1\146\30\0"+
    "\1\147\55\0\1\150\22\0\1\151\64\0\1\152\33\0"+
    "\1\130\42\0\1\130\17\0\1\153\46\0\1\154\43\0"+
    "\1\155\27\0\1\156\56\0\1\157\23\0\1\102\60\0"+
    "\1\160\30\0\1\161\54\0\1\162\25\0\1\163\27\0"+
    "\1\164\55\0\1\165\27\0\1\166\37\0\1\167\45\0"+
    "\1\170\57\0\1\171\25\0\1\172\45\0\1\173\20\0"+
    "\1\174\51\0\1\175\33\0\1\176\44\0\1\177\33\0"+
    "\1\200\51\0\1\201\34\0\1\202\55\0\1\203\22\0"+
    "\1\204\41\0\1\205\51\0\1\206\36\0\1\207\17\0"+
    "\1\210\41\0\1\211\40\0\1\212\52\0\1\213\27\0"+
    "\1\214\43\0\1\162\41\0\1\215\50\0\1\216\30\0"+
    "\1\217\45\0\1\220\43\0\1\221\33\0\1\222\31\0"+
    "\1\223\45\0\1\224\60\0\1\225\24\0\1\70\32\0"+
    "\1\226\46\0\1\227\36\0\1\74\42\0\1\230\27\0"+
    "\1\231\50\0\1\146\50\0\1\232\46\0\1\233\12\0"+
    "\1\234\50\0\1\235\30\0\1\162\50\0\1\111\35\0"+
    "\1\130\42\0\1\236\52\0\1\237\23\0\1\240\54\0"+
    "\1\241\30\0\1\103\40\0\1\242\51\0\1\146\27\0"+
    "\1\105\51\0\1\132\23\0\1\243\40\0\1\244\55\0"+
    "\1\245\40\0\1\105\44\0\1\246\12\0\1\146\40\0"+
    "\1\212\26\0\1\247\12\0\1\250\61\0\1\205\26\0"+
    "\1\234\50\0\1\251\24\0\1\252\35\0\1\253\50\0"+
    "\1\254\37\0\1\255\31\0\1\256\1\0\1\257\64\0"+
    "\1\260\40\0\1\261\10\0\1\262\40\0\1\263\53\0"+
    "\1\264\43\0\1\265\31\0\1\266\42\0\1\267\42\0"+
    "\1\270\46\0\1\271\21\0\1\272\54\0\1\273\24\0"+
    "\1\237\60\0\1\274\22\0\1\205\52\0\1\275\40\0"+
    "\1\146\30\0\1\276\41\0\1\146\44\0\1\146\31\0"+
    "\1\146\63\0\1\277\13\0\1\205\47\0\1\300\35\0"+
    "\1\224\24\0";

  /** 
   * The transition table of the DFA
   */
  private static final int yytrans [] = yy_unpack();


  /* error codes */
  private static final int YY_UNKNOWN_ERROR = 0;
  private static final int YY_ILLEGAL_STATE = 1;
  private static final int YY_NO_MATCH = 2;
  private static final int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  private static final String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final byte YY_ATTRIBUTE[] = {
     0,  9,  1,  9,  9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  0,  9,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  0,  9,  0,  0, 
     0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private void debug(String type) {
        if(type == "SEPARATOR")
            System.out.println("<"+ type + ">");
        else
            System.out.print("<"+ type + ">");
    }

    private void debug(String type, String text) {
        System.out.print("<"+ type + "," + text + ">");
    }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[6006];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_r = false;
          yycolumn++;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 1: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
          {  throw new Error("Illegal character <"+yytext()+">");  }
        case 193: break;
        case 2: 
        case 3: 
          {  /* just skip what was found, do nothing */  }
        case 194: break;
        case 137: 
          {  debug("TABLE_LITERAL", yytext()); return symbol(sym.TABLE_LITERAL, new String(yytext()));  }
        case 195: break;
        case 101: 
        case 158: 
          {  debug("ATTRIBUTE_LITERAL", yytext()); return symbol(sym.ATTRIBUTE_LITERAL, new String(yytext()));  }
        case 196: break;
        case 26: 
          {  debug("PREPOSITION_LITERAL", yytext()); return symbol(sym.PREPOSITION_LITERAL, new String(yytext()));  }
        case 197: break;
        case 59: 
          {  debug("NOUN_LITERAL", yytext()); return symbol(sym.NOUN_LITERAL, new String(yytext()));  }
        case 198: break;
        case 61: 
          {  debug("DET_LITERAL", yytext()); return symbol(sym.DET_LITERAL, new String(yytext()));  }
        case 199: break;
        case 68: 
          {  debug("ADJ_LITERAL", yytext()); return symbol(sym.ADJ_LITERAL, new String(yytext()));  }
        case 200: break;
        case 87: 
          {  debug("VERB_LITERAL", yytext()); return symbol(sym.VERB_LITERAL, new String(yytext()));  }
        case 201: break;
        case 4: 
          {  debug("DOT"); return symbol(sym.DOT);  }
        case 202: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}