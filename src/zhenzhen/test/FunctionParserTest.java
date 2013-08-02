package zhenzhen.test;

import zhenzhen.calculate.expressions.ACosineExpression;
import zhenzhen.calculate.expressions.ASineExpression;
import zhenzhen.calculate.expressions.ATanExpression;
import zhenzhen.calculate.expressions.AddExpression;
import zhenzhen.calculate.expressions.ConstantExpression;
import zhenzhen.calculate.expressions.CosineExpression;
import zhenzhen.calculate.expressions.DivExpression;
import zhenzhen.calculate.expressions.ExpExpression;
import zhenzhen.calculate.expressions.Expression;
import zhenzhen.calculate.expressions.LnExpression;
import zhenzhen.calculate.expressions.LogExpression;
import zhenzhen.calculate.expressions.MultExpression;
import zhenzhen.calculate.expressions.NegateExpression;
import zhenzhen.calculate.parsers.FunctionParser;
import junit.framework.TestCase;

public class FunctionParserTest extends TestCase {
	public void testACos(){
		Expression exp= FunctionParser.parse("acos(0.5)");
		assertEquals(Math.acos(0.5), exp.evaluate());
		assertEquals(ACosineExpression.class, exp.getClass());
	}
	public void testAdd(){
		Expression exp= FunctionParser.parse("3+4");
		assertEquals(3.0+4.0, exp.evaluate());
		assertEquals(AddExpression.class, exp.getClass());
	}
	public void testASin(){
		Expression exp= FunctionParser.parse("asin(0.5)");
		assertEquals(Math.asin(0.5), exp.evaluate());
		assertEquals(ASineExpression.class, exp.getClass());
	}
	public void testATan(){
		Expression exp= FunctionParser.parse("atan(1.0)");
		assertEquals(Math.atan(1.0), exp.evaluate());
		assertEquals(ATanExpression.class, exp.getClass());
	}
	public void testBinary(){
		Expression exp= FunctionParser.parse("3");
		assertEquals(3.0, exp.evaluate());
		assertEquals(ConstantExpression.class, exp.getClass());
	}
	public void testCos(){
		Expression exp= FunctionParser.parse("cos(0.5)");
		assertEquals(Math.cos(0.5), exp.evaluate());
		assertEquals(CosineExpression.class, exp.getClass());
	}
	public void testDiv(){
		Expression exp= FunctionParser.parse("3/5");
		assertEquals(3.0/5.0, exp.evaluate());
		assertEquals(DivExpression.class, exp.getClass());
	}
	public void testExp(){
		Expression exp= FunctionParser.parse("3^4");
		assertEquals(Math.pow(3, 4), exp.evaluate());
		assertEquals(ExpExpression.class, exp.getClass());
	}
	public void testLn(){
		Expression exp= FunctionParser.parse("ln(e)");
		assertEquals(Math.log(Math.E), exp.evaluate());
		assertEquals(LnExpression.class, exp.getClass());
	}
	public void testLog(){
		Expression exp= FunctionParser.parse("log(100)");
		assertEquals(2.0, exp.evaluate());
		assertEquals(LogExpression.class, exp.getClass());
	}
	public void testMulti(){
		Expression exp= FunctionParser.parse("3*4");
		assertEquals(3.0*4.0, exp.evaluate());
		assertEquals(MultExpression.class, exp.getClass());
	}
	public void testNegate(){
		Expression exp= FunctionParser.parse("-3");
		assertEquals(-3.0, exp.evaluate());
		assertEquals(NegateExpression.class, exp.getClass());
	}
}
