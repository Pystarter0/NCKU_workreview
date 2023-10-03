package shaper;

public class Shape {
	private String name;
	private double area;
	private double perimeter;
	private String color;
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected void setcolor(String s) {
		if (s=="") {
			this.color="red";
		}
		else {
			this.color=s;
		}
	}
	protected String getcolor() {
		return this.color;
	}
	protected double getArea() {
		return area;
	}
	protected void setArea(double area) {
		this.area = area;
	}
	protected double getPerimeter() {
		return perimeter;
	}
	protected void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
}
