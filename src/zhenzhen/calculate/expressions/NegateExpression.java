package zhenzhen.calculate.expressions;

//相反数表达式类
public class NegateExpression extends UnaryExpression{

	public NegateExpression(Expression child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("相反数微分");
		//f(x)=-g(x);导数为：-g'(x);
		return new NegateExpression(child.differentiate(var));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("相反数化简");
		Expression newChild = child.simplify();
		ConstantExpression childConst =null;
		try {//测试能否转换
			childConst =(ConstantExpression)newChild;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("转化失败");
		}
		if(childConst!=null){
			return new ConstantExpression( -childConst.getValue());
		}
		return new NegateExpression( newChild );
	}

	@Override
	protected double operate(double d) {
		// TODO Auto-generated method stub
		System.out.println("相反数求值");
		return -d;
	}
	public String toString(){
		return "(-" + child.toString() + ")";
	}

}
