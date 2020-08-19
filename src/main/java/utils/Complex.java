package utils;

public class Complex {

	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double realPart() {
		return re;
	}
	
	public double imaginaryPart() {
		return im;
	}

	public Complex add(double re, double im) {
		return add(new Complex(re, im));
	}

	public Complex add(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex subtract(double re, double im) {
		return subtract(new Complex(re, im));
	}

	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex multiply(double re, double im) {
		return multiply(new Complex(re, im));
	}

	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex divide(double re, double im) {
		return divide(new Complex(re, im));
	}

	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re
				* c.im)
				/ tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;
		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}

	@Override
	public int hashCode() {
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(im);
		return result;
	}

	private int hashDouble(double val) {
		long longBits = Double.doubleToLongBits(val);
		return (int) (longBits ^ (longBits >>> 32));
	}

	@Override
	public String toString() {
		return "" + (int)re + (im==0?"":" + "+(im<0?"(":"") + (int)im + "i")+(im<0?")":"");
	}
}
