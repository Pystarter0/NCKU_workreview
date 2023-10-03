package Company; 

abstract class Employee{
	private String name;
	private int id;
	private double salary;
	String jobTitle; //可用getclass代替
	Employee(String name,int id,double salary){
		this.name=name;
		this.id=id;
		this.setSalary(salary);
	}
	void setSalary(double num) { //因為有機率用到加成%數，所以應該是用double
		this.salary=num;
	}
	String getName() {
		return this.name;
	}
	int getId() {
		return this.id;
	}
	double getSalary() {
		return this.salary;
	}
	String getJobTitle() {
		return this.jobTitle;
	}
	abstract void display(); //abstract方程
}

class Manager extends Employee{
	double bonusPercentage; //獎勵%數
	Manager(String name,int id,double salary,double bonusPercentage){
		super(name,id,salary); //繼承name,id,salary
		this.jobTitle="Manager";
		setBonusPercentage(bonusPercentage); //用放入的獎勵設定
	}	
	void setBonusPercentage(double bonusPercentage) {
		this.bonusPercentage=bonusPercentage;
	}
	double getBonusPercentage() {
		return this.bonusPercentage;
	}
	void display() { //最後輸出時不再調整salary //abstract實作
		this.setSalary(this.getSalary()*(1+this.getBonusPercentage())); //設定最後的金額
		System.out.println("Name: "+this.getName());
		System.out.println("ID: "+this.getId());
		System.out.print("Salary(after adjustment): $");
		System.out.printf("%.1f",this.getSalary()); //到小數一位
		System.out.println();
		System.out.println("Job Title: "+this.getJobTitle());
		System.out.println("Bonus Percentage: "+this.getBonusPercentage());
	}
}

class Engineer extends Employee{
	int numProjects; 
	Engineer(String name,int id,double salary,int numProjects){
		super(name,id,salary);
		this.jobTitle="Engineer";
		setNumProjects(numProjects);
	}
	void setNumProjects(int numProjects) {
		this.numProjects=numProjects;
	}
	int getNumProjects() {
		return this.numProjects;
	}
	void display() { //最後輸出時不再調整salary //abstract實作
		this.setSalary(this.getSalary()+1000*this.getNumProjects());
		System.out.println("Name: "+this.getName());
		System.out.println("ID: "+this.getId());
		System.out.print("Salary(after adjustment): $");
		System.out.printf("%.1f",this.getSalary());
		System.out.println();
		System.out.println("Job Title: "+this.getJobTitle());
		System.out.println("Number of Projects: "+this.getNumProjects());
	}
}

class Salesperson extends Employee{
	double salesAmount;
	Salesperson(String name,int id,double salary,double salesAmount){
		super(name,id,salary); 
		this.jobTitle="Salesperson";
		setsalesAmount(salesAmount); 
	}
	void setsalesAmount(double salesAmount) {
		this.salesAmount=salesAmount;
	}
	double getsalesAmount() {
		return this.salesAmount;
	}
	void display() { //abstract實作
		this.setSalary(this.getSalary()+salesAmount*0.01);
		System.out.println("Name: "+this.getName());
		System.out.println("ID: "+this.getId());
		System.out.print("Salary(after adjustment): $");
		System.out.printf("%.1f",this.getSalary());
		System.out.println();
		System.out.println("Job Title: "+this.getJobTitle());
		System.out.println("Sales Amount: $"+this.getsalesAmount());
	}
}

public class HW5_4109054013 {
	public static void main(String args[]) {
		Employee emps[]=new Employee[3]; //Manager,Engineer,Salesperson皆為Employee延伸，因此可放入Employee物件陣列
		emps[0]=new Manager("John Wick",1234,50000,0.1); 
		emps[1]=new Engineer("John Doe",5678,60000,3);
		emps[2]=new Salesperson("Bob Johnson",9012,40000,100000);
		System.out.println("Employee List: ");
		System.out.println();
		for (int i=0;i<3;i++) {
			emps[i].display();
			System.out.println("");
		}
	}
}
