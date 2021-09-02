public class rational implements Comparable<rational> {
	private long denominator;
	private long numerator;
	double epsilon = 0.0001;

	public rational (long p, long q) {
		numerator = p;
		denominator = q;
		simplify();
	}

	public rational(long p) {
		numerator = p;
		denominator = 1;
		simplify();
	}

	public rational() {
		numerator = 1;
		denominator = 1;
		simplify();
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public rational add(rational rt) {
		long p1 = this.getNumerator();
		long q1 = this.getDenominator();
		long p2 = rt.getNumerator();
		long q2 = rt.getDenominator();

		return new rational(p1 * q2 + p2 * q1, q1*q2);
	}

	public rational subtract(rational rt) {
		long p1 = this.getNumerator();
		long q1 = this.getDenominator();
		long p2 = rt.getNumerator();
		long q2 = rt.getDenominator();

		return new rational(p1 * q2 - p2 * q1, q1*q2);
	}

	public rational multiply(rational rt) {
		long p1 = this.getNumerator();
		long q1 = this.getDenominator();
		long p2 = rt.getNumerator();
		long q2 = rt.getDenominator();

		return new rational(p1 * p2, q1 * q2);
	}

	public rational divide (rational rt) {
		return multiply(new rational(rt.getDenominator(), rt.getNumerator()));
	}

	private void simplify() {
		long num = this.numerator;
		long denom = this.denominator;
		long gcd =num;
		if (num > denom) {
			gcd = GCD(num, denom);
		} if (num < denom){
			gcd = GCD(denom, num);
		}
		this.numerator /= gcd;
		this.denominator /= gcd;

	}

	private static long GCD(long n1, long n2) {
		if (n2 ==0) {
			return n1;
		} else {
			return GCD(n2, n1 % n2);
		}
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(this instanceof rational)) {
			return false;
		}
		rational rt2 = (rational) o;

		if (rt2.getNumerator() == this.getNumerator()) {
			if (rt2.getDenominator() == this.getDenominator()) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(rational rt2) {
		if (this.equals(rt2)) {
			return 0;	
		} else if (this.getNumerator() * 1.0/this.getDenominator() > rt2.getNumerator()* 1.0/rt2.getDenominator()) {
			return 1;
		}
		return -1;
	}

	public double value() {
		return (double) this.numerator/this.denominator;
	}

	public rational kroot(long n) {
		rational currentEstimate = new rational();
		rational previousEstimate = new rational();
		rational root = new rational(n);


		while (Math.abs(this.value()-this.power(n).value()) > epsilon) {

			previousEstimate = currentEstimate;

			currentEstimate = currentEstimate.subtract((previousEstimate.power(n).subtract(this)).divide(root.multiply(previousEstimate.power(n-1))));
		}
		return currentEstimate;
	}

	public rational power(long n) {
		return new rational((long)Math.pow(this.getNumerator(),n), (long) Math.pow(this.getDenominator(),n));
	}


}