// Generated from Calc.g4 by ANTLR 4.5.2

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, String=9, 
		Number=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "String", 
		"Number", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'deg'", "'PI'", "'+'", "'['", "']'", "'sum'", "'sin'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "String", "Number", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rN\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\7\n\63\n\n\f\n\16\n\66\13\n"+
		"\3\n\3\n\3\13\6\13;\n\13\r\13\16\13<\3\13\3\13\7\13A\n\13\f\13\16\13D"+
		"\13\13\5\13F\n\13\3\f\6\fI\n\f\r\f\16\fJ\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\5\5\2\"\"C\\c|\3\2\62;\5\2\13"+
		"\f\17\17\"\"R\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\37\3\2\2\2\t\"\3\2\2\2\13$\3\2"+
		"\2\2\r&\3\2\2\2\17(\3\2\2\2\21,\3\2\2\2\23\60\3\2\2\2\25:\3\2\2\2\27H"+
		"\3\2\2\2\31\32\7=\2\2\32\4\3\2\2\2\33\34\7f\2\2\34\35\7g\2\2\35\36\7i"+
		"\2\2\36\6\3\2\2\2\37 \7R\2\2 !\7K\2\2!\b\3\2\2\2\"#\7-\2\2#\n\3\2\2\2"+
		"$%\7]\2\2%\f\3\2\2\2&\'\7_\2\2\'\16\3\2\2\2()\7u\2\2)*\7w\2\2*+\7o\2\2"+
		"+\20\3\2\2\2,-\7u\2\2-.\7k\2\2./\7p\2\2/\22\3\2\2\2\60\64\7$\2\2\61\63"+
		"\t\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67"+
		"\3\2\2\2\66\64\3\2\2\2\678\7$\2\28\24\3\2\2\29;\t\3\2\2:9\3\2\2\2;<\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=E\3\2\2\2>B\7\60\2\2?A\t\3\2\2@?\3\2\2\2AD"+
		"\3\2\2\2B@\3\2\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2E>\3\2\2\2EF\3\2\2\2F"+
		"\26\3\2\2\2GI\t\4\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2"+
		"\2LM\b\f\2\2M\30\3\2\2\2\b\2\64<BEJ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}