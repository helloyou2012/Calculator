package zhenzhen.calculate.expressions;

public class ATanExpression extends UnaryExpression{

	public ATanExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算arctan微分");
		//f(x)=arctan(g(x))导数为：g'/(1+g^2)
		return new DivExpression(child.differentiate(var), 
				                 new AddExpression(new ConstantExpression(1), new ExpExpression(child, new ConstantExpression(2))));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("化简arctan");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.atan( childConst.getValue() ) );
        }
        return new ATanExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("arctan求值");
		return Math.atan(d);
	}
	public String toString(){
		return "atan(" + child.toString() + ")";
	}

}
