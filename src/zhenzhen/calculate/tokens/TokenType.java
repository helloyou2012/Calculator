package zhenzhen.calculate.tokens;

public class TokenType{
	public final static int None =0x0;
	public final static int Constant =0x1;
	public final static int Variable =0x2;
	public final static int Plus =0x4;
	public final static int Minus =0x8;
	public final static int Multiply =0x10;
	public final static int Divide =0x20;
	public final static int Exponent =0x40;
	public final static int Sine =0x80;
	public final static int Cosine =0x100;
	public final static int Tangent =0x200;
	public final static int ASine =0x400;
	public final static int ACosine =0x800;
	public final static int ATangent =0x1000;
	public final static int Ln =0x2000;
	public final static int Log =0x4000;
	public final static int OpenParen =0x8000;
	public final static int CloseParen =0x10000;
	public final static int EOF =0x20000;
}
