public class circle extends shape {
	public double radius;

	public circle(double radius) {
		this.radius = radius;
	} 

	public double area() {
		return (Math.PI * radius * radius);
	}

	public double perimeter() {
		return (Math.PI * 2 * radius);
	}
}