package NBGardens;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
  * 
 * @author Andrew Claybrook
 * 
 * Class for creation of the Add Customer Order JFrame GUI with associated components. This class is called from the MainGUI class when the 
 * actionhandler for the Add Customer Order button is triggered.
 *
 */


public class CustomerOrderGUI extends JFrame {
	
	/**
	 * 
	 * The comboBoxGetter methods below are used to populate the comboBoxes for Items, Operative and Customers with the current list of stored
	 * items, operatives and customers in their respective ArrayLists
	 * 
	 * @return - StringArrays that are the length of current items, operatives or customers containing strings of said items.
	 */
	
	
	public String[] comboBoxGetterItems(){
		String[] tempStringArray = new String[Main.inventoryList.size()]; // New string array created that is the length of total items in the item array list
		for(int i=0; i < Main.inventoryList.size(); i++) {
			
			tempStringArray[i] = Integer.toString(i+1) + " - " + Main.inventoryList.get(i).getItemName(); // For loop to iterate through item array list get ID and Item Name, saving this to a String within the string array
		}
		return tempStringArray;
	}
	
	public String[] comboBoxGetterOperative(){
		String tempString = "";

		for(int i=0; i < Main.personList.size(); i++){
			if (Main.personList.get(i).getPerson() instanceof WarehouseOperative){
				WarehouseOperative tempOperative = (WarehouseOperative) Main.personList.get(i).getPerson();
				
				tempString += Integer.toString(Main.personList.get(i).getId()) + " - " + tempOperative.getName()+ ",";
			}
		}
		String[] tempStringArray = tempString.split(",");
		return tempStringArray;
	}
	
	public String[] comboBoxGetterCustomer(){
		String tempString = "";
		
		for(int i=0; i < Main.personList.size(); i++){													 // As customer objects are contained in the personList array as a person list object we iterate through
			if (Main.personList.get(i).getPerson() instanceof Customer){								// the personList array for object that are instances of the Customer class. These are then	
				Customer tempCustomer = (Customer) Main.personList.get(i).getPerson();					// temporarily cast back to Customer objects and ID and Name are got and assigned to a temporary string
				
				tempString += Integer.toString(tempCustomer.getId()) + " - " + tempCustomer.getName()+ ",";
				
			}
		}
		String[] tempStringArray = tempString.split(","); //String is then converted to a String Array using the comma appended on the end as a separator
		return tempStringArray;
	}
	
	/**
	 * 
	 * Method for converting a String of ints to an int array. This is needed as items in orders are stored as an array of ints and the add button takes the first char of the comboBox selection
	 * (which is the ID of the item) and adds this to a string (with a comma to separate them)
	 * 
	 * So this first creates a string array and then iterates through this string array to parse each elements as an int which is stored in a new int array. This is then returned
	 * 
	 * 
	 * @param stringToConvert - String of integers with commas separating these integers
	 * @return newIntArray - New int array of item ids
	 */
	
