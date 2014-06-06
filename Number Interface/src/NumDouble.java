package Part2;

public class NumDouble implements Num {

	Double d; 
	 
	 public NumDouble(Double d) { 
	 this.d = d; 
	 } 
	 
	 @Override 
	 public void neg() { 
	 d = -d; 
	 } 
	 
	 @Override 
	 public void sqrt() { 
	 d = Math.sqrt(d); 
	 } 
	 
	 @Override 
	 public String asString() { 
	 return d.toString(); 
	 } 

}
