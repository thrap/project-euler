package utils;

import java.math.BigInteger;

public class BigRational implements Comparable<BigRational>  {
	public BigInteger n;
	public BigInteger d;
	
	public BigRational(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
		simplify();
	}
	
	public BigRational() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}
	
	public BigRational(long n, long d) {
		this(BigInteger.valueOf(n), BigInteger.valueOf(d));
	}
	
	public BigRational add(BigRational rational2) {
        BigInteger newNumerator = this.n.multiply(rational2.d).add(this.d.multiply(rational2.n));
        BigInteger newDenominator = this.d.multiply(rational2.d);
        return new BigRational(newNumerator, newDenominator);
	}

    public BigRational subtract(BigRational rational2) {
        BigInteger newNumerator = this.n.multiply(rational2.d).subtract(this.d.multiply(rational2.n));
        BigInteger newDenominator = this.d.multiply(rational2.d);
        return new BigRational(newNumerator, newDenominator);
    }

    public BigRational multiply(BigRational rational2) {
        return new BigRational(n.multiply(rational2.n), d.multiply(rational2.d));
    }

    public BigRational divide(BigRational r2) {
        return multiply(new BigRational(r2.d, r2.n));
    }


    public void simplify() {
		BigInteger t = gcd();
        if (t.equals(BigInteger.ZERO)) {
            return;
        }
	    n = n.divide(t);
	    d = d.divide(t);
	
	    if (d.compareTo(BigInteger.ZERO) < 0) {
	        n = n.multiply(BigInteger.valueOf(-1));
	        d = d.multiply(BigInteger.valueOf(-1));
	    }
	}
	
	public int compareTo(BigRational r) {
	    return (n.multiply(r.d).compareTo(d.multiply(r.n)));
	}
	
	private BigInteger gcd() {
	    BigInteger a = n;
	    if (a.compareTo(BigInteger.ZERO) < 0) {
	        a = a.multiply(BigInteger.valueOf(-1));
	    }
	    BigInteger b = d;
	    if (b.compareTo(BigInteger.ZERO) < 0) {
	    	b = b.multiply(BigInteger.valueOf(-1));
	    }
	    while (!b.equals(BigInteger.ZERO)) {
	        BigInteger temp = b;
	        b = a.mod(b);
	        a = temp;
	    }
	    return a;
	}
	
	public String toString() {
		return ""+n+"/"+d;
	}
}
