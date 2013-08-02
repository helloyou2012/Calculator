package zhenzhen.calculate.tokens;

public class Tokenizer {
	private String function;
	private int index;
	public Tokenizer(String function) {
		if(function==null){
			this.function="";
		}
		this.function = function;
		this.index=0;
	}
	private boolean isAlpha( char c )
    {
        return ( ( 'a' <= c && c <= 'z' ) || ( 'A' <= c && c <= 'Z' ) );
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private boolean isNumber( char c )
    {
        return ( '.' == c || ( '0' <= c && c <= '9' ) );
    }
    public FunctionType getFunctionEnum(String fun){
    	try {
			return Enum.valueOf(FunctionType.class, fun);
		} catch (Exception e) {
			// TODO: handle exception
			return FunctionType.empty;
		}
    }
    public Token next(){
    	System.out.println("取下一个表达式");
    	while(index<function.length()){
    		if(isNumber(function.charAt(index))){
    			String val="";
    			val+=function.charAt(index++);
    			while(index<function.length()&&isNumber(function.charAt(index))){
    				val+=function.charAt(index++);
    			}
    			return new Token(val,TokenType.Constant);
    		}
    		if(isAlpha(function.charAt(index))){
    			String var="";
    			var+=function.charAt(index++);
    			while(index<function.length()&&isAlpha(function.charAt(index))){
    				var+=function.charAt(index++);
    			}
    			switch (getFunctionEnum(var.toLowerCase())) {
				case sin:   return new Token( "sin", TokenType.Sine );
				case cos:   return new Token( "cos", TokenType.Cosine );
				case tan:   return new Token( "tan", TokenType.Tangent );
				case asin:   return new Token( "asin", TokenType.ASine );
				case acos:   return new Token( "acos", TokenType.ACosine );
				case atan:   return new Token( "atan", TokenType.ATangent );
				case ln:   return new Token( "ln", TokenType.Ln);
				case log:   return new Token( "log", TokenType.Log);
				default:    return new Token( var, TokenType.Variable );
				}
    		}
    		switch (function.charAt(index++)) {
    		case ' ':
            case '\t':
            case '\r':
            case '\n':  break;//continue也可以

            case '+':   return new Token( "+", TokenType.Plus );
            case '-':   return new Token( "-", TokenType.Minus );
            case '*':   return new Token( "*", TokenType.Multiply );
            case '/':   return new Token( "/", TokenType.Divide );
            case '^':   return new Token( "^", TokenType.Exponent );
            case '(':   return new Token( "(", TokenType.OpenParen );
            case ')':   return new Token( ")", TokenType.CloseParen );
			default:    try {
					throw new Exception("Invalid token '" + function.charAt(index-1) + "' in function: " + function);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	}
    	return new Token( "", TokenType.EOF );
    }

}
