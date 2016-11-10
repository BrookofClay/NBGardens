package NBGardens;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

/**
 *  * Main class of NBGardens package. Program initialised here and main GUI elements are declared and added to main JFrame here * 
 *
 */

public class Main {
	
	/**
	 * 
	 * Main global ArrayLists are declared here to contain all order, item, person and location items
	 * 
	 */
	
	public static ArrayList<InventorySystem> inventoryList = new ArrayList<InventorySystem>();
	public static ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
	public static ArrayList<PersonLine> personList = new ArrayList<PersonLine>();
	public static ArrayList<Location> locationList = new ArrayList<Location>();
	
	
	JFrame nbGardensInventory; // JFrame initialised here to allow access to main JFrame through entire Main class
	
	
	/**
	 * 
	 * The comboBoxGetter methods below are used to populate the comboBoxes for Items, Operative and Customers with the current list of stored
	 * items, operatives and customers in their respective ArrayLists
	 * 
	 * @return - StringArrays that are the length of current items, operatives or customers containing strings of said items.
	 */
	
	public String[] comboBoxGetter(ArrayList<?> list){
		String[] tempStringArray = new String[list.size()];
		for(int i=0; i < list.size(); i++) {
			
			tempStringArray[i] = Integer.toString(i+1);
		}
		return tempStringArray;
	}
	
	/**
	 * 
	 * personCheck method used to determine if customer being deleted from system is still assigned to an order.
	 * 
	 * This checks the ID passed against the IDs stored and if true changes checkResponse boolean to true
	 * @param id - ID to check against
	 * @return - boolean true\false depending on result
	 */
	
	public boolean personCheck(int id) {
		CustomerOrder tempCust = new CustomerOrder();
		Boolean checkResponse = false;
		ArrayList<CustomerOrder>tempCorderArray = tempCust.getCustomerOrders(orderList); 
		for (int i=0; i < tempCorderArray.size() ; i++){
			if (tempCorderArray.get(i).getOperativeId() == id) {
				checkResponse = true;
			}
			
	}
		return checkResponse;
	}
	

	/**
	 * Launches the Main method which will draw the main JFrame GUI
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.nbGardensInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Main method which calls the addData() method from the DataInput class which simply populates the program with orders, items and people
	 * then runs the main init method which initialises the GUI.
	 */
	public Main() {
	
		DataInput data = new DataInput();
		data.addData(inventoryList, orderList, personList, locationList);
		
		init();
	}

