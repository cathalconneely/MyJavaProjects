package Part2;

public class NumFloat implements Num {
	
	Float d; 
	 
	 public NumFloat(Float d) { 
	 this.d = d; 
	 } 
	 
	 @Override 
	 public void neg() { 
	 d = -d; 
	 } 
	 
	 @Override 
	 public void sqrt() { 
	 d = (float) Math.sqrt(d); 
	 } 
	 
	 @Override 
	 public String asString() { 
	 return d.toString(); 
	 } 


}
