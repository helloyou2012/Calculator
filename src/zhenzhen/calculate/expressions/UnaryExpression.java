package zhenzhen.calculate.expressions;

//一元表达式类
public abstract class UnaryExpression implements Expression{
	protected Expression child;
	public UnaryExpression(Expression child) {
		super();
		this.child = child;
	}
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		System.out.println("一元表达式求值");
		return operate(child.evaluate());
	}
	public Expression child(){
		return child;
	}
	public String toString(){
		//this指向实现了这个抽象类的对象
		return this.toString();
	}
	protected abstract double operate( double d );

}
