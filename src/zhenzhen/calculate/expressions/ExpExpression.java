package zhenzhen.calculate.expressions;


//指数表达式类
public class ExpExpression extends BinaryExpression{

	public ExpExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression differentiate(String var) {
		// TODO Auto-generated method stub
		System.out.println("计算exp微分");
		if(right!=null){
			if(right.getClass().equals(ConstantExpression.class)){
				//  f(x) = g(x)^n;
                //  f'(x) = n * g'(x) * g(x)^(n-1);
				return new MultExpression(new MultExpression(right,left.differentiate(var)), 
						                  new ExpExpression(left,new SubExpression(right, new ConstantExpression(1))));
			}
			else
			{
				Expression simple = left.simplify();
				if(simple.getClass().equals(ConstantExpression.class)){
					//  f(x) = a^g(x);
                    // f'(x) = (ln a) * g'(x) * a^g(x);
					double a = ((ConstantExpression)simple).getValue();
					return new MultExpression(new MultExpression(new ConstantExpression(Math.log(a)),
                            right.differentiate(var)),new ExpExpression(simple, right));
				}
				else
                {
                    //f(x)=g(x)^h(x);
                    //f'(x)=(h'*ln(g)+h*g'/g)*(g^h);
					Expression dh=right.differentiate(var);
					Expression dg=left.differentiate(var);
					MultExpression dhLng=new MultExpression(dh, new LnExpression(left));
					MultExpression hdgDivg=new MultExpression(right, new DivExpression(dg, left));
					ExpExpression gh=new ExpExpression(left, right);
					return new MultExpression(new AddExpression(dhLng, hdgDivg), gh);
                }
			}
		}
		try {
			throw new Exception("I do not support complex exponent differentiation");
		} catch (Exception e) {}
		return null;
	}

	@Override
	public Expression simplify() {
		// TODO Auto-generated method stub
		System.out.println("exp化简");
		Expression newLeft = left.simplify();
        Expression newRight = right.simplify();
        ConstantExpression leftConst =null;
        ConstantExpression rightConst =null;
        try {
        	leftConst =(ConstantExpression) newLeft;
		} catch (Exception e) {	}
		try {
			rightConst =(ConstantExpression) newRight;
		} catch (Exception e) {	}
		
		if ( leftConst != null && rightConst != null )
        {
            // two constants;  just evaluate it;
            return new ConstantExpression( Math.pow( leftConst.getValue(),rightConst.getValue() ) );
        }
        else if ( rightConst != null )
        {
            if ( rightConst.getValue() == 0 )
            {
                // x ^ 0;  return 1;
                return new ConstantExpression( 1 );
            }
            else if ( rightConst.getValue() == 1 )
            {
                // x ^ 1;  return x;
                return newLeft;
            }
        }
        else if ( leftConst != null && leftConst.getValue() == 0 )
        {
            // 0 ^ y;  return 0;
            return new ConstantExpression( 0 );
        }
        // x ^ y;  no simplification
        return new ExpExpression( newLeft, newRight );
	}

	@Override
	protected double operate(double d1, double d2) {
		// TODO Auto-generated method stub
		System.out.println("exp求值");
		return Math.pow(d1, d2);
	}
	public String toString(){
		return "(" + left.toString() + "^" + right.toString() + ")";
	}

}
