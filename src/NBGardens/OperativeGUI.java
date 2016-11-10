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

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OperativeGUI extends JFrame {
		
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
	
	
	public int comboBoxGetterID(String comboSelection){
	
		int employeeID = Character.getNumericValue(comboSelection.charAt(0));
		System.out.println(employeeID);
		
		return employeeID;
	}
		
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public OperativeGUI(int orderId) {
		setTitle("Assigning Operative");

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel messageLabel = new JLabel("Please select the Warehouse Operative you wish to assign to this order.");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(10, 29, 414, 39);
		contentPane.add(messageLabel);	
		
		JLabel employeeLabel = new JLabel("Employee");
		employeeLabel.setBounds(111, 116, 65, 14);
		contentPane.add(employeeLabel);
		
		JComboBox<Object> employeeComboBox = new JComboBox<Object>();
		employeeComboBox.setBounds(180, 113, 175, 20);
		employeeComboBox.setModel(new DefaultComboBoxModel<Object>(comboBoxGetterOperative()));
		contentPane.add(employeeComboBox);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(115, 227, 90, 23);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OrderFactory order = new OrderFactory();
				OrderLine tempOrder = new OrderLine();
				if(Main.orderList.get(orderId).getOrder() instanceof CustomerOrder)
				{
				CustomerOrder tempCustomerObject = order.returnCusOrder(Main.orderList.get(orderId).getOrder());
				String comboSelection = (String) employeeComboBox.getSelectedItem();
				tempCustomerObject.setOperativeId(comboBoxGetterID(comboSelection));
				tempOrder.replaceOrder(orderId, tempCustomerObject);
				
				} 
				else 
				{
				PurchaseOrder tempPurchaseObject = order.returnPurOrder(Main.orderList.get(orderId).getOrder());
				String comboSelection = (String) employeeComboBox.getSelectedItem();
				tempPurchaseObject.setOperativeId(comboBoxGetterID(comboSelection));
				tempOrder.replaceOrder(orderId, tempPurchaseObject);
				
				}
				OperativeGUI.this.setVisible(false);
			}
		});
		contentPane.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				OperativeGUI.this.setVisible(false);
			}
		});
		cancelButton.setBounds(215, 227, 90, 23);
		contentPane.add(cancelButton);
		
	}
}