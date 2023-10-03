package PointsAndLines;

import java.lang.Math;
class PAL{
	public static void main(String args[]) {
		Point p1 = new Point(0.0, 0.0);
		Point p2 = new Point(3.0, 4.0);
		Point p3 = new Point(3.0, 0.0);
		Point p4 = new Point(0.0, 4.0);

		// 建立兩個Line實例
		Line line1 = new Line(p1, p2);
		Line line2 = new Line(p3, p4);

		// 使用getLength()方法取得線段的長度
		System.out.println("Line1 的長度: " + line1.getLength());
		System.out.println("Line2 的長度: " + line2.getLength());

		// 使用getIntersection()方法取得兩線段的交點
		Point intersection = line1.getIntersection(line2);
		System.out.println("Line1 和 Line2 的交點: (" + intersection.getX() + ", " + intersection.getY() + ")");

		/* 上述程式碼執行結果如下:
		Line1 的長度: 5.0
		Line2 的長度: 5.0
		Line1 和 Line2 的交點: (1.5, 2.0)
		 */
	}
}
class Point { //點
    double x;
  	double y;

    public Point(double x, double y) {
        this.x=x;
      	this.y=y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getDistance(Point p) {
        double dis=(p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y);
      	dis=Math.sqrt(dis);
      	return dis;
    }
}

class Line { //線
  	double x1;
  	double x2;
  	double y1;
  	double y2;
  	Point p1;
  	Point p2;
  
    public Line(Point p1, Point p2) { //存入點的資料
  		this.x1=p1.x;
      	this.x2=p2.x;
      	this.y1=p1.y;
      	this.y2=p2.y;
    }

    public Line(Point p1) {
    	this.x1=0;
      	this.x2=p1.x;
      	this.y1=0;
      	this.y2=p1.y;
    }

    public double getLength() {
        double len=(this.x1-this.x2)*(this.x1-this.x2)+(this.y1-this.y2)*(this.y1-this.y2);
      	len=Math.sqrt(len);
      	return len;
    }

    public Point getIntersection(Line l) { //交會點(線與線)
      double ua=(l.x2-l.x1)*(this.y1-l.y1)-(l.y2-l.y1)*(this.x1-l.x1);
      ua/=((l.y2-l.y1)*(this.x2-this.x1)-(l.x2-l.x1)*(this.y2-this.y1));
      double ub=(this.x2-this.x1)*(this.y1-l.y1)-(this.y2-this.y1)*(this.x1-l.x1);
        ub/=((l.y2-l.y1)*(this.x2-this.x1)-(l.x2-l.x1)*(this.y2-this.y1));
        double inx=this.x1+ua*(this.x2-this.x1);
        double iny=this.y1+ub*(this.y2-this.y1);
      Point poin=new Point(inx,iny);
      return poin;
    }
}