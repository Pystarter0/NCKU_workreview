package shaper;
public class Oval extends Shape {
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
