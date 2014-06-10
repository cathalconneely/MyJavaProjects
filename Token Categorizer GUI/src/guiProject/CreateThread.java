package guiProject;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class CreateThread extends Thread{ // extends thread class to allow multi threading
	  
	  // declare variables
	  String myFile;
	  String myLanguage;
	  String myCountry;
	  
	  //constrcutor
	  public CreateThread(String f, String l, String c) {
		  
              myFile=f;
	      myLanguage=l;
	      myCountry=c;
	  }


          // override run() method with method to read in file and categorize tokens
          public void run(){

               Locale myLocale = new Locale(myLanguage, myCountry); // create locale
               // Create three lists -  one to contain strings, one to contain integers, and one to contain real numbers
               ArrayList<String> stringList = new ArrayList<String>();
               ArrayList<Long> intList = new ArrayList<Long>();
               ArrayList<Double> doubleList = new ArrayList<Double>();

               Scanner fileIn = null; // Create Scanner

               try {
        	      // Use scanner to read in file
                      fileIn = new Scanner(new BufferedReader(new FileReader(myFile)));

                      fileIn.useLocale(myLocale); // use locale on read in contents of file
             
                      // while file has next token
                      while (fileIn.hasNext()) {
                           
                           // if scanner has next int
                          if (fileIn.hasNextInt()) {
                              intList.add(fileIn.nextInt()); // add to int array list
                          } else if (fileIn.hasNextDouble()) { // else if scanner has next double
                              doubleList.add(fileIn.nextDouble()); // add to double arraylist
                          } else { // else add others to string array list
                            stringList.add(fileIn.next());
                        }

                    }

                 } catch (FileNotFoundException e) {

		        	e.printStackTrace();
		} finally {
        	           fileIn.close(); // close scanner
                  }
               
               // Declare and create new JFrame object
               CreateFrame jframe = new CreateFrame(myFile, myLanguage, myCountry);
              
              /*
               * call populateTable() method which takes the three arraylists of different types (string, int, double) as parameters
               */
             
              jframe.populateTable(stringList, doubleList, intList);
              jframe.setVisible(true);
      
    } // end run()

} // end class CreateThread
