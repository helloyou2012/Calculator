package zhenzhen.calculate.expressions;

//余弦函数类
public class CosineExpression extends UnaryExpression{

	public CosineExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算cos微分");
		// f(x) = cos( g(x) );
        // f'(x) = -sin( g(x) ) * g'(x);
		return new MultExpression(new NegateExpression(new SineExpression(child)), child.differentiate(var));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("cos函数化简");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.cos( childConst.getValue() ) );
        }
        return new CosineExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("cos函数求值");
		return Math.cos(d);
	}
	public String toString(){
		return "cos(" + child.toString() + ")";
	}

}
