package zhenzhen.calculate.expressions;

//正弦函数类
public class SineExpression extends UnaryExpression{

	public SineExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算sin微分");
		//f(x)=sin(g(x));导数为：cos(g(x))*g'(x);
		return new MultExpression( new CosineExpression(child), child.differentiate( var ) );
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("sin化简");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.sin( childConst.getValue() ) );
        }
        return new SineExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("sin求值");
		return Math.sin(d);
	}
	public String toString(){
		return "sin(" + child.toString() + ")";
	}

}
