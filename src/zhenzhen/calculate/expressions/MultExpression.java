package zhenzhen.calculate.expressions;

//乘法表达式类
public class MultExpression extends BinaryExpression{

	public MultExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算乘法微分");
		// f(x) = g(x)*h(x);
        // f'(x) = g(x)*h'(x) + g'(x)*h(x);
		return new AddExpression(new MultExpression(left, right.differentiate(var)),
				new MultExpression(left.differentiate(var), right));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("乘法化简");
		Expression newLeft = left.simplify();
        Expression newRight = right.simplify();
        ConstantExpression leftConst =null;
        ConstantExpression rightConst =null;
        NegateExpression leftNegate =null;
        NegateExpression rightNegate =null;
        try {
        	leftConst =(ConstantExpression) newLeft;
		} catch (Exception e) {	}
		try {
			rightConst =(ConstantExpression) newRight;
		} catch (Exception e) {	}
		try {
			leftNegate =(NegateExpression) newLeft;
		} catch (Exception e) {	}
		try {
			rightNegate =(NegateExpression) newRight;
		} catch (Exception e) {	}
		
		if ( leftConst != null && rightConst != null )
        {
            // two constants;  just evaluate it;
            return new ConstantExpression( leftConst.getValue()* rightConst.getValue());
        }
        else if ( leftConst != null )
        {
            if ( leftConst.getValue()== 0 )
            {
                // 0 * y;  return 0;
                return new ConstantExpression( 0 );
            }
            if ( leftConst.getValue()== 1 )
            {
                // 1 * y;  return y;
                return newRight;
            }
            if ( leftConst.getValue()== -1 )
            {
                // -1 * y;  return -y
                if ( rightNegate != null )
                {
                    // y = -u (-y = --u);  return u;
                    return rightNegate.child;
                }
                return new NegateExpression( newRight );
            }
        }
        else if ( rightConst != null )
        {
            if ( rightConst.getValue()== 0 )
            {
                // x * 0;  return 0;
                return new ConstantExpression( 0 );
            }
            if ( rightConst.getValue()== 1 )
            {
                // x * 1;  return x;
                return newLeft;
            }
            if ( rightConst.getValue()== -1 )
            {
                // x * -1;  return -x;
                if ( leftNegate != null )
                {
                    // x = -u (-x = --u);  return u;
                    return leftNegate.child;
                }
                return new NegateExpression( newLeft );
            }
        }
        else if ( leftNegate != null && rightNegate != null )
        {
            // -x * -y;  return x * y;
            return new MultExpression( leftNegate.child, rightNegate.child );
        }
		if(newRight.getClass().equals(DivExpression.class)){
			if(((DivExpression)newRight).right.toString().equals(newLeft.toString()))
				return ((DivExpression)newRight).left;
		}
        // x * y;  no simplification
        return new MultExpression( newLeft, newRight );
	}

	@Override
	protected double operate(double d1, double d2) {
		// TODO Auto-generated method stub
		System.out.println("乘法求值");
		return d1*d2;
	}
	public String toString(){
		return "(" + left.toString() + "*" + right.toString() + ")";
	}

}
