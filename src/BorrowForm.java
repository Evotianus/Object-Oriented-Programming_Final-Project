import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Main Form
// - Car Detail
// 1. Car Type
// 2. Car Description
// 3. Rent period
// 4. License plate

// - Renter Detail
// 1. Name
// 2. Address
// 3. Telephone Number
// 4. Email Address

// After all accepted
// 1. Price

public class BorrowForm extends JFrame {
	// Window Layout
	private JPanel panelWindow = new JPanel();
	private JPanel panelSpacing = new JPanel();
	
	// Car Detail
	private JPanel panelCarDetail = new JPanel();
	private JPanel panelCarHeader = new JPanel();
	
	private JPanel panelCarType = new JPanel();
	private JPanel panelCarDescription = new JPanel();
	private JPanel panelCarRentPeriod = new JPanel();
	private JPanel panelCarLicensePlate = new JPanel();
	
	private JLabel labelCarType = new JLabel("Car Type");
	private JLabel labelCarDescription = new JLabel("Car Description");
	private JLabel labelCarRentPeriod = new JLabel("Car Rent Period");
	private JLabel labelCarLicensePlate = new JLabel("Car License Plate");
	
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarDescription = new JTextField();
	private JTextField textFieldCarRentPeriod = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();
	
	
	// Renter Detail
	private JPanel panelRenterDetail = new JPanel();
	private JPanel panelRenterHeader = new JPanel();
	
	private JPanel panelRenterName = new JPanel();
	private JPanel panelRenterAddress = new JPanel();
	private JPanel panelRenterTelephoneNumber = new JPanel();
	private JPanel panelRenterEmailAddress = new JPanel();
	
	private JLabel labelRenterName = new JLabel("Renter Name");
	private JLabel labelRenterAddress = new JLabel("Renter Address");
	private JLabel labelRenterTelephoneNumber = new JLabel("Renter Telephone Number");
	private JLabel labelRenterEmailAddress = new JLabel("Renter Email Address");
	
	private JTextField textFieldRenterName = new JTextField();
	private JTextField textFieldRenterAddress = new JTextField();
	private JTextField textFieldRenterTelephoneNumber = new JTextField();
	private JTextField textFieldRenterEmailAddress = new JTextField();
	
	
	// Button Event Listener
	private JPanel panelBorrowFormButton = new JPanel();
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonEdit = new JButton("Edit");
	
	
	void init_car_components() {
		panelCarDetail.setLayout(new GridLayout(5, 1));
		
		panelCarHeader.setLayout(new FlowLayout());
		panelCarHeader.add(new JLabel("Car Details"));
		
		panelCarDetail.add(panelCarHeader);
		
		
		panelCarType.setLayout(new GridLayout(1, 4));
		panelCarType.add(new JPanel());
		panelCarType.add(labelCarType);
		textFieldCarType.setPreferredSize(new Dimension(300, 25));
		panelCarType.add(textFieldCarType);
		panelCarType.add(new JPanel());
		
		panelCarDetail.add(panelCarType);
		
		
		panelCarDescription.setLayout(new GridLayout(1, 4));
		panelCarDescription.add(new JPanel());
		panelCarDescription.add(labelCarDescription);
		textFieldCarDescription.setPreferredSize(new Dimension(300, 25));
		panelCarDescription.add(textFieldCarDescription);
		panelCarDescription.add(new JPanel());
		
		panelCarDetail.add(panelCarDescription);
		
		
		panelCarRentPeriod.setLayout(new GridLayout(1, 4));
		panelCarRentPeriod.add(new JPanel());
		panelCarRentPeriod.add(labelCarRentPeriod);
		textFieldCarRentPeriod.setPreferredSize(new Dimension(300, 25));
		panelCarRentPeriod.add(textFieldCarRentPeriod);
		panelCarRentPeriod.add(new JPanel());
		
		panelCarDetail.add(panelCarRentPeriod);
		
		
		panelCarLicensePlate.setLayout(new GridLayout(1, 4));
		panelCarLicensePlate.add(new JPanel());
		panelCarLicensePlate.add(labelCarLicensePlate);
		textFieldCarLicensePlate.setPreferredSize(new Dimension(300, 25));
		panelCarLicensePlate.add(textFieldCarLicensePlate);
		panelCarLicensePlate.add(new JPanel());
		
		panelCarDetail.add(panelCarLicensePlate);
		
		
		panelWindow.add(panelCarDetail);
		
		panelSpacing.setPreferredSize(new Dimension(5, 1));
		panelWindow.add(panelSpacing);
	}
	
	void init_renter_components() {
		panelRenterDetail.setLayout(new GridLayout(5, 1));
		
		panelRenterHeader.setLayout(new FlowLayout());
		panelRenterHeader.add(new JLabel("Renter Details"));
		
		panelRenterDetail.add(panelRenterHeader);
		
		
		panelRenterName.setLayout(new GridLayout(1, 4));
		panelRenterName.add(new JPanel());
		panelRenterName.add(labelRenterName);
		textFieldRenterName.setPreferredSize(new Dimension(300, 25));
		panelRenterName.add(textFieldRenterName);
		panelRenterName.add(new JPanel());
		
		panelRenterDetail.add(panelRenterName);
		
		
		panelRenterAddress.setLayout(new GridLayout(1,4));
		panelRenterAddress.add(new JPanel());
		panelRenterAddress.add(labelRenterAddress);
		panelRenterAddress.add(textFieldRenterAddress);
		panelRenterAddress.add(new JPanel());
		
		panelRenterDetail.add(panelRenterAddress);

		
		panelRenterTelephoneNumber.setLayout(new GridLayout(1,4));
		panelRenterTelephoneNumber.add(new JPanel());
		panelRenterTelephoneNumber.add(labelRenterTelephoneNumber);
		panelRenterTelephoneNumber.add(textFieldRenterTelephoneNumber);
		panelRenterTelephoneNumber.add(new JPanel());
		
		panelRenterDetail.add(panelRenterTelephoneNumber);
		
		
		panelRenterEmailAddress.setLayout(new GridLayout(1,4));
		panelRenterEmailAddress.add(new JPanel());
		panelRenterEmailAddress.add(labelRenterEmailAddress);
		panelRenterEmailAddress.add(textFieldRenterEmailAddress);
		panelRenterEmailAddress.add(new JPanel());
		
		panelRenterDetail.add(panelRenterEmailAddress);
		
		panelSpacing.setPreferredSize(new Dimension(3, 1));
		panelWindow.add(panelRenterDetail);
		panelWindow.add(panelSpacing);
	}
	
	void init_button_components() {
//		panelBorrowFormButton.setLayout(new FlowLayout());
		
		panelBorrowFormButton.add(buttonAdd);
		panelBorrowFormButton.add(buttonDelete);
		panelBorrowFormButton.add(buttonEdit);
		
		panelWindow.add(panelBorrowFormButton);
	}
	
	void init_window() {
//		setLayout(new GridLayout(10, 1));
//		panelWindow.setLayout(new GridLayout(4, 1));
		add(panelWindow);
		
		setTitle("Rent Form");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public BorrowForm() {
		// TODO Auto-generated constructor stub
		init_car_components();
		init_renter_components();
		init_button_components();
		init_window(); 	
	}
	
	public static void main(String[] args) {
		new BorrowForm();
	}
}
