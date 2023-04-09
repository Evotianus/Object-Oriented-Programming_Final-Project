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

public class ReturnForm extends JFrame {
	// Window Layout
	private JPanel panelWindow = new JPanel();
	private JPanel panelSpacing = new JPanel();
	
	// Car Detail
	private JPanel panelCarDetail = new JPanel();
	private JPanel panelCarHeader = new JPanel();
	
	private JPanel panelCarType = new JPanel();
	private JPanel panelCarBrand = new JPanel();
	private JPanel panelCarLicensePlate = new JPanel();
	
	private JLabel labelCarBrand = new JLabel("Car Brand");
	private JLabel labelCarType = new JLabel("Car Type");
	private JLabel labelCarLicensePlate = new JLabel("Car License Plate");
	
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarBrand = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();
	
	
	// Renter Detail
	private JPanel panelRenterDetail = new JPanel();
	private JPanel panelRenterHeader = new JPanel();
	
	private JPanel panelRenterID = new JPanel();
	private JPanel panelRenterLoanDate = new JPanel();
	private JPanel panelRenterReturnDate = new JPanel();
	private JPanel panelRenterDayElapsed = new JPanel();
	private JPanel panelRenterFine = new JPanel();
	
	private JLabel labelRenterID = new JLabel("Customer ID");
	private JLabel labelRenterLoanDate = new JLabel("Loan Date");
	private JLabel labelRenterReturnDateNumber = new JLabel("Return Date");
	private JLabel labelRenterDayElapsed = new JLabel("Day Elapsed");
	private JLabel labelRenterFine = new JLabel("Fine");
	
	private JTextField textFieldRenterID = new JTextField();
	private JTextField textFieldRenterLoanDate = new JTextField();
	private JTextField textFieldRenterReturnDateNumber = new JTextField();
	private JTextField textFieldRenterDayElapsed = new JTextField();
	private JTextField textFieldRenterFine = new JTextField();
	
	
	// Button Event Listener
	private JPanel panelReturnFormButton = new JPanel();
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonEdit = new JButton("Edit");
	
	
	void init_car_components() {
		panelCarDetail.setLayout(new GridLayout(4, 1));
		
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
		
		
		panelCarBrand.setLayout(new GridLayout(1, 4));
		panelCarBrand.add(new JPanel());
		panelCarBrand.add(labelCarBrand);
		textFieldCarBrand.setPreferredSize(new Dimension(300, 25));
		panelCarBrand.add(textFieldCarBrand);
		panelCarBrand.add(new JPanel());
		
		panelCarDetail.add(panelCarBrand);
		
		
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
		panelRenterDetail.setLayout(new GridLayout(6, 1));
		
		panelRenterHeader.setLayout(new FlowLayout());
		panelRenterHeader.add(new JLabel("Renter Details"));
		
		panelRenterDetail.add(panelRenterHeader);
		
		
		panelRenterID.setLayout(new GridLayout(1, 4));
		panelRenterID.add(new JPanel());
		panelRenterID.add(labelRenterID);
		textFieldRenterID.setPreferredSize(new Dimension(300, 25));
		panelRenterID.add(textFieldRenterID);
		panelRenterID.add(new JPanel());
		
		panelRenterDetail.add(panelRenterID);
		
		
		panelRenterLoanDate.setLayout(new GridLayout(1,4));
		panelRenterLoanDate.add(new JPanel());
		panelRenterLoanDate.add(labelRenterLoanDate);
		panelRenterLoanDate.add(textFieldRenterLoanDate);
		panelRenterLoanDate.add(new JPanel());
		
		panelRenterDetail.add(panelRenterLoanDate);

		
		panelRenterReturnDate.setLayout(new GridLayout(1,4));
		panelRenterReturnDate.add(new JPanel());
		panelRenterReturnDate.add(labelRenterReturnDateNumber);
		panelRenterReturnDate.add(textFieldRenterReturnDateNumber);
		panelRenterReturnDate.add(new JPanel());
		
		panelRenterDetail.add(panelRenterReturnDate);
		
		
		panelRenterDayElapsed.setLayout(new GridLayout(1,4));
		panelRenterDayElapsed.add(new JPanel());
		panelRenterDayElapsed.add(labelRenterDayElapsed);
		panelRenterDayElapsed.add(textFieldRenterDayElapsed);
		panelRenterDayElapsed.add(new JPanel());
		
		panelRenterDetail.add(panelRenterDayElapsed);
		
		
		panelRenterFine.setLayout(new GridLayout(1,4));
		panelRenterFine.add(new JPanel());
		panelRenterFine.add(labelRenterFine);
		panelRenterFine.add(textFieldRenterFine);
		panelRenterFine.add(new JPanel());
		
		panelRenterDetail.add(panelRenterFine);
		
		
		panelSpacing.setPreferredSize(new Dimension(3, 1));
		panelWindow.add(panelRenterDetail);
		panelWindow.add(panelSpacing);
	}
	
	void init_button_components() {
//		panelReturnFormButton.setLayout(new FlowLayout());
		
		panelReturnFormButton.add(buttonAdd);
		panelReturnFormButton.add(buttonDelete);
		panelReturnFormButton.add(buttonEdit);
		
		panelWindow.add(panelReturnFormButton);
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
	
	public ReturnForm() {
		init_car_components();
		init_renter_components();
		init_button_components();
		init_window(); 	
	}
	
	public static void main(String[] args) {
		new ReturnForm();
	}
}
