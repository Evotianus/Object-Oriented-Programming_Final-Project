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
	private JPanel windowPanel = new JPanel();
	private JPanel spacingPanel = new JPanel();
	
	// Car Detail
	private JPanel carDetailPanel = new JPanel();
	private JPanel carHeaderPanel = new JPanel();
	
	private JPanel carTypePanel = new JPanel();
	private JPanel carDescriptionPanel = new JPanel();
	private JPanel carRentPeriodPanel = new JPanel();
	private JPanel carLicensePlatePanel = new JPanel();
	
	private JLabel labelCarType = new JLabel("Car Type");
	private JLabel labelCarDescription = new JLabel("Car Description");
	private JLabel labelCarRentPeriod = new JLabel("Car Rent Period");
	private JLabel labelCarLicensePlate = new JLabel("Car License Plate");
	
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarDescription = new JTextField();
	private JTextField textFieldCarRentPeriod = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();
	
	
	// Renter Detail
	private JPanel renterDetailPanel = new JPanel();
	private JPanel renterHeaderPanel = new JPanel();
	
	private JPanel renterNamePanel = new JPanel();
	private JPanel renterAddressPanel = new JPanel();
	private JPanel renterTelephoneNumberPanel = new JPanel();
	private JPanel renterEmailAddressPanel = new JPanel();
	
	private JLabel labelRenterName = new JLabel("Renter Name");
	private JLabel labelRenterAddress = new JLabel("Renter Address");
	private JLabel labelRenterTelephoneNumber = new JLabel("Renter Telephone Number");
	private JLabel labelRenterEmailAddress = new JLabel("Renter Email Address");
	
	private JTextField textFieldRenterName = new JTextField();
	private JTextField textFieldRenterAddress = new JTextField();
	private JTextField textFieldRenterTelephoneNumber = new JTextField();
	private JTextField textFieldRenterEmailAddress = new JTextField();
	
	
	// Button Event Listener
	private JPanel borrowFormButtonPanel = new JPanel();
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonEdit = new JButton("Edit");
	
	
	void init_car_components() {
		carDetailPanel.setLayout(new GridLayout(5, 1));
		
		carHeaderPanel.setLayout(new FlowLayout());
		carHeaderPanel.add(new JLabel("Car Details"));
		
		carDetailPanel.add(carHeaderPanel);
		
		
		carTypePanel.setLayout(new GridLayout(1, 4));
		carTypePanel.add(new JPanel());
		carTypePanel.add(labelCarType);
		textFieldCarType.setPreferredSize(new Dimension(300, 25));
		carTypePanel.add(textFieldCarType);
		carTypePanel.add(new JPanel());
		
		carDetailPanel.add(carTypePanel);
		
		
		carDescriptionPanel.setLayout(new GridLayout(1, 4));
		carDescriptionPanel.add(new JPanel());
		carDescriptionPanel.add(labelCarDescription);
		textFieldCarDescription.setPreferredSize(new Dimension(300, 25));
		carDescriptionPanel.add(textFieldCarDescription);
		carDescriptionPanel.add(new JPanel());
		
		carDetailPanel.add(carDescriptionPanel);
		
		
		carRentPeriodPanel.setLayout(new GridLayout(1, 4));
		carRentPeriodPanel.add(new JPanel());
		carRentPeriodPanel.add(labelCarRentPeriod);
		textFieldCarRentPeriod.setPreferredSize(new Dimension(300, 25));
		carRentPeriodPanel.add(textFieldCarRentPeriod);
		carRentPeriodPanel.add(new JPanel());
		
		carDetailPanel.add(carRentPeriodPanel);
		
		
		carLicensePlatePanel.setLayout(new GridLayout(1, 4));
		carLicensePlatePanel.add(new JPanel());
		carLicensePlatePanel.add(labelCarLicensePlate);
		textFieldCarLicensePlate.setPreferredSize(new Dimension(300, 25));
		carLicensePlatePanel.add(textFieldCarLicensePlate);
		carLicensePlatePanel.add(new JPanel());
		
		carDetailPanel.add(carLicensePlatePanel);
		
		
		windowPanel.add(carDetailPanel);
		
		spacingPanel.setPreferredSize(new Dimension(5, 1));
		windowPanel.add(spacingPanel);
	}
	
	void init_renter_components() {
		renterDetailPanel.setLayout(new GridLayout(5, 1));
		
		renterHeaderPanel.setLayout(new FlowLayout());
		renterHeaderPanel.add(new JLabel("Renter Details"));
		
		renterDetailPanel.add(renterHeaderPanel);
		
		
		renterNamePanel.setLayout(new GridLayout(1, 4));
		renterNamePanel.add(new JPanel());
		renterNamePanel.add(labelRenterName);
		textFieldRenterName.setPreferredSize(new Dimension(300, 25));
		renterNamePanel.add(textFieldRenterName);
		renterNamePanel.add(new JPanel());
		
		renterDetailPanel.add(renterNamePanel);
		
		
		renterAddressPanel.setLayout(new GridLayout(1,4));
		renterAddressPanel.add(new JPanel());
		renterAddressPanel.add(labelRenterAddress);
		renterAddressPanel.add(textFieldRenterAddress);
		renterAddressPanel.add(new JPanel());
		
		renterDetailPanel.add(renterAddressPanel);

		
		renterTelephoneNumberPanel.setLayout(new GridLayout(1,4));
		renterTelephoneNumberPanel.add(new JPanel());
		renterTelephoneNumberPanel.add(labelRenterTelephoneNumber);
		renterTelephoneNumberPanel.add(textFieldRenterTelephoneNumber);
		renterTelephoneNumberPanel.add(new JPanel());
		
		renterDetailPanel.add(renterTelephoneNumberPanel);
		
		
		renterEmailAddressPanel.setLayout(new GridLayout(1,4));
		renterEmailAddressPanel.add(new JPanel());
		renterEmailAddressPanel.add(labelRenterEmailAddress);
		renterEmailAddressPanel.add(textFieldRenterEmailAddress);
		renterEmailAddressPanel.add(new JPanel());
		
		renterDetailPanel.add(renterEmailAddressPanel);
		
		spacingPanel.setPreferredSize(new Dimension(3, 1));
		windowPanel.add(renterDetailPanel);
		windowPanel.add(spacingPanel);
	}
	
	void init_button_components() {
//		borrowFormButtonPanel.setLayout(new FlowLayout());
		
		borrowFormButtonPanel.add(buttonAdd);
		borrowFormButtonPanel.add(buttonDelete);
		borrowFormButtonPanel.add(buttonEdit);
		
		windowPanel.add(borrowFormButtonPanel);
	}
	
	void init_window() {
//		setLayout(new GridLayout(10, 1));
//		windowPanel.setLayout(new GridLayout(4, 1));
		add(windowPanel);
		
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
