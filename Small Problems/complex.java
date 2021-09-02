import java.text.DecimalFormat;

public class complex {
	private double a;
	private double b;
	private static DecimalFormat df2 = new DecimalFormat("#.######");

	
// Primary constructor for the complex object. The first two parameters represennt the real and imaginary parts
// respectively, if the third parameter is false. If the third parameter is true, then the first two parameters are
// the argument and magnitude of the complex number, and it is processed from its polar form.
 	public complex (double a, double b, boolean polar) {
		if (polar == false) {
			this.b = b;
			this.a = a;	
		} else {
			this.b = b * Math.sin(a);
			this.a = b * Math.cos(a);
		}
		
	}

// The implementation of the default constructor for the class, which initializes the real and imaginary
// parts both to 0.
	public complex() {
		this.a = 0;
		this.b = 0;
	}

// The implementation for constructing a complex number with just a real part.
	public complex(double value) {
		this.a = value;
		this.b = 0;
	}

/**
* <p> Addition of two complex numbers </p>
* @param z1 the first complex number
* @param z2 the second complex number
* @return the sum of z1 and z2
*/
	public static complex add(complex z1, complex z2) {
		return new complex(z1.getReal() + z2.getReal(), z1.getIm() + z2.getIm(), false);
	}

/**
* <p> Subtraction of two complex numbers </p>
* @param z1 the first complex number
* @param z2 the second complex number
* @return the difference of z1 and z2
*/
	public static complex subtract(complex z1, complex z2) {
		return new complex(z1.getReal() - z2.getReal(), z1.getIm() - z2.getIm(), false);
	}

/**
* <p> Product of two complex numbers </p>
* @param z1 the first complex number
* @param z2 the second complex number
* @return the product of z1 and z2
*/

	public static complex multiply(complex z1, complex z2) {
		return new complex(z1.getReal()*z2.getReal()-z1.getIm()*z2.getIm(), z1.getReal()*z2.getIm() + z1.getIm() * z2.getReal(), false);
	}

/**
* <p> Division of two complex numbers </p>
* @param z1 the first complex number
* @param z2 the second complex number
* @return the quotient of z1 and z2
*/

