package zhenzhen.calculate.expressions;

public class ACosineExpression extends UnaryExpression{

	public ACosineExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算arccos的微分");
		return new NegateExpression((new ASineExpression(child)).differentiate(var));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("化简arccos");
		Expression newChild = child.simplify();
        ConstantExpression childConst =null;
        try {
        	childConst=(ConstantExpression) newChild;
		} catch (Exception e) {	}

        if ( childConst != null )
        {
            // child is constant;  just evaluate it;
            return new ConstantExpression( Math.acos( childConst.getValue() ) );
        }
        return new ACosineExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("计算arccos的值");
		return Math.acos(d);
	}
	public String toString(){
		return "acos(" + child.toString() + ")";
	}

}