	public int[] stringToIntArray(String stringToConvert){
		
		String[] tempStringArray = stringToConvert.split(",");
		int[] newIntArray = new int[tempStringArray.length];
		for (int i=0; i < tempStringArray.length; i++){
			newIntArray[i] = Integer.parseInt(tempStringArray[i]);
		}
		
		return newIntArray;
	}

	
	/**
	 * 
	 * private JPanel and strings declared here to allow other methods and listeners within this class to access these variables
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private String selectedOrderItems = "";
	private String selectedPorusItems = "";

/**
 *  * CustomerOrderGUI method which creates and draws the main GUI Panel and associated labels, comboBoxes and buttons
 * 
 */
	public CustomerOrderGUI() {
		setTitle("Add Customer Order");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Closes this instance of the GUI but does not terminate the entire process
				
		/**
		 * 
		 * Label, ComboBox and Add button for adding an Item to an order.
		 * ComboBox is populated using the comboBoxGetterItems() method created earlier
		 * 
		 * MouseListener is added to the add button with a mousePressed actionListener, on press the index int of the combo box is added to
		 * the selectedOrderItems string with a comma to separate. A 1 is added to this result to account for the index counting from 0.
		 * 
		 */
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setBounds(82, 14, 51, 14);
		contentPane.add(itemLabel);
		
		JComboBox<Object> itemComboBox = new JComboBox<Object>();
		itemComboBox.setBounds(143, 14, 150, 20);
		itemComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterItems()));
		contentPane.add(itemComboBox);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(324, 14, 65, 23);
		contentPane.add(addButton);
		
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedOrderItems += (itemComboBox.getSelectedIndex()+1) + ",";
				
			}
		});
		
		
		/**
		 * 
		 * Label and ComboBox for assigning a customer to an order.
		 * ComboBox is populated using the comboBoxGetterCustomer() method created earlier
		 *  
		 */
		
		JLabel customerLabel = new JLabel("Customer");
		customerLabel.setBounds(64, 68, 69, 14);
		contentPane.add(customerLabel);
		
		JComboBox<Object> customerComboBox = new JComboBox<Object>();
		customerComboBox.setBounds(143, 67, 150, 20);
		customerComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterCustomer()));
		contentPane.add(customerComboBox);
		
		/**
		 * 
		 * Label and ComboBox for assigning an employee to an order.
		 * ComboBox is populated using the comboBoxGetterOperative() method created earlier
		 *  
		 */
		
		JLabel employeeLabel = new JLabel("Employee");
		employeeLabel.setBounds(64, 120, 69, 14);
		contentPane.add(employeeLabel);
		
		JComboBox<Object> employeeComboBox = new JComboBox<Object>();
		employeeComboBox.setBounds(143, 119, 150, 20);
		employeeComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterOperative()));
		contentPane.add(employeeComboBox);
		
		/**
		 * 
		 * Label, ComboBox and Add button for adding a porusware item to an order.
		 * ComboBox is populated using the comboBoxGetterItems() method created earlier
		 * 
		 * MouseListener is added to the add button with a mousePressed actionListener, on press the index int of the combo box is added to
		 * the selectedPorusItems string with a comma to separate. A 1 is added to this result to account for the index counting from 0.
		 * 
		 */
		
		JLabel poruswareLabel = new JLabel("Porusware");
		poruswareLabel.setBounds(64, 173, 69, 14);
		contentPane.add(poruswareLabel);
		
		JComboBox<Object> poruswareComboBox = new JComboBox<Object>();
		poruswareComboBox.setBounds(143, 172, 150, 20);
		poruswareComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterItems()));
		contentPane.add(poruswareComboBox);
		
		JButton poruswareAddButton = new JButton("Add");
		poruswareAddButton.setBounds(324, 173, 65, 23);
		poruswareAddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedPorusItems += (itemComboBox.getSelectedIndex()+1) + ",";
			}
		});
		contentPane.add(poruswareAddButton);
		
		/**
		 * 
		 * Confirm button for the entire GUI window. On mousePress this calls the stringToIntArray() method for the 
		 * Order and Porus Item strings to convert to int arrays.
		 * 
		 * A new Customer Order object is created and these arrays are added to this object along with the selected index of the combo boxes
		 * for both the customer and warehouse operative IDs. 1 is added to this to account for the index counting from 0.
		 * 
		 * An empty OrderLine object is then created to call the addOrder method to add the new CustomerOrder object to the Main OrderList Array.
		 * 
		 * Dispose() is then called to close the GUI without terminating the entire process.
		 * 
		 */
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(107, 228, 95, 23);
		contentPane.add(confirmButton);
		
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int[] tempOrderArray = stringToIntArray(selectedOrderItems);
				int[] tempPorusArray = stringToIntArray(selectedPorusItems);
	
				
				CustomerOrder corder = new CustomerOrder(tempOrderArray, customerComboBox.getSelectedIndex()+1, tempPorusArray, employeeComboBox.getSelectedIndex()+1);
				
				OrderLine order = new OrderLine();
				
				order.addOrder(corder, Main.orderList);
				
				dispose();
								
			}
		});
		
		/**
		 * Cancel button is created and added to main Pane. This contains a MousePressed action which simply disposes of the GUI process
		 * 
		 */
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				dispose();
				
			}
		});
		cancelButton.setBounds(212, 228, 95, 23);
		contentPane.add(cancelButton);
				
	}

}
