package Lab10;

public class Custom {
	public static void main(String[] args) {
		Customer customer = new Customer("Male","XL","Black",32);
	}
}
class Customer {
	private String Gender;
  
	public Customer(String Gender, String Size, String Color, int Waistline) {
		this.Gender=Gender;
		Clothes clothes=new Clothes(Size,Color);
		Pants pants=new Pants(Waistline);
		ShowInfo(clothes,pants);
	}
  
	private class Clothes{
		private String Size;
		private String Color;
        Clothes(String Size,String Color){
        	this.Color=Color;
        	this.Size=Size;
        }
        public String getColor() {
        	return this.Color;
        }
        public String getSize() {
        	return this.Size;
        }
	}
	private class Pants{
		private int Waistline;
		Pants(int Waistline){
			this.Waistline=Waistline;
		}
		public int getWaistline() {
			return this.Waistline;
		}
	}
  
	private void ShowInfo(Clothes clothes, Pants pants) {
		System.out.println("Gender:"+this.Gender);
		System.out.println("Size:"+clothes.getSize());
		System.out.println("Color:"+clothes.getColor());
		System.out.println("Waistline:"+pants.getWaistline());
	}
}
