package SHAPER_complete_ver;

public class Main {
	public static void main(String[] args) {
		Oval oval = new Oval(5,3,"blue");
		oval.showInfo();
		
		Rectangle rec = new Rectangle(5,5,"");
		rec.showInfo();
	}
}

class Shape {
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
class Oval extends Shape {
	int major;
  	int minor;
  	double PI=3.14;
  	String color;
    public Oval(int major,int minor,String color){
      this.major=major;
      this.minor=minor;
      this.setName("橢圓形");
      if (major==minor){
        this.setName("圓形");
      }
      this.setArea(major*minor*PI);
      this.setPerimeter(2*PI*minor+4*(major-minor));
      this.setcolor(color);
    }
  	public void showInfo(){
      System.out.println("形狀:"+this.getName());
      System.out.print("面積:");
      System.out.printf("%.2f",this.getArea());
      System.out.println();
      System.out.print("周長:");
      System.out.printf("%.2f",this.getPerimeter());
      System.out.println();
      System.out.println("顏色: "+this.getcolor());
    }
}
class Rectangle extends Shape {
	int width;
	int height;
	String name;
	String color;
  	double area;
  	public Rectangle(int width,int height,String color) {
  		this.width=width;
  		this.height=height;
  		if (width==height) {
  			this.setName("正方形");
  		}
  		else {
  			this.setName("長方形");
  		}
  		this.setcolor(color);
  		this.setArea(width*height);
        this.setPerimeter(2*(width+height));
  	}
  	public void showInfo(){
        System.out.println("形狀:"+this.getName());
        System.out.print("面積:");
        System.out.printf("%.2f",this.getArea());
        System.out.println();
        System.out.print("周長:");
        System.out.printf("%.2f",this.getPerimeter());
        System.out.println();
        System.out.println("顏色: "+this.getcolor());
      }
}