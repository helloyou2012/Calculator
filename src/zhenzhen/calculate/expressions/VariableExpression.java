package zhenzhen.calculate.expressions;

import java.util.Hashtable;

//变量表达式类
public class VariableExpression implements Expression{
	private static Hashtable<String, Double> environment;
	private String identifier;
	public double getValue() throws Exception{
		if(hasValue()){
			return ((Double)environment.get(identifier)).doubleValue();
		}
		throw new Exception(identifier + " 没有定义");
	}
	public boolean hasValue(){
		return environment.containsKey(identifier);
	}
	static {
		environment=new Hashtable<String, Double>();
		environment.put("pi", Math.PI);
		environment.put("e", Math.E);
	}
	public VariableExpression(String identifier){
		super();
		this.identifier=identifier.toLowerCase();
	}
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		try {
			return getValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		if(var.equals(identifier)){
			//f(x)=x;导数为1；
			return new ConstantExpression(1);
		}
		//f(x)=c;导数为0；
		return new ConstantExpression(0);
	}
	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		if ( identifier == "t" || identifier == "u" || identifier == "v" || identifier == "x" || identifier == "y" )
        {
            // special iteration variables
            return new VariableExpression( identifier );
        }
        if (hasValue())
        {
            try {
				return new ConstantExpression(getValue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return new VariableExpression(identifier);
	}
	public String toString(){
		return identifier;
	}
	/**定义变量
	 * @param variableName 变量名
	 * @param value 变量值
	 */
	public static void difine(String variableName, double value ){
		variableName=variableName.toLowerCase();
		environment.put(variableName, value);
	}
	/**取消变量
	 * @param variableName 变量名
	 */
	public static void unDifine(String variableName){
		environment.remove(variableName);
	}

}
