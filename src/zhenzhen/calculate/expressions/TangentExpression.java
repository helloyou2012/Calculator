package zhenzhen.calculate.expressions;

//正切函数类
public class TangentExpression extends UnaryExpression{

	public TangentExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算tan微分");
		// f(x) = tan( g(x) );
        // f'(x) = cos^-2( g(x) ) * g'(x);
		return new MultExpression(new ExpExpression(new CosineExpression(child),new ConstantExpression(-2)), 
				                  child.differentiate(var));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("tan化简");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.tan( childConst.getValue() ) );
        }
        return new TangentExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("tan求值");
		return Math.tan(d);
	}
	public String toString(){
		return "tan(" + child.toString() + ")";
	}

}
