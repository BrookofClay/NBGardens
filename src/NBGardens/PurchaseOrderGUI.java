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

public class PurchaseOrderGUI extends JFrame {
	
	public String[] comboBoxGetterItems(){
		String[] tempStringArray = new String[Main.inventoryList.size()];
		for(int i=0; i < Main.inventoryList.size(); i++) {
			
			tempStringArray[i] = Integer.toString(i+1) + " - " + Main.inventoryList.get(i).getItemName();
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
		//int j=0;
		for(int i=0; i < Main.personList.size(); i++){
			if (Main.personList.get(i).getPerson() instanceof Customer){
				Customer tempCustomer = (Customer) Main.personList.get(i).getPerson();
				
				tempString += Integer.toString(tempCustomer.getId()) + " - " + tempCustomer.getName()+ ",";
				//j++;
			}
		}
		String[] tempStringArray = tempString.split(",");
		return tempStringArray;
	}
	
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
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private String selectedOrderItems = "";


	public PurchaseOrderGUI() {
		setTitle("Add Purchase Order");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setBounds(83, 14, 33, 14);
		contentPane.add(itemLabel);
		
		JComboBox<Object> itemComboBox = new JComboBox<Object>();
		itemComboBox.setBounds(143, 14, 140, 20);
		itemComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterItems()));
		contentPane.add(itemComboBox);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(305, 10, 65, 23);
		
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectedOrderItems += (itemComboBox.getSelectedIndex()+1) + ",";
				
			}
		});
		contentPane.add(addButton);
		
		JLabel customerLabel = new JLabel("Customer");
		customerLabel.setBounds(59, 68, 57, 14);
		contentPane.add(customerLabel);
		
		JComboBox<Object> customerComboBox = new JComboBox<Object>();
		customerComboBox.setBounds(143, 67, 140, 20);
		customerComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterCustomer()));
		contentPane.add(customerComboBox);
		
		JLabel employeeLabel = new JLabel("Employee");
		employeeLabel.setBounds(59, 120, 57, 14);
		contentPane.add(employeeLabel);
		
		JComboBox<Object> employeeComboBox = new JComboBox<Object>();
		employeeComboBox.setBounds(143, 119, 140, 20);
		employeeComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterOperative()));
		contentPane.add(employeeComboBox);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(143, 228, 80, 23);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int[] tempOrderArray = stringToIntArray(selectedOrderItems);
	
				
				PurchaseOrder porder = new PurchaseOrder(tempOrderArray, customerComboBox.getSelectedIndex()+1, employeeComboBox.getSelectedIndex()+1);
				
				OrderLine order = new OrderLine();
				
				order.addOrder(porder, Main.orderList);
				
				PurchaseOrderGUI.this.setVisible(false);
				
			}
		});
		contentPane.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(232, 228, 80, 23);
		contentPane.add(cancelButton);	
		
	}

}