	public static complex divide(complex z1, complex z2) {
		if (mag(z2) < 0.0001) {
			throw new ArithmeticException();
		}

		complex numerator = multiply(z1, z2.conjugate());
		double denom = mag(z2)*mag(z2);
		return new complex(numerator.getReal()/denom, numerator.getIm()/denom, false);
	}

/**
* <p> Returns imaginary part </p>
* @return imaginary part
*/
	public double getIm() {
		return b;
	}

/**
* <p> Returns real part </p>
* @return real part
*/
	public double getReal() {
		return a;
	}

/**
* <p> Sets real part </p>
* @param val the real value
*/
	public void setReal(double val) {
		a =  val;
	}
/**
* <p> Sets imaginary part </p>
* @param val the imaginary value
*/
	public void setIm(double val) {
		b = val;
	}

/**
* <p> Overrides the toString method to print complex number as (a + bi) or (a - bi) </p>
* @return complex number in string form
*/
	@Override
	public String toString() {
		double absIm = Math.abs(this.getIm());
		if (this.getIm() < 0) {
			return df2.format(this.getReal()) + " - " +  df2.format(absIm) + "i";
		} else {
			return df2.format(this.getReal()) + " + " +  df2.format(this.getIm()) + "i";	
		}
		
	}
/**
* <p> Returns the positive angle from 0 to 2pi that the complex number makes counterclockwise from the positive x-axis </p>
* @return argument in radians
*/
	public double arg() {
		double theta = Math.atan(b/a);
		if ((a > 0) && (b > 0)) {
			return theta;
		} if ((a > 0) && (b < 0)) {
			return theta + 2* Math.PI;
		} if ((a < 0) && (b < 0)) {
			return Math.PI + theta;
		} if ((a < 0) && (b > 0)) {
			return Math.PI + theta;

		} if ((a == 0) && (b > 0)) {
			return Math.PI/2;
		} if ((a == 0) && (b < 0)) {
			return Math.PI/2 * 3;
		} if ((a > 0) && (b == 0)) {
			return 0;
		} if ((a < 0) && (b == 0)) {
			return Math.PI;
		} else {
			return -1;
		}
	}

/**
* <p> Returns the positive angle from 0 to 2pi that the complex number makes counterclockwise from the positive x-axis </p>
* @param z complex number to find argument of
* @return argument in radians
*/
	public static double arg(complex z) {
		double a = z.getReal();
		double b = z.getIm();

		double theta = Math.atan(b/a);
		if ((a > 0) && (b > 0)) {
			return theta;
		} if ((a > 0) && (b < 0)) {
			return theta + 2* Math.PI;
		} if ((a < 0) && (b < 0)) {
			return Math.PI + theta;
		} if ((a < 0) && (b > 0)) {
			return Math.PI + theta;

		} if ((a == 0) && (b > 0)) {
			System.out.println("case found correctly");
			return Math.PI/2;
		} if ((a == 0) && (b < 0)) {
			return Math.PI/2 * 3;
		} if ((a > 0) && (b == 0)) {
			return 0;
		} if ((a < 0) && (b == 0)) {
			return Math.PI;
		} else {
			return -1;
		}


	}
/**
* <p> Finds magnitude of complex number </p>
* @return magnitude of the complex number
*/
	public double mag() {
		return Math.sqrt(this.b*this.b + this.a*this.a);
	}
/**
* <p> Finds magnitude of complex number </p>
* @param z complex number to find magnitude of
* @return magnitude of the complex number
*/
	public static double mag (complex z) {
		return Math.sqrt(z.getIm()*z.getIm() + z.getReal() * z.getReal());
	}

/**
* <p> Finds magnitude of complex number </p>
* @param z complex number to find conjugate of
* @return conjugate of the complex number
*/
	public static complex conjugate(complex z) {
		return new complex(z.getReal(), -1 * z.getIm(), false);
	}

/**
* <p> Finds magnitude of complex number </p>
* @return magnitude of the complex number
*/
	public complex conjugate() {
		return new complex(this.a, -1 * this.b, false);
	}
/**
* <p> Overrides the equals method, and uses the values of a and b with some error </p>
* @param o complex number to compare equals
* @return boolean true if equal and false if not 
*/
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(this instanceof complex)) {
			return false;
		}
		complex z2 = (complex) o;

		if (Math.abs(this.getReal()-z2.getReal())/Math.abs(this.getReal()) <= 0.0001) {
			if(Math.abs(this.getIm()-z2.getIm())/Math.abs(this.getIm()) <= 0.0001) {
				return true;
			}
		}
		return false;
	}


/**
* <p> Finds the value of a complex number to a real power </p>
* @param z complex number to use as base
* @param n real value for exponent
* @return complex number resulting from exponentiation
*/
	public static complex power(complex z, double n) {
		double mag = z.mag();
		double arg = z.arg();

		mag = Math.pow(mag, n);
		arg = arg * n;


		return new complex(Math.cos(arg)*mag,Math.sin(arg)*mag,false);
	}

/**
* <p> Finds some integer root of a complex number </p>
* @param z complex number to find root of
* @param k kth root to be taken
* @return array with all k complex roots
*/

	public static complex[] kroot(complex z, int k) {

		complex[] roots = new complex[k];

		double mag = mymethods.kroot(z.mag(),k,0.00001);
		double arg = z.arg();


		for (int i = 0; i < k; i++) {
			roots[i] = polar(mag, arg/k +(2 *i* Math.PI/k));
		}

	return roots;

	}

/**
* <p> Generates polar complex number from argument and magnitude </p>
* @param mag magnitude of complex number
* @param arg argument in radians of complex number
* @return complex number in cartesian form
*/
	public static complex polar(double mag, double arg) {
		return new complex(mag * Math.cos(arg), mag * Math.sin(arg), false);
	}

/**
* <p> Finds the solutions of any quadratic, even one with complex coefficients </p>
* @param a complex coefficient for x^2
* @param b complex coefficient for x
* @param c complex coefficient for the constant term
* @return array of complex and real solutions
*/
	public static complex[] solveQuadratic(complex a, complex b, complex c) {
		complex[] roots = new complex[2];
		complex FOUR = new complex(4,0,false);
		complex TWO = new complex(2,0,false);
		complex NEGATIVE_ONE = new complex(-1, 0 , false);


		complex radical = complex.subtract(complex.multiply(b,b),complex.multiply(complex.multiply(FOUR,a),c));
		complex[] disc = complex.kroot(radical,2);
		complex discriminant = disc[0];

		

		roots[0] = complex.divide(complex.add(complex.multiply(NEGATIVE_ONE,b),discriminant),complex.multiply(TWO, a));
		roots[1] = complex.divide(complex.subtract(complex.multiply(NEGATIVE_ONE,b),discriminant),complex.multiply(TWO, a));

		return roots;
		
	}

/**
* <p> Finds the cosine of a complex number </p>
* @param z complex number to find cosine of
* @return cosine of complex number z
*/
	public static complex complexcos(complex z) {
		double a = z.getReal();
		double b = z.getIm();

		complex ONE_HALF = new complex(0.5,0,false);
		complex CONSTANT_ONE = new complex(Math.exp(z.getIm()*-1),0,false);
		complex CONSTANT_TWO = new complex(Math.exp(z.getIm()),0,false);
		complex inner_one = new complex(Math.cos(a), Math.sin(a), false);
		complex inner_two = new complex(Math.cos(a),-1*Math.sin(a), false);

		return complex.multiply(ONE_HALF,complex.add(complex.multiply(CONSTANT_ONE,inner_one),complex.multiply(CONSTANT_TWO,inner_two)));

	}

/**
* <p> Finds the sin of a complex number </p>
* @param z complex number to find sin of
* @return sin of complex number z
*/
	public static complex complexsin(complex z) {
		double a = z.getReal();
		double b = z.getIm();

		complex ONE_HALF = complex.divide(new complex(1,0,false), new complex(0,2,false));
		complex CONSTANT_ONE = new complex(Math.exp(z.getIm()*-1),0,false);
		complex CONSTANT_TWO = new complex(Math.exp(z.getIm()),0,false);
		complex inner_one = new complex(Math.cos(a), Math.sin(a), false);
		complex inner_two = new complex(Math.cos(a),-1*Math.sin(a), false);

		return complex.multiply(ONE_HALF,complex.subtract(complex.multiply(CONSTANT_ONE,inner_one),complex.multiply(CONSTANT_TWO,inner_two)));

	}

/**
* <p> Finds the natural log of a complex number </p>
* @param z complex number to find natural log of
* @return natural log of complex number z
*/
	public static complex complexln(complex z) {
		complex r = new complex(Math.log(z.mag()), 0, false);
		complex theta = new complex(0, Math.atan(z.getIm()/z.getReal()), false);
		return complex.add(r, theta);
	}

/**
* <p> Finds the value of a complex number to the power of another complex number</p>
* @param z complex number that is the base
* @param w complex number that is the exponent
* @return result of complex exponentiation
*/
	public static complex complexpow(complex z, complex w) {
		complex exponent = complex.multiply(w, complex.complexln(z));
		complex solution = complex.polar(Math.exp(exponent.getReal()),exponent.getIm());
		return solution;
	}

/**
* <p> Finds the value of ther arc cosine of a complex number</p>
* @param z complex number to find arc cosine of
* @return result of taking the complex arccosine
*/
	public static complex complexarccos(complex z) {
		complex NEGATIVE_I = new complex(0, -1, false);
		complex ONE = new complex(1,0,false);
		complex[] RADICALS = kroot(complex.subtract(complex.multiply(z,z),ONE),2);
		complex radical = RADICALS[0];
		complex log = complex.add(z, radical);
		complex secondLast = complexln(log);
		complex answer =complex.multiply(NEGATIVE_I, secondLast);
		return answer;
	}


/**
* <p> Finds the value of ther arc sin of a complex number</p>
* @param z complex number to find arc sin of
* @return result of taking the complex sin
*/
	public static complex complexarcsin(complex z) {
		complex NEGATIVE_I = new complex(0, -1, false);
		complex _I_ = new complex(0, 1, false);
		complex ONE = new complex(1,0,false);
		complex NEGATIVE_ONE = new complex(-1,0,false);
		complex[] RADICALS = kroot(complex.add(complex.multiply(complex.multiply(z,z), NEGATIVE_ONE),ONE),2);
		complex radical = RADICALS[1];
		complex log = complex.add(complex.multiply(z,_I_), radical);
		complex secondLast = complexln(log);
		complex answer =complex.multiply(NEGATIVE_I, secondLast);
		return answer;
	}	

}