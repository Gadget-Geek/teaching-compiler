// Generated from Calc.g4 by ANTLR 4.5.2

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, String=9, 
		Number=10, WS=11;
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_exprList = 2;
	public static final String[] ruleNames = {
		"start", "expr", "exprList"
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

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Token s;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> String() { return getTokens(CalcParser.String); }
		public TerminalNode String(int i) {
			return getToken(CalcParser.String, i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7);
				_la = _input.LA(1);
				if (_la==String) {
					{
					setState(6);
					((StartContext)_localctx).s = match(String);
					}
				}

				setState(9);
				((StartContext)_localctx).expr = expr(0);
				this.Print((((StartContext)_localctx).s!=null?((StartContext)_localctx).s.getText():null), ((StartContext)_localctx).expr.v);
				setState(11);
				match(T__0);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << String) | (1L << Number))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public double v;
		public ExprContext e;
		public ExprContext e1;
		public Token Number;
		public ExprListContext exprList;
		public ExprContext e2;
		public TerminalNode Number() { return getToken(CalcParser.Number, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(18);
				((ExprContext)_localctx).Number = match(Number);
				((ExprContext)_localctx).v =  this.Number((((ExprContext)_localctx).Number!=null?((ExprContext)_localctx).Number.getText():null));
				}
				break;
			case T__2:
				{
				setState(20);
				match(T__2);
				((ExprContext)_localctx).v =  Math.PI;
				}
				break;
			case T__4:
				{
				setState(22);
				match(T__4);
				setState(23);
				((ExprContext)_localctx).exprList = exprList();
				setState(24);
				match(T__5);
				setState(25);
				match(T__6);
				((ExprContext)_localctx).v =  this.Sum(((ExprContext)_localctx).exprList.v);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(30);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(31);
						match(T__1);
						((ExprContext)_localctx).v =  this.DegreeToRad(((ExprContext)_localctx).e.v);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(33);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(34);
						((ExprContext)_localctx).e2 = expr(0);
						setState(35);
						match(T__3);
						((ExprContext)_localctx).v =  this.Add(((ExprContext)_localctx).e1.v, ((ExprContext)_localctx).e2.v);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(38);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(39);
						match(T__7);
						((ExprContext)_localctx).v =  this.Sine(((ExprContext)_localctx).e.v);
						}
						break;
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<Double> v;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprList);
		 ((ExprListContext)_localctx).v =  new Vector<Double>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				((ExprListContext)_localctx).expr = expr(0);
				_localctx.v.add(((ExprListContext)_localctx).expr.v);
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << Number))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r8\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\5\2\n\n\2\3\2\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\6\4\64\n"+
		"\4\r\4\16\4\65\3\4\2\3\4\5\2\4\6\2\2<\2\17\3\2\2\2\4\36\3\2\2\2\6\63\3"+
		"\2\2\2\b\n\7\13\2\2\t\b\3\2\2\2\t\n\3\2\2\2\n\13\3\2\2\2\13\f\5\4\3\2"+
		"\f\r\b\2\1\2\r\16\7\3\2\2\16\20\3\2\2\2\17\t\3\2\2\2\20\21\3\2\2\2\21"+
		"\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\b\3\1\2\24\25\7\f\2\2\25"+
		"\37\b\3\1\2\26\27\7\5\2\2\27\37\b\3\1\2\30\31\7\7\2\2\31\32\5\6\4\2\32"+
		"\33\7\b\2\2\33\34\7\t\2\2\34\35\b\3\1\2\35\37\3\2\2\2\36\23\3\2\2\2\36"+
		"\26\3\2\2\2\36\30\3\2\2\2\37-\3\2\2\2 !\f\7\2\2!\"\7\4\2\2\",\b\3\1\2"+
		"#$\f\5\2\2$%\5\4\3\2%&\7\6\2\2&\'\b\3\1\2\',\3\2\2\2()\f\3\2\2)*\7\n\2"+
		"\2*,\b\3\1\2+ \3\2\2\2+#\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\5\3\2\2\2/-\3\2\2\2\60\61\5\4\3\2\61\62\b\4\1\2\62\64\3\2\2\2\63\60"+
		"\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\7\3\2\2\2\b\t\21"+
		"\36+-\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}