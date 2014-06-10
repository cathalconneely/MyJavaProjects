package guiProject;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateFrame extends javax.swing.JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    // variables Declaration
    public JOptionPane myJOptionPane;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem itemOpen;
    private JMenuItem itemQuit;
    private String myFile;
    private String myLang;
    private String myCountry;

     //constructor
    public CreateFrame(final String myFile, final String myLang, final String myCountry) {
        
    this.myFile = myFile;
    this.myLang= myLang;
    this.myCountry = myCountry;
    initComponents();// calls initializeComponents() method
    }

    // method to initialize components
    private void initComponents() {
    	
    	// Define variables
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new JList<String>();
        
        // Set default close operation for frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        // set model for jTable1 with a new DefaultTableModel
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        		// Create 2d array for rows and columns in table
        		new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] { // create string for default column headers/title
                "Title 1", "Title 2", "Title 3"
            }
        ));
        
        
        // Declare and create container object for whole frame
        Container content =  getContentPane ();
        // Declare and create JPanel and set layout. JPanel will be user inside frame to contain JTable and JList within the
        JPanel p = new JPanel(new GridLayout(1,2));// GridLayout manages container cmoponenets layout. Set side by side.
        this.setSize(800, 600); // set size of frame
         
        jScrollPane1.setViewportView(jTable1); // set viewport of jscrollpane1 with jTable1

        jScrollPane2.setViewportView(jList1); // sets viewport of jscrollpane2 with jList1
        
        // Create menubar
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);// set menu bar in this frame
        
        // create JMenu named file
        menuFile = new JMenu("File");
        menuBar.add(menuFile);// add menuFile to menu bar
        
        // Create menu item open
        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);// add action listener to this item
        menuFile.add(itemOpen);// add item to menu
        
        // create menu item Quit
        itemQuit = new JMenuItem("Quit");
        itemQuit.addActionListener(this); // add action listener
        menuFile.add(itemQuit); // add item to menu
          
        p.add(jScrollPane1);    // add jScrollPane1 to JPanel p    
        p.add(jScrollPane2);    // add jScrollPane2 to JPanel p
     
        content.add(p);// add JPane p to content container	      
    
    }
    
    
    // implement actionPerformed method to handle menu event
    public void actionPerformed(ActionEvent e) {
    	 
    	// create string to compare against menu commands
        String command = e.getActionCommand();

        if (command.equals("Quit")) {// if menu command is "Quit"
            System.exit(0); // exit program
        } 
        
        else if (command.equals("Open")) {// else if menu command is"Open"
            
            
            myJOptionPane =new JOptionPane();//create an option panel
			//read the file name via the option panel
			String file = (String) JOptionPane.showInputDialog(CreateFrame.this, "Enter new File Path", "Open new file", JOptionPane.QUESTION_MESSAGE );
			        // if new file path string is not empty make this frame invisible
					if(file!=null){
					Thread.currentThread().interrupt();
					CreateFrame.this.setVisible(false);
					//create new thread when choosing new file
					CreateThread th=new CreateThread(file, myLang, myCountry);
					th.start();}
        }
			
        
    }
    

    // This method is use to populate the JList with all possible permutations when a row in the JTable is selected
    public void populateJList(ArrayList<String> myStringArr) { // takes arraylist of type string as parameter which will contain content
       
    	      // Declare and create DefaultListModel of type string to take and model contents of string arraylist 
    	      DefaultListModel<String> myJListModel = new DefaultListModel<String>();
             if (myStringArr.size() == 1) { // if row contains one element
                   myJListModel.addElement(myStringArr.get(0)); // add the single element to the list model
             }
             
             if (myStringArr.size() == 2) { // if row contains 2 elements
                  myJListModel.addElement(myStringArr.get(1) + ", " + myStringArr.get(0)); // add elements at positions 1 and 0
                  myJListModel.addElement(myStringArr.get(0) + ", " + myStringArr.get(1)); // add elements at positions 0 and 1
        
             }
        
             if (myStringArr.size() == 3) { // if row contains three elements
                  myJListModel.addElement(myStringArr.get(0) + ", " + myStringArr.get(1) + ", " + myStringArr.get(2)); // add all elements in all possible combinations
                  myJListModel.addElement(myStringArr.get(0) + ", " + myStringArr.get(2) + ", " + myStringArr.get(1));
                  myJListModel.addElement(myStringArr.get(1) + ", " + myStringArr.get(0) + ", " + myStringArr.get(2));
                  myJListModel.addElement(myStringArr.get(1) + ", " + myStringArr.get(2) + ", " + myStringArr.get(0));
                  myJListModel.addElement(myStringArr.get(2) + ", " + myStringArr.get(0) + ", " + myStringArr.get(1));
                  myJListModel.addElement(myStringArr.get(2) + ", " + myStringArr.get(1) + ", " + myStringArr.get(0));
              }
        
             jList1.setModel(myJListModel); // set jList1 model as DefaultListModel

    }
    
    
    // Method to populate table cells. Takes 3 arraylists of types string double and integer as parameters
    public void populateTable(ArrayList<String> stringAL, ArrayList<Double> doubleAL, ArrayList<Integer> intAL) {
        
    	     try {
	             // set cross-platform default look and feel
	             UIManager.setLookAndFeel(
	                 UIManager.getCrossPlatformLookAndFeelClassName());
	      
	    	     
             } catch (ClassNotFoundException ex) {
                      System.out.println(ex);
             } catch (InstantiationException ex) {
        	          System.out.println(ex);
             } catch (IllegalAccessException ex) {
        	          System.out.println(ex);
             } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	          System.out.println(ex);
             }

             // Declare and create DefaultTableModel for jTable1
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
             // Create string array to hold column header names
             String[] columnHeader = new String[]{"Other tokens", "Integral numbers", "Real numbers"};
             model.setColumnIdentifiers(columnHeader); // sets column names in DefaultTableModel model
        
             // Create and initialize int variable MAX_SIZE
             // use to set number of rows in table
             int MAX_SIZE = 0; 
        
                   // if string arraylist is greater than or equal to double araylist and int array list then MAX_SIZE equals size of string arraylist
                   if (stringAL.size() >= doubleAL.size() && stringAL.size() >= intAL.size()) {
                       MAX_SIZE = stringAL.size();
                   }
       
                   // if int arraylist is greater than or equal to other 2 arraylists then MAX_SIZE equals int arraylist size
                   if (intAL.size() >= doubleAL.size() && intAL.size() >= stringAL.size()) {
                       MAX_SIZE = intAL.size();
                   }
        
                    // if double arraylist is greater than or equal to other 2 arraylists then MAX_SIZE equals double arraylist size
                    if (doubleAL.size() >= stringAL.size() && doubleAL.size() >= intAL.size()) {
                       MAX_SIZE = doubleAL.size();
                   }
        
                   model.setNumRows(MAX_SIZE); // set number of rows using MAX_SIZE
        
           // Populate rows
           int stringPos = 0; //  variable created and initialized. Use to fill rows in "Other Tokens" colums
        
                  for (String s : stringAL) {            // Enhanced for loop used to traverse elements in araylist 
                      model.setValueAt(s, stringPos, 0); // and set cell values with string elements in column with index 0
                      stringPos++; // increments to fill all appropriate cells in column
                  }

           int intPos = 0; // same method as above used to fill appropriate cells in integer column
        
                  for (int i : intAL) {
                      model.setValueAt(i, intPos, 1);
                      intPos++;
                  }

           int doublePos = 0; // same method as above used to fill cells of "Real Number" column
        
                  for (double d : doubleAL) {
                      model.setValueAt(d, doublePos, 2);
                      doublePos++;
                  }
        
           jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // set selection mode to allow only one row
        
           // add event listener for mouse on jTable1
           jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) { // When mouse is clicked on row
               
            	ArrayList<String> rowArr = new ArrayList<String>(); // Declare and create string arraylist to contain row contents
                // Create variables of 3 possible types that may be in a row
                String rowStr; 
                int rowInt;
                double rowDouble;

                int selectedRowIndex = jTable1.getSelectedRow(); // Create int variable to contain selected row index
                
                   // if value in selected row and column of index 0 (string column) is not empty
                   if (jTable1.getValueAt(selectedRowIndex, 0) != null) {
                         rowStr = (String) jTable1.getValueAt(selectedRowIndex, 0); // get cell values and contain in rowStr
                         rowArr.add(rowStr); // add to arraylist
                    }
                
                    // if value in selected row and column of index 1 (integer column) is not empty
                    if (jTable1.getValueAt(selectedRowIndex, 1) != null) {
                         rowInt = (Integer) jTable1.getValueAt(selectedRowIndex, 1); // get cell values 
                         rowArr.add(String.valueOf(rowInt)); // add to arraylist as string
                    } 
                    
                    // if value in selected row and column od index 2 (real numbers) is not empty
                    if (jTable1.getValueAt(selectedRowIndex, 2) != null) {
                         rowDouble = (Double) jTable1.getValueAt(selectedRowIndex, 2); // get cell values
                         rowArr.add(String.valueOf(rowDouble)); // add to array list as string
                    }
                 
               
                   populateJList(rowArr); // call method on selected rowArr which contains elements of selected row to populate JList
            }
        });
    }
} // end class
