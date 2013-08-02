package zhenzhen.calculate.expressions;

public class ASineExpression extends UnaryExpression{

	public ASineExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算arcsin微分");
		//f(x)=arcsin(g(x))导数为：g'/((1-g^2)^0.5)
		return new DivExpression(child.differentiate(var), 
				                 new ExpExpression(new SubExpression(new ConstantExpression(1), new ExpExpression(child, new ConstantExpression(2))), 
				                		           new ConstantExpression(0.5)));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("化简arcsin");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.asin( childConst.getValue() ) );
        }
        return new ASineExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("arcsin求值");
		return Math.asin(d);
	}
	public String toString(){
		return "asin(" + child.toString() + ")";
	}

}
