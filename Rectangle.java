package shaper;
public class Rectangle extends Shape {
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
