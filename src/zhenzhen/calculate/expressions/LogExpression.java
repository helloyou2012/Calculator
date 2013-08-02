package zhenzhen.calculate.expressions;

public class LogExpression extends UnaryExpression{

	public LogExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		System.out.println("计算log微分");
		// TODO Auto-generated method stub
		//f(x)=log(g(x))的导数为：g'(x)/(ln10*g(x));
		return new DivExpression(new LnExpression(child).differentiate(var),
				                 new ConstantExpression(Math.log(10)));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("log化简");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.log10( childConst.getValue() ) );
        }
        return new LogExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("log求值");
		return Math.log10(d);
	}
	public String toString(){
		return "log(" + child.toString() + ")";
	}

}