	/**
	 * Main GUI class which creates all Frame,TextPane, Buttons, ComboBoxes etc found on the main GUI 
	 */
	private void init() {
		
		/**
		 * 
		 * Parameters of main JFrame declared here
		 * 
		 */
	
		nbGardensInventory = new JFrame();
		nbGardensInventory.setResizable(false);
		nbGardensInventory.setTitle("NB Gardens Inventory Management System");
		nbGardensInventory.setBounds(100, 100, 1000, 780);
		nbGardensInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nbGardensInventory.getContentPane().setLayout(null);
		
		/**
		 * 
		 * All button, panel, label, textpane, tabbedpane and checkbox components declared here with names, size and x,y location.
		 * 
		 *  These are then added to the main content frame
		 * 
		 */
		
		JButton refreshOrdersButton = new JButton("Refresh Orders");
		refreshOrdersButton.setBounds(674, 292, 135, 23);
		nbGardensInventory.getContentPane().add(refreshOrdersButton);
		
		JButton displayDetailsButton = new JButton("Display Details");
		displayDetailsButton.setBounds(296, 31, 135, 23);
		nbGardensInventory.getContentPane().add(displayDetailsButton);
		
		JPanel orderDetailsPanel = new JPanel();
		orderDetailsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		orderDetailsPanel.setBackground(Color.WHITE);
		orderDetailsPanel.setBounds(36, 31, 250, 250);
		nbGardensInventory.getContentPane().add(orderDetailsPanel);
		orderDetailsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane orderDetailTextPane = new JTextPane();
		orderDetailTextPane.setEditable(false);
		orderDetailsPanel.add(orderDetailTextPane);
		
		JLabel accountsMessage = new JLabel("");
		accountsMessage.setBounds(395, 262, 400, 14);

		JTabbedPane orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		orderTabbedPane.setBounds(674, 314, 300, 417);
		nbGardensInventory.getContentPane().add(orderTabbedPane);
		
		JTextPane cOrderTextPane = new JTextPane();
		cOrderTextPane.setEditable(false);
		orderTabbedPane.addTab("Customer Orders", null, cOrderTextPane, null);
		
		JTextPane pOrderTextPane = new JTextPane();
		orderTabbedPane.addTab("Purchase Orders", null, pOrderTextPane, null);
		
		JComboBox<Object> orderDetailsComboBox = new JComboBox<Object>();
		orderDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(orderList)));
		orderDetailsComboBox.setBounds(246, 11, 40, 20);
		nbGardensInventory.getContentPane().add(orderDetailsComboBox);
		
		JLabel orderIdLabel = new JLabel("Order ID:");
		orderIdLabel.setLabelFor(orderDetailsComboBox);
		orderIdLabel.setBounds(36, 14, 60, 14);
		nbGardensInventory.getContentPane().add(orderIdLabel);
		
		JButton deleteOrderButton = new JButton("Delete Order");
		deleteOrderButton.setBounds(296, 74, 135, 23);
		nbGardensInventory.getContentPane().add(deleteOrderButton);
		
		JTabbedPane personTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		personTabbedPane.setBounds(364, 314, 300, 417);
		nbGardensInventory.getContentPane().add(personTabbedPane);
		
		JTextPane customerTextPane = new JTextPane();
		customerTextPane.setEditable(false);
		personTabbedPane.addTab("Customers", null, customerTextPane, null);
		
		JTextPane supplierTextPane = new JTextPane();
		supplierTextPane.setEditable(false);
		personTabbedPane.addTab("Suppliers", null, supplierTextPane, null);
		
		JTextPane employeeTextPane = new JTextPane();
		employeeTextPane.setEditable(false);
		personTabbedPane.addTab("Employees", null, employeeTextPane, null);
		
		JButton refreshPeopleButton = new JButton("Refresh People");
		refreshPeopleButton.setBounds(364, 292, 135, 23);
		nbGardensInventory.getContentPane().add(refreshPeopleButton);
		
		JButton addCusOrderButton = new JButton("Customer Order");
		addCusOrderButton.setBounds(827, 205, 146, 23);
		nbGardensInventory.getContentPane().add(addCusOrderButton);
		
		JButton addPurchaseOrderButton = new JButton("Purchase Order");
		addPurchaseOrderButton.setBounds(827, 179, 147, 23);
		nbGardensInventory.getContentPane().add(addPurchaseOrderButton);
		
		JLabel addLabel = new JLabel("Add: ");
		addLabel.setBounds(928, 160, 46, 14);
		nbGardensInventory.getContentPane().add(addLabel);
		
		JCheckBox placedCheckBox = new JCheckBox("Placed");
		placedCheckBox.setBounds(296, 127, 97, 23);
		nbGardensInventory.getContentPane().add(placedCheckBox);
		
		JCheckBox pickedCheckBox = new JCheckBox("Picked");		
		pickedCheckBox.setBounds(296, 153, 97, 23);
		nbGardensInventory.getContentPane().add(pickedCheckBox);
		
		JCheckBox dispatchedCheckBox = new JCheckBox("Dispatched");
		dispatchedCheckBox.setBounds(296, 179, 97, 23);
		nbGardensInventory.getContentPane().add(dispatchedCheckBox);
		
		JCheckBox recievedCheckBox = new JCheckBox("Recieved");
		recievedCheckBox.setBounds(296, 205, 97, 23);
		nbGardensInventory.getContentPane().add(recievedCheckBox);
		
		JCheckBox stackedCheckBox = new JCheckBox("Stacked");
		stackedCheckBox.setBounds(296, 231, 97, 23);
		nbGardensInventory.getContentPane().add(stackedCheckBox);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(296, 258, 89, 23);
		nbGardensInventory.getContentPane().add(saveButton);
		
		JButton refreshInventoryButton = new JButton("Refresh Inventory");
		refreshInventoryButton.setBounds(36, 292, 135, 23);
		nbGardensInventory.getContentPane().add(refreshInventoryButton);
		
		JTabbedPane inventoryTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		inventoryTabbedPane.setBounds(36, 314, 300, 417);
		nbGardensInventory.getContentPane().add(inventoryTabbedPane);
		
		JTextPane inventoryTextPane = new JTextPane();
		inventoryTabbedPane.addTab("Inventory", null, inventoryTextPane, null);
		
		JButton assignEmployeeButton = new JButton("Assign Employee");
		assignEmployeeButton.setBounds(296, 53, 135, 23);
		nbGardensInventory.getContentPane().add(assignEmployeeButton);
		
		JPanel personDetailsPane = new JPanel();
		personDetailsPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		personDetailsPane.setBackground(Color.WHITE);
		personDetailsPane.setBounds(724, 31, 250, 125);
		nbGardensInventory.getContentPane().add(personDetailsPane);
		personDetailsPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane personDetailsTextPane = new JTextPane();
		personDetailsTextPane.setEditable(false);
		personDetailsPane.add(personDetailsTextPane);
		
		JComboBox<Object> personDetailsComboBox = new JComboBox<Object>();
		personDetailsComboBox.setBounds(934, 11, 40, 20);
		personDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(personList)));
		nbGardensInventory.getContentPane().add(personDetailsComboBox);
		
		JLabel personLabel = new JLabel("Person ID:");
		personLabel.setBounds(724, 14, 60, 14);
		nbGardensInventory.getContentPane().add(personLabel);
		
		JButton dispayPersonDetailsButton = new JButton("Display Details");
		dispayPersonDetailsButton.setBounds(579, 31, 135, 23);
		nbGardensInventory.getContentPane().add(dispayPersonDetailsButton);
		
		JButton deletePersonButton = new JButton("Delete Person");
		deletePersonButton.setBounds(579, 74, 135, 23);
		nbGardensInventory.getContentPane().add(deletePersonButton);
		
		JButton travellingSalesmanButton = new JButton("Travelling Salesman");
		travellingSalesmanButton.setBounds(447, 153, 135, 23);
		nbGardensInventory.getContentPane().add(travellingSalesmanButton);
		
		/*
		 * 
		 * Action listeners are listed from here for each interactive component in the GUI
		 * 
		 */
		
		
		/*
		 * RefreshOrderButton mousePress Listener
		 * 
		 * On mousePress this creates a blank OrderLine object to allow access to the printOrders() method. This is passed the orderList and inventoryList ArrayLists
		 * to allow method to obtain order objects and item names from the inventory list.
		 * 
		 * This method returns a 2 element string array. 0 index contains customer orders and 1 index contains purchase orders.
		 * 
		 * The result of these are then set as the Text of the respective TextPanes
		 * 
		 */
		
		refreshOrdersButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				OrderLine tempOrder = new OrderLine();
				cOrderTextPane.setText(tempOrder.printOrders(orderList, inventoryList)[0]);
				pOrderTextPane.setText(tempOrder.printOrders(orderList, inventoryList)[1]);

				
			}
		});
		
		
		/*
		 * 
		 * Display Details Button mousePress Listener.
		 * 
		 * On mousePress this creates a temporary OrderFactory object to call on the .printOrderDetails() method. this passes the inventorylist, orderlist
		 * personlist ArrayLists for item, person and order information to be got. Also the current selected index integer from the combo box is got which
		 * tells us what number the user has selected (therefore what ID they have selected)
		 * 
		 *  Then this determines if this order is an instance of CustomerOrder or the PurchaseOrder class. Depending on this the checkboxes next to this window
		 *  are then set either true\false enabled or disabled or set depending on the order's current values and what class it belongs from. 
		 * 
		 * 
		 */

		displayDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		displayDetailsButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				OrderFactory tempOrderFactory = new OrderFactory();
				orderDetailTextPane.setText(tempOrderFactory.printOrderDetails(inventoryList, orderList, personList, orderDetailsComboBox.getSelectedIndex()));
				
				if (orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder() instanceof CustomerOrder){
					placedCheckBox.setSelected(true);
					placedCheckBox.setEnabled(false);
					stackedCheckBox.setEnabled(false);
					pickedCheckBox.setSelected(tempOrderFactory.returnCusOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isDispatched());			
					dispatchedCheckBox.setSelected(tempOrderFactory.returnCusOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isDispatched());
					recievedCheckBox.setSelected(tempOrderFactory.returnCusOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isHasBeenRecieved());
					
				}
				else if (orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder() instanceof PurchaseOrder){
					placedCheckBox.setSelected(true);
					placedCheckBox.setEnabled(false);
					pickedCheckBox.setEnabled(false);
					stackedCheckBox.setEnabled(true);
					pickedCheckBox.setSelected(tempOrderFactory.returnPurOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isHasBeenRecieved());	
					dispatchedCheckBox.setSelected(tempOrderFactory.returnPurOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isHasBeenDispatched());
					recievedCheckBox.setSelected(tempOrderFactory.returnPurOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isHasBeenRecieved());
					stackedCheckBox.setSelected(tempOrderFactory.returnPurOrder(orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder()).isHasBeenStacked());
				}
				
			//	comboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter()));
			}
			
			
		});
		
		/*
		 * 
		 * delete Order Mouse Press Listener
		 * 
		 * This on mouse Press creates a temporary OrderLine object to use the deleteOrder() method from this class. This is passed the orderList ArrayList where Order
		 * objects are stored and gets the current selected index of the combo box (therefore the ID the user has selected).
		 * 
		 * The comboBox list is then refreshed and the Text Pane is set to display the fact the order was deleted.
		 * 
		 */

		deleteOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				OrderLine tempOrder = new OrderLine();
				tempOrder.deleteOrder(orderList, orderDetailsComboBox.getSelectedIndex());
				orderDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(orderList)));
				orderDetailTextPane.setText("Order Deleted...");
			}
		});

		/**
		 * 
		 * refresh People mouse Press Listener.
		 * 
		 * On mousePress this creates a blank PersonLine object to allow access to the printPeople() method. This is passed the personList
		 * to allow method to obtain people objects
		 * 
		 * This method returns a 3 element large string array. 0 index contains customers, 1 index contains suppliers and 2 index contains employees orders.
		 * 
		 * The result of these are then set as the Text of the respective TextPanes
		 * 
		 */
		
		
		refreshPeopleButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				PersonLine tempPerson = new PersonLine();
				customerTextPane.setText(tempPerson.printPeople(personList)[0]);
				supplierTextPane.setText(tempPerson.printPeople(personList)[1]);
				employeeTextPane.setText(tempPerson.printPeople(personList)[2]);
				
			}
		});
		
		
		/*
		 * 
		 * add Customer Order Button mouse Press and Listener
		 * 
		 * On mouse press this creates a new instance of the Customer Order GUI and setting this to be visible
		 * 
		 *  
		 */


		addCusOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addCusOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CustomerOrderGUI frame = new CustomerOrderGUI();
				frame.setVisible(true);
				orderDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(orderList)));

			}
		});
		
		/*
		 * 
		 * add Purchase Order Button mouse Press and Listener
		 * 
		 * On mouse press this creates a new instance of the Purchase Order GUI and setting this to be visible
		 * 
		 *  
		 */

		addPurchaseOrderButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				PurchaseOrderGUI frame = new PurchaseOrderGUI();
				frame.setVisible(true);
				orderDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(orderList)));
				
			}
		});
		
		
		/*
		 * 
		 * save Order Button mouse Press action and Listener
		 * 
		 * This button on mouse Press creates a new OrderFactory object to use the updateOrder() method.
		 * 
		 * Then the order object is checked to see if this is an instance of CustomerOrder or Purchase Order. Depending on the result the accounts interface
		 * is then cast to the result of this statement
		 * 
		 * The relevant updateOrder methods are then called depending on a. The object type and b. what checkboxes have been selected.
		 * 
		 * NOTE: If a customerOrder object has the dispatch checkbox selected or a PurchaseOrder object has the received checkbox selected the updateAccounts() method
		 * is then called from the Accounts interface and the accounts message label is added to the main content pane displaying a confirmation message that this 
		 * has been completed.
		 * 
		 * 
		 */
		

		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				OrderFactory tempFactory = new OrderFactory();
				
				if (orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder() instanceof CustomerOrder){
					Accounts tempAccountsInterface = (CustomerOrder) orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder();
					
					if(recievedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 3);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 4);
					}
					else if(dispatchedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 3);
						
						nbGardensInventory.getContentPane().add(accountsMessage);
						accountsMessage.setText(tempAccountsInterface.updateAccounts());
						
						
					}
					else if(pickedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
					}
					
				}
				else if (orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder() instanceof PurchaseOrder){
					Accounts tempAccountsInterface = (PurchaseOrder) orderList.get(orderDetailsComboBox.getSelectedIndex()).getOrder();
					if(stackedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 3);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 4);
					}
					
					else if(recievedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 3);

						nbGardensInventory.getContentPane().add(accountsMessage);
						accountsMessage.setText(tempAccountsInterface.updateAccounts());
					}
					else if(dispatchedCheckBox.isSelected() == true){
						tempFactory.updateOrder(orderDetailsComboBox.getSelectedIndex(), orderList, 2);
					}

				}
			}
		});
		
		/**
		 * 
		 * refresh Inventory mousePress Action and Listener
		 * 
		 * This on mouse press creates a new InventorySystem object to call the printStock() method which is passed the inventoryList ArrayList to obtain the current inventorySystem
		 * objects. The result of this (String) is then set in the inventoryTextPane		 * 
		 * 
		 */


		refreshInventoryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				InventorySystem inventory = new InventorySystem();
				inventoryTextPane.setText(inventory.printStock(inventoryList));
				
			}
		});
		
		/*
		 * 
		 * Assign Employee Button mouse Press and Listener
		 * 
		 * On mouse press this creates a new instance of the Operative GUI and setting this to be visible
		 * 
		 *  
		 */

		assignEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OperativeGUI frame = new OperativeGUI(orderDetailsComboBox.getSelectedIndex());
				frame.setVisible(true);
							
			}

		});
		
		/**
		 * 
		 * Display Person Details Button mousePress Action and Listener
		 * 
		 * On mouse press this creates a temporary PersonLine object and the printPeopleDetails() method is then called from it. This is passed the current combo box selection (int, this acts as the ID)
		 * and the personList ArrayList which contains Customer, Supplier and Employee objects. 
		 * 
		 * The result of this (String) is then set within the personDetails TextPane
		 * 
		 */

		dispayPersonDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				PersonLine tempPerson = new PersonLine();
				personDetailsTextPane.setText(tempPerson.printPeopleDetails(personDetailsComboBox.getSelectedIndex(), personList));
			}
		});
		
		/*
		 * 
		 * Delete Person Button mousePress Listener and ActionListener
		 * 
		 * On mouse press this first calls the personCheck method at the top of this class and passes the result to the personCheck boolean.
		 * 
		 * If this is true then the personDetails Text Pane is updated to tell the user that this person cannot be deleted as this person is still assigned to an order in the system
		 * 
		 * If not then a PersonLine object is created to call the deletePersonnel() method from this class. This is passed the current comboBox selection index (int, acts as the ID) and the personList
		 * which contains all the Customer, Supplier and Employee objects.
		 * 
		 * From this the comboBox is also updated to reflect the removal of a person object and the personDetails pane is updated to inform the user that the person has been deleted.
		 * 
		 */

		deletePersonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Boolean personCheck = personCheck(personDetailsComboBox.getSelectedIndex());
				
				if (personCheck == true) {
					personDetailsTextPane.setText("Person is still assigned to an order! \n\nCannot Delete!");
				}
				else
				{
				PersonLine tempPerson = new PersonLine();
				tempPerson.deletePersonnel(personDetailsComboBox.getSelectedIndex(), personList);
				personDetailsComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetter(personList)));
				personDetailsTextPane.setText("Person Deleted...");
				}
			}
		});
		
		/*
		 * 
		 * Travelling Salesman Button mousePress ActionListener.
		 * 
		 * On mouse press this creates a new TravellingSalesmanGUI object to call the separate Travelling Salesman GUI Frame.
		 * 
		 * This is then set to visible so the user can see this window.
		 * 
		 * 
		 */

		travellingSalesmanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				TravellingSalesmanGUI sales = new TravellingSalesmanGUI();
				sales.setVisible(true);
			}
		});
			
	}
	}
