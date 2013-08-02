package zhenzhen.calculate.expressions;

//二元表达式类
public abstract class BinaryExpression implements Expression{
	protected Expression left;
    protected Expression right;
	public BinaryExpression(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}
	protected abstract double operate( double d1, double d2 );
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		System.out.println("二元表达式求值");
		return operate(left.evaluate(),right.evaluate());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.toString();
	}
	public Expression getLeft(){
		return left;
	}
	public Expression getRight(){
		return right;
	}

}
