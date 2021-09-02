public abstract class shape {

	private String color;
	private String name;
	private boolean isFilled;

	abstract double perimeter();
	abstract double area();

	public shape() {
		color = "white";
		isFilled = false;
		name = "unknown";
	}
}