public class square extends rectangle {
	public square(double s) {
		super(s,s);
	}

	public double perimeter() {
		return(2*this.getA() + 2*this.getB());
	}

}