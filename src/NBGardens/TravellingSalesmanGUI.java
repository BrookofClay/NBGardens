package NBGardens;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TravellingSalesmanGUI extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public TravellingSalesmanGUI() {
		setTitle("Travelling Salesman");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JButton okButton = new JButton("Ok");
		okButton.setBounds(182, 228, 69, 23);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();		
			}
		});
		contentPane.add(okButton);
		
		JLabel messageLabel1 = new JLabel("To fufill the current customer orders waiting");
		messageLabel1.setBounds(103, 64, 261, 14);
		contentPane.add(messageLabel1);
		
		JLabel messageLabel2 = new JLabel("visit these areas in the following order:");
		messageLabel2.setBounds(103, 81, 261, 14);
		contentPane.add(messageLabel2);
		
		JLabel tSalesmanLabel = new JLabel();
		tSalesmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tSalesmanLabel.setBounds(17, 106, 400, 14);
		contentPane.add(tSalesmanLabel);	
		
		TravellingSalesman sales = new TravellingSalesman();
		tSalesmanLabel.setText(sales.getTravellingSalesman(Main.orderList, Main.inventoryList));
		
	
	}
}
