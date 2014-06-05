package Part1;

public class Worker {
	
	 /* Forbidden to modify this class which was provided in the assignment description.*/
	
	 public static final int RETIREMENT_AGE = 65; 
	 private String name = null; 
	 private int age = 0; 
	 private double earned = 0; 
	 private double hourlyIncome = 0; 
	 public int hoursPerYear = 1600; 
	 private Worker coWorker = null; 
	 
	 public Worker(String name, double hourlyIncome, int age, Worker coWorker) { 
	 this.name = name; 
	 this.hourlyIncome = hourlyIncome; 
	 this.age = age; 
	 this.coWorker = coWorker; 
	 } 
	 
	 public void work(double years) { 
	 earned += hoursPerYear*years*hourlyIncome; 
	 if (coWorker != null) 
	 delegate(years/5f); 
	 } 
	 
	 public void work() { 
	 work(RETIREMENT_AGE - age); 
	 } 
	 
	 private void delegate(double years) { 
	 coWorker.work(years); 
	 } 
	 
	 public String info() { 
	 return name + " earned " + earned;
	 
	 } 
	 
	 public static void main(String[] args) { 
	 Worker luke = new Worker("Luke", 9, 23, null); 
	 Worker sarah = new Worker("Sarah", 25, 27, luke); 
	 
	 Workaholic bill = new Workaholic("Bill", 30, 35);
	 sarah.work(); 
	 luke.work(); 
	 bill.work(); 
	 System.out.println(sarah.info()); 
	 System.out.println(luke.info()); 
	 System.out.println(bill.info()); 
	 }



}
