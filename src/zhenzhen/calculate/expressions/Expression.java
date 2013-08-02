package zhenzhen.calculate.expressions;

public interface Expression {
	public double evaluate();//求表达式的值
	public Expression differentiate(String var);//求表达式微分
	public Expression simplify();//表达式化简
}
