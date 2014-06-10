package guiProject;


import java.util.Scanner;

public class TokenCategorizerDriver {
	
	public static void main(String[] args) {
		
		//create the tread
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file path: ");
		String myfile = in.next(); // read file input string
		
		System.out.println("Enter language code (e.g en): ");
		String mylanguage = in.next(); // read user input language code
		
		System.out.println("Enter country code (e.g. US): ");
		String mycountry = in.next(); // read user input country code
		
		// Create new thread
		CreateThread myThread =new CreateThread(myfile, mylanguage, mycountry);
		myThread.start();//start thread
		in.close(); // close input scanner

	}

}

