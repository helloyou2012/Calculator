package zhenzhen.calculate.expressions;

//常量表达式类
public class ConstantExpression implements Expression{
	public double value;

	public ConstantExpression(double value) {
		super();
		this.value = value;
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		System.out.println("常数求值");
		return this.value;
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("常数微分");
		//      f(x) = c;
        //     f'(x) = 0;常值函数导数为0
		return new ConstantExpression(0);
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("常数化简");
		return new ConstantExpression(value);
	}
	public String toString(){
		return Double.toString(value);
	}
	public double getValue(){
		return value;
	}

}
