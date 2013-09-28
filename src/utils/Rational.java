package utils;

public class Rational extends Number {
	//TODO: se Problem183.rational for tips ;)
	public long n;
	public long d;
	
	public Rational() {
		this(0, 1);
	}
	
	public Rational(long n, long d) {
		this.n = n;
		this.d = d;
		simplify();
	}
	
	public Rational add(Rational rational2) {
        long newNumerator = this.n * rational2.d
                        + this.d * rational2.n;
        long newDenominator = this.d * rational2.d;
        Rational newRational = new Rational(newNumerator, newDenominator);
        return newRational;
	}
	
	public Rational subtract(Rational rational2) {
        long newNumerator = this.n * rational2.d
                        - this.d * rational2.n;
        long newDenominator = this.d * rational2.d;
        Rational newRational = new Rational(newNumerator, newDenominator);
        return newRational;
	}
	
	public Rational multiply(Rational rational2) {
		return new Rational(n*rational2.n, d*rational2.d);
	}
	
	public Rational divide(Rational r2) {
		return multiply(new Rational(r2.d, r2.n));
	}
	
	public void simplify() {
		long t = gcd();
	    n /= t;
	    d /= t;
	
	    if (d < 0) {
	        n *= -1;
	        d *= -1;
	    }
	}
	
	public boolean isLessThan(Rational r) {
	    return (n*r.d < d*r.n);
	}
	
	private long gcd() {
	    long a = n;
	    if (a < 0) {
	        a *= -1;
	    }
	    long b = d;
	    if (b < 0) {
	        b *= -1;
	    }
	    while (b != 0) {
	        long temp = b;
	        b = a%b;
	        a = temp;
	    }
	    return a;
	}
	
	public String toString() {
		if (d == 1)
			return ""+n;
		return ""+n+"/"+d;
	}

	@Override
	public double doubleValue() {
		return (double)n/(double)d;
	}

	@Override
	public float floatValue() {
		return (float)n/(float)d;
	}

	@Override
	public int intValue() {
		return (int) (n/d);
	}

	@Override
	public long longValue() {
		return n/d;
	}
}