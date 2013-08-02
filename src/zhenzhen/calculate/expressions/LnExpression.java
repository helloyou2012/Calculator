package zhenzhen.calculate.expressions;

public class LnExpression extends UnaryExpression{

	public LnExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算ln微分");
		//f(x)=ln(g(x))的导数：g'(x)/g(x);
		return new DivExpression(child.differentiate(var), child);
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("ln函数化简");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.log( childConst.getValue() ) );
        }
        return new LnExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("ln函数求值");
		return Math.log(d);
	}
	public String toString(){
		return "ln(" + child.toString() + ")";
	}

}
