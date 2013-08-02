package zhenzhen.calculate.expressions;

//除法表达式类
public class DivExpression extends BinaryExpression{

	public DivExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算除法微分");
		if(left.toString().equals(right.toString()))
			return new ConstantExpression(0);
		// f(x) = g(x)/h(x);
        // f'(x) = ( g'(x)*h(x) - g(x)*h'(x) )/( h(x)^2 ) ;
		return new DivExpression(new SubExpression(new MultExpression(left.differentiate(var), right),
				                                   new MultExpression(left, right.differentiate(var))),
				                 new ExpExpression(right, new ConstantExpression(2) ));
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("除法化简");
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
            if ( rightConst.getValue()== 0 )
            {
                try {
					throw new Exception( "Divide by zero detected in function" );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            return new ConstantExpression( leftConst.getValue()/ rightConst.getValue() );
        }
        else if ( leftConst != null && leftConst.getValue() == 0 )
        {
            // 0 / y;  return 0;
            if ( rightConst != null && rightConst.getValue() == 0 )
            {
                try {
					throw new Exception( "Divide by zero detected in function" );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            return new ConstantExpression( 0 );
        }
        else if ( rightConst != null )
        {
            if ( rightConst.getValue()== 0 )
            {
                // x / 0;
                try {
					throw new Exception( "Divide by zero detected in function" );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if ( rightConst.getValue()== 1 )
            {
                // x / 1;  return x;
                return newLeft;
            }
            if ( rightConst.getValue()== -1 )
            {
                // x / -1;  return -x;
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
            // -x / -y;  return x / y;
            return new DivExpression( leftNegate.child, rightNegate.child );
        }
		if(newLeft.toString().equals(newRight.toString())){
			return new ConstantExpression(1);
		}
        // x / y;  no simplification
        return new DivExpression( newLeft, newRight );
	}

	@Override
	protected double operate(double d1, double d2) {
		// TODO Auto-generated method stub
		System.out.println("除法求值");
		return d1/d2;
	}
	public String toString(){
		return "(" + left.toString() + "/" + right.toString() + ")";
	}

}
