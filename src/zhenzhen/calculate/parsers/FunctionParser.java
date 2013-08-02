package zhenzhen.calculate.parsers;


import zhenzhen.calculate.expressions.*;
import zhenzhen.calculate.tokens.*;

//语法分析类
/**
 * @author 振震
 * Mail：helloyou2012@yeah.net
 * QQ  : 865702942
 * Blog: http://blog.sina.com.cn/zhenzhenhello
 * Call：18817332855
 * 2010-8-12 上午01:00:06
 */
public class FunctionParser {
	private static Tokenizer tokenizer;
    private static Token    CurrentToken;
    protected static TokenSet FirstAddExp;
    private static TokenSet FirstMultExp;
    private static TokenSet FirstExpExp;
    private static TokenSet FirstUnaryExp;
    private static TokenSet FirstFactorPrefix;
    private static TokenSet FirstFactor;
    private static TokenSet FirstFunction;
    static{
    	FirstFunction = new TokenSet( TokenType.Sine | TokenType.Cosine | TokenType.Tangent |
    			TokenType.ASine | TokenType.ACosine | TokenType.ATangent | TokenType.Ln | TokenType.Log);
        FirstFactor = TokenSet.add(FirstFunction , new TokenSet( TokenType.Variable | TokenType.OpenParen ));
        FirstFactorPrefix = TokenSet.add(FirstFactor , TokenType.Constant);
        FirstUnaryExp = TokenSet.add(FirstFactorPrefix , TokenType.Minus);
        FirstExpExp = new TokenSet( FirstUnaryExp );
        FirstMultExp = new TokenSet( FirstUnaryExp );
        FirstAddExp = new TokenSet( FirstUnaryExp );
    }
    public FunctionParser(){    	
    }
    /**取得下一个Token(标示符)
     * @return
     */
    private static boolean next()
    {
        if ( CurrentToken.type == TokenType.EOF )
        {
            try {
				throw new Exception( "Parsed past the end of the function" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        CurrentToken = tokenizer.next();
        return CurrentToken.type != TokenType.EOF;
    }
    private static void eat(int type){
    	if ( CurrentToken.type != type )
        {
            try {
				throw new Exception( "Missing: " + type );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        next();
    }
    private static boolean check( TokenSet tokens )
    {
        return tokens.Contains( CurrentToken.type );
    }
    //------------------------------------------------------------------
    /**解析表达式
     * @param function 表达式字符串
     * @return  解析后的表达式
     */
    public static Expression parse( String function )
    {
        tokenizer = new Tokenizer( function );
        CurrentToken = new Token( "", TokenType.None );

        if ( !next() )
        {
            try {
				throw new Exception( "Cannot parse an empty function" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        Expression  exp=parseAddExpression();
        String leftover ="";
        while ( CurrentToken.type != TokenType.EOF )
        {
            leftover += CurrentToken.value;
            next();
        }
        if (!(leftover==null||leftover.length()==0) )
        {
            try {
				throw new Exception( "Trailing characters: " + leftover );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return exp;
    }
    //------------------------------------------------------------------
    /**解析加法表达式
     * @return
     */
    private static Expression  parseAddExpression()
    {
    	System.out.println("解析加法表达式");
        if (check(FirstMultExp))
        {
            Expression exp = parseMultExpression();
            while (check(new TokenSet(TokenType.Plus | TokenType.Minus)))
            {
                int opType = CurrentToken.type;
                eat( opType );
                if ( !check( FirstMultExp ) )
                {
                    try {
						throw new Exception( "Expected an expression after + or - operator" );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                Expression right = parseMultExpression();
                switch (opType)
                {
                case TokenType.Plus:
                    exp = new AddExpression( exp, right );
                    break;
                case TokenType.Minus:
                    exp = new SubExpression( exp, right );
                    break;
                default:
                    try {
						throw new Exception( "Expected plus or minus, got: " + opType );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }

            return exp;
        }
        else
        {
            try {
				throw new Exception( "Invalid expression" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    //------------------------------------------------------------------
    /**解析乘法表达式
     * @return
     */
    private static Expression  parseMultExpression()
    {
    	System.out.println("解析乘法表达式");
        if (check(FirstExpExp) )
        {
            Expression exp = parseExpExpression();

            while (check( new TokenSet( TokenType.Multiply | TokenType.Divide ) ) )
            {
                int opType = CurrentToken.type;
                eat( opType );
                if ( !check( FirstExpExp ) )
                {
                    try {
						throw new Exception( "Expected an expression after * or / operator" );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                Expression right = parseExpExpression();

                switch ( opType )
                {
                case TokenType.Multiply:
                    exp = new MultExpression( exp, right );
                    break;

                case TokenType.Divide:
                    exp = new DivExpression( exp, right );
                    break;

                default:
                    try {
						throw new Exception( "Expected mult or divide, got: " + opType );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
            return exp;
        }
        else
        {
            try {
				throw new Exception( "Invalid expression" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    //------------------------------------------------------------------
    /**解析指数函数表达式
     * @return
     */
    private static Expression  parseExpExpression()
    {
    	System.out.println("解析指数表达式");
        if (check( FirstUnaryExp ) )
        {
            Expression exp = parseUnaryExpression();
            
            if (check( new TokenSet( TokenType.Exponent ) ) )
            {
                int opType = CurrentToken.type;
                eat( opType );
                if ( !check( FirstUnaryExp ) )
                {
                    try {
						throw new Exception( "Expected an expression after ^ operator" );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                Expression right = parseUnaryExpression();
                switch ( opType)
                {
                case TokenType.Exponent:
                    exp = new ExpExpression( exp, right );
                    break;
                default:
                    try {
						throw new Exception( "Expected exponent, got: " + opType );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
            return exp;
        }
        else
        {
            try {
				throw new Exception( "Invalid expression" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    //------------------------------------------------------------------
    /**解析一元表达式
     * @return
     */
    private static Expression parseUnaryExpression()
    {
    	System.out.println("解析一元表达式");
        boolean negate = false;
        if ( CurrentToken.type == TokenType.Minus )
        {
            eat( TokenType.Minus );
            negate = true;
        }

        if ( check( FirstFactorPrefix ) )
        {
            Expression exp = parseFactorPrefix();

            if ( negate )
            {
                return new NegateExpression( exp );
            }
            return exp;
        }
        else
        {
            try {
				throw new Exception( "Invalid expression" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    //------------------------------------------------------------------
    /**解析前面的因子
     * @return
     */
    private static Expression parseFactorPrefix()
    {
    	System.out.println("解析前缀因子");
        Expression exp = null;
        if ( CurrentToken.type == TokenType.Constant )
        {
            exp = new ConstantExpression(new Double(CurrentToken.value));
            eat( TokenType.Constant );
        }

        if ( check( FirstFactor ) )
        {
            if ( exp == null )
            {
                return parseFactor();
            }
            return new MultExpression( exp, parseFactor() );
        }
        else
        {
            if ( exp == null )
            {
                try {
					throw new Exception( "Invalid Expression" );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            return exp;
        }
    }
    //------------------------------------------------------------------
    /**解析因子
     * @return
     */
    private static Expression  parseFactor()
    {
    	System.out.println("解析因子");
        Expression exp = null;
        do
        {
            Expression right = null;
            switch ( CurrentToken.type )
            {
            case TokenType.Variable:
                right = new VariableExpression( CurrentToken.value );
                eat( TokenType.Variable );
                break;
            case TokenType.Sine:
            case TokenType.Cosine:
            case TokenType.Tangent:
            case TokenType.ASine:
            case TokenType.ACosine:
            case TokenType.ATangent:
            case TokenType.Ln:
            case TokenType.Log:
                right = parseFunction();
                break;
            case TokenType.OpenParen:
                eat( TokenType.OpenParen );
                right = parseAddExpression();
                eat( TokenType.CloseParen );
                break;
            default:
                try {
					throw new Exception( "Unexpected token in Factor: " + CurrentToken.type );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            exp = (exp == null) ? right : new MultExpression( exp, right );
        } while ( check( FirstFactor ) );
        return exp;
    }
    //------------------------------------------------------------------
    /**解析函数表达式
     * @return
     */
    private static Expression  parseFunction()
    {
    	System.out.println("解析函数表达式");
        int opType = CurrentToken.type;
        eat( opType );
        eat( TokenType.OpenParen );
        Expression exp = parseAddExpression();
        eat( TokenType.CloseParen );

        switch ( opType )
        {
        case TokenType.Sine:
            return new SineExpression( exp );
        case TokenType.Cosine:
            return new CosineExpression( exp );
        case TokenType.Tangent:
            return new TangentExpression( exp );
        case TokenType.ASine:
            return new ASineExpression( exp );
        case TokenType.ACosine:
            return new ACosineExpression( exp );
        case TokenType.ATangent:
            return new ATanExpression( exp );
        case TokenType.Ln:
            return new LnExpression( exp );
        case TokenType.Log:
            return new LogExpression( exp );
        default:
            try {
				throw new Exception( "Unexpected Function type: " + opType );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

}
