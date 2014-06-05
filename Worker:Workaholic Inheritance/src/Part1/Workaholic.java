package Part1;

public class Workaholic extends Worker { // inherits from Worker class
     
	 // Data members
	 public static final int OVERTIME = 500; // hours overtime per year
	 public double hourlyIncome;
	 public int age;
	 public double earned;
	 public String name;
	 
	 // Constructor for workaholic class. Constructor has 3 paramters.
	 public Workaholic(String name, double hourlyIncome, int age){
		 super(name, hourlyIncome, age, null); // coWorker attribute of super constructor is null in this instance
		 this.hourlyIncome = hourlyIncome; // hourlyIncome for Workaholic objects
		 this.name=name; // name for Workaholic object
			 } 
	 // method overrides work method in Worker class to calculate earned field for Workaholic objects
	 @Override
	 public void work(double years) { 
		 earned += (2000 + OVERTIME) * years * hourlyIncome; 
		 } 
	 
		// method overrrides Worker info() method to return Workaholic string name and earned
	 @Override
	 public String info() { 
		 return name + " earned " + earned; 
		 } 
		
	 
} // end class