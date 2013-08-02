package zhenzhen.calculate.expressions;

//减法表达式类
public class SubExpression extends BinaryExpression{

	public SubExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算减法微分");
		//f(x)=g(x)-h(x)的导数为：g'(x)-h'(x)
		return new SubExpression(left.differentiate(var), right.differentiate(var));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("减法化简");
		Expression newLeft = left.simplify();
        Expression newRight = right.simplify();
        ConstantExpression leftConst =null;
        ConstantExpression rightConst =null;
        NegateExpression rightNegate =null;
        try {
        	leftConst =(ConstantExpression) newLeft;
		} catch (Exception e) {	}
		try {
			rightConst =(ConstantExpression) newRight;
		} catch (Exception e) {	}
		try {
			rightNegate =(NegateExpression) newRight;
		} catch (Exception e) {	}
		
		if ( leftConst != null && rightConst != null )
        {
            // two constants;  just evaluate it;
            return new ConstantExpression( leftConst.getValue()- rightConst.getValue());
        }
        else if ( leftConst != null && leftConst.getValue()== 0 )
        {
            // 0 - y;  return -y;
            if ( rightNegate != null )
            {
                // y = -u (--u);  return u;
                return rightNegate.child;
            }
            return new NegateExpression( newRight );
        }
        else if ( rightConst != null && rightConst.getValue()== 0 )
        {
            // x - 0;  return x;
            return newLeft;
        }
        else if ( rightNegate != null )
        {
            // x - -y;  return x + y;
            return new AddExpression( newLeft, rightNegate.child );
        }
		if(newLeft.toString().equals(newRight.toString())){
			return new ConstantExpression(0);
		}
        // x - y;  no simplification
        return new SubExpression( newLeft, newRight );
	}

	@Override
	protected double operate(double d1, double d2) {
		// TODO Auto-generated method stub
		System.out.println("减法求值");
		return d1-d2;
	}
	public String toString(){
		return "(" + left.toString() + "-" + right.toString() + ")";
	}

}
