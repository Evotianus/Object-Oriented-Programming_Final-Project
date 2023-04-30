import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.*;

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

public class BorrowForm extends JFrame implements ActionListener {
	// Window Layout
	private JPanel panelWindow = new JPanel();
	private JPanel panelSpacing = new JPanel();
	
	// Car Detail
	private JPanel panelCarDetail = new JPanel();
	private JPanel panelCarHeader = new JPanel();
	
	private JPanel panelCarBrand = new JPanel();
	private JPanel panelCarType = new JPanel();
	private JPanel panelCarDescription = new JPanel();
	private JPanel panelCarRentDate = new JPanel();
	private JPanel panelCarLicensePlate = new JPanel();
	
	private JLabel labelCarBrand = new JLabel("Car Brand");
	private JLabel labelCarType = new JLabel("Car Type");
	private JLabel labelCarDescription = new JLabel("Car Description");
	private JLabel labelCarRentDate = new JLabel("Car Rent Date");
	private JLabel labelCarLicensePlate = new JLabel("Car License Plate");
	
	private JComboBox<String> comboBoxCarBrand = new JComboBox<String>();
	private JComboBox<String> comboBoxCarType = new JComboBox<String>();
	
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarDescription = new JTextField();
	private JTextField textFieldCarRentDate = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();
	
	private boolean isDateFilled = false;
	
	private UtilDateModel model = new UtilDateModel();
	private Properties p = new Properties();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter() {
		
		@Override
		public String valueToString(Object value) throws ParseException {
			// TODO Auto-generated method stub
			if ( value != null ) {
				Calendar cal = (Calendar) value;
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String strDate = format.format(cal.getTime());
				isDateFilled = true;
				
				return strDate;					
			}
			isDateFilled = false;
			return "";
		}
		
		@Override
		public Object stringToValue(String text) throws ParseException {
			// TODO Auto-generated method stub
			isDateFilled = false;
			return "";
		}
	});
	
		
	
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
	
	private JComboBox<String> comboBoxRenterName = new JComboBox<String>();
//	private JTextField textFieldRenterName = new JTextField();
	private JTextField textFieldRenterAddress = new JTextField();
	private JTextField textFieldRenterTelephoneNumber = new JTextField();
	private JTextField textFieldRenterEmailAddress = new JTextField();
	
	
	// Car Detail and Account Detail
	private ArrayList<Car> carList;
	private ArrayList<String> carBrandList = new ArrayList<>(Arrays.asList("Select Car Brand"));
	private ArrayList<String> carTypeList = new ArrayList<>();
	private ArrayList<Account> accountList;
	private ArrayList<String> accountUsernameList = new ArrayList<>(Arrays.asList("Select Renter"));
	
	// Button Event Listener
	private JPanel panelBorrowFormButton = new JPanel();
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonClear = new JButton("Clear");
	
	private MainForm mainForm;
	
	void init_car_components() {
		panelCarDetail.setLayout(new GridLayout(6, 1));
		
		panelCarHeader.setLayout(new FlowLayout());
		panelCarHeader.add(new JLabel("Car Details"));
		
		panelCarDetail.add(panelCarHeader);
		
		
		panelCarBrand.setLayout(new GridLayout(1, 4));
		panelCarBrand.add(new JPanel());
		panelCarBrand.add(labelCarBrand);
		comboBoxCarBrand.setPreferredSize(new Dimension(300, 25));
		panelCarBrand.add(comboBoxCarBrand);
		panelCarBrand.add(new JPanel());
		
		panelCarDetail.add(panelCarBrand);
		
		panelCarType.setLayout(new GridLayout(1, 4));
		panelCarType.add(new JPanel());
		panelCarType.add(labelCarType);
		comboBoxCarType.setPreferredSize(new Dimension(300, 25));
		panelCarType.add(comboBoxCarType);
		panelCarType.add(new JPanel());
		
		comboBoxCarType.setEnabled(false);
		
		panelCarDetail.add(panelCarType);
		
		
		panelCarDescription.setLayout(new GridLayout(1, 4));
		panelCarDescription.add(new JPanel());
		panelCarDescription.add(labelCarDescription);
		textFieldCarDescription.setPreferredSize(new Dimension(300, 25));
		panelCarDescription.add(textFieldCarDescription);
		panelCarDescription.add(new JPanel());
		
		textFieldCarDescription.setEnabled(false);
		
		panelCarDetail.add(panelCarDescription);
		
		
		
		panelCarRentDate.setLayout(new GridLayout(1, 4));
		panelCarRentDate.add(new JPanel());
		panelCarRentDate.add(labelCarRentDate);
		textFieldCarRentDate.setPreferredSize(new Dimension(300, 25));
		panelCarRentDate.add(datePicker);
		panelCarRentDate.add(new JPanel());
		
		panelCarDetail.add(panelCarRentDate);

		
		
		panelCarLicensePlate.setLayout(new GridLayout(1, 4));
		panelCarLicensePlate.add(new JPanel());
		panelCarLicensePlate.add(labelCarLicensePlate);
		textFieldCarLicensePlate.setPreferredSize(new Dimension(300, 25));
		panelCarLicensePlate.add(textFieldCarLicensePlate);
		panelCarLicensePlate.add(new JPanel());
		
		textFieldCarLicensePlate.setEnabled(false);
		
		panelCarDetail.add(panelCarLicensePlate);
		
		
		comboBoxCarBrand.addActionListener(this);
		comboBoxCarType.addActionListener(this);
		
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
		comboBoxRenterName.setPreferredSize(new Dimension(300, 25));
		panelRenterName.add(comboBoxRenterName);
		panelRenterName.add(new JPanel());
		
		panelRenterDetail.add(panelRenterName);
		
		
		panelRenterAddress.setLayout(new GridLayout(1,4));
		panelRenterAddress.add(new JPanel());
		panelRenterAddress.add(labelRenterAddress);
		panelRenterAddress.add(textFieldRenterAddress);
		panelRenterAddress.add(new JPanel());
		
		textFieldRenterAddress.setEnabled(false);
		
		panelRenterDetail.add(panelRenterAddress);

		
		panelRenterTelephoneNumber.setLayout(new GridLayout(1,4));
		panelRenterTelephoneNumber.add(new JPanel());
		panelRenterTelephoneNumber.add(labelRenterTelephoneNumber);
		panelRenterTelephoneNumber.add(textFieldRenterTelephoneNumber);
		panelRenterTelephoneNumber.add(new JPanel());
		
		textFieldRenterTelephoneNumber.setEnabled(false);
		
		panelRenterDetail.add(panelRenterTelephoneNumber);
		
		
		panelRenterEmailAddress.setLayout(new GridLayout(1,4));
		panelRenterEmailAddress.add(new JPanel());
		panelRenterEmailAddress.add(labelRenterEmailAddress);
		panelRenterEmailAddress.add(textFieldRenterEmailAddress);
		panelRenterEmailAddress.add(new JPanel());
		
		textFieldRenterEmailAddress.setEnabled(false);
		
		panelRenterDetail.add(panelRenterEmailAddress);
		
		comboBoxRenterName.addActionListener(this);
		
		panelSpacing.setPreferredSize(new Dimension(3, 1));
		panelWindow.add(panelRenterDetail);
		panelWindow.add(panelSpacing);
	}
	
	void init_button_components() {
//		panelBorrowFormButton.setLayout(new FlowLayout());
		
		panelBorrowFormButton.add(buttonAdd);
		panelBorrowFormButton.add(buttonClear);
		
		buttonAdd.addActionListener(this);
		buttonClear.addActionListener(this);
		
		panelWindow.add(panelBorrowFormButton);
	}
	
	void init_window() {
		add(panelWindow);
		
		setTitle("Rent Form");
		setSize(650, 400);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	void init_form_data(ArrayList<Car> carList, ArrayList<Account> accountList) {
		this.carList = carList;
		this.accountList = accountList;
		
		for (Car car : carList) {
			if ( !carBrandList.contains(car.getCarName()) ) {
				carBrandList.add(car.getCarName());
			}		
		}
		
		comboBoxCarBrand.setModel(new DefaultComboBoxModel<String>(carBrandList.toArray(new String[0])));
		
		
		for (Account account : accountList) {
			if ( !accountUsernameList.contains(account.getUsername()) ) {
				accountUsernameList.add(account.getUsername());
			}
		}
		
		comboBoxRenterName.setModel(new DefaultComboBoxModel<String>(accountUsernameList.toArray(new String[0])));
	}
	
	public boolean inputValidator(String carBrand, String carType, String carDescription, String carRentDate, String carLicensePlate, String renterName, String renterAddress, String renterTelephoneNumber, String renterEmailAddress) {
		boolean flag = false;
		String errorMessage = "";
		
		if (carBrand.equals("Select Car Brand") || carBrand.isEmpty()) {
			errorMessage += "Car Brand must be filled!\n";
			flag = true;
		}
		if (carType.equals("") || carType.equals("Select Car Type")) {
			errorMessage += "Car Type must be filled!\n";
			flag = true;
		}
		if (carDescription.equals("")) {
			errorMessage += "Car Description must be filled!\n";
			flag = true;
		}
		if (isDateFilled == false) {
			errorMessage += "Car Rent Period must be filled!\n";
			flag = true;
		}
		if (renterName.equals("Select Renter")) {
			errorMessage += "Renter Name must be filled!\n";
			flag = true;
		}
		
		if ( flag == true  ) {
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void inputClear() {
		comboBoxCarBrand.setSelectedItem("Select Car Brand");
		carTypeList.clear();
		comboBoxCarType.setModel(new DefaultComboBoxModel<String>(carTypeList.toArray(new String[0])));
		comboBoxCarType.setEnabled(false);
		textFieldCarDescription.setText("");
		textFieldCarLicensePlate.setText("");
		comboBoxRenterName.setSelectedItem("Select Renter");
		textFieldRenterAddress.setText("");
		textFieldRenterTelephoneNumber.setText("");
		textFieldRenterEmailAddress.setText("");
		model.setValue(null);
		isDateFilled = false;
	}
	
	public BorrowForm(MainForm mainForm) {
		this.mainForm = mainForm;
		
		init_car_components();
		init_renter_components();
		init_button_components();
		init_window(); 	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(comboBoxCarBrand) ) {
			
			carTypeList.clear();
			
			if ( comboBoxCarBrand.getSelectedItem().equals("Select Car Brand") ) {
				comboBoxCarType.setModel(new DefaultComboBoxModel<String>(carTypeList.toArray(new String[0])));
				comboBoxCarType.setEnabled(false);
				return;
			}
			comboBoxCarType.setEnabled(true);
			
			carTypeList.add("Select Car Type");
			for (Car car : carList) {
				if ( car.getCarName().equals(comboBoxCarBrand.getSelectedItem()) ) {
					if ( carTypeList.contains(car.getCarType()) == false ) {
						carTypeList.add(car.getCarType());
					}
				}
			}
			
			comboBoxCarType.setModel(new DefaultComboBoxModel<String>(carTypeList.toArray(new String[0])));
		}
		
		if ( e.getSource().equals(comboBoxCarType) ) {
			if ( comboBoxCarType.getSelectedItem().equals("Select Car Type") ) {
				textFieldCarDescription.setText("");
				textFieldCarDescription.setEnabled(false);
				
				return;
			}
			textFieldCarDescription.setEnabled(true);
			
			for (Car car : carList) {
				if (car.getCarName().equals(comboBoxCarBrand.getSelectedItem()) && car.getCarType().equals(comboBoxCarType.getSelectedItem())) {
					textFieldCarDescription.setText(car.getCarDescription());
					textFieldCarLicensePlate.setText(car.getCarLicensePlate());
				}
			}

			// Model is the date text field
			System.out.println(model.getDay());
		}
		
		if ( e.getSource().equals(comboBoxRenterName) ) {
			if (comboBoxRenterName.getSelectedItem().equals("Select Renter")) {
				textFieldRenterAddress.setText("");
				textFieldRenterTelephoneNumber.setText("");
				textFieldRenterEmailAddress.setText("");
				
				return;
			}
			
			for (Account account : accountList) {
				if ( account.getUsername().equals(comboBoxRenterName.getSelectedItem()) ) {
					textFieldRenterAddress.setText(account.getAddress());
					textFieldRenterTelephoneNumber.setText(account.getTelephoneNumber());
					textFieldRenterEmailAddress.setText(account.getEmail());
					
					return;
				}
			}
		}
		
		if ( e.getSource().equals(buttonAdd) ) {
			String carBrand;
			String carType;
			String carDescription = textFieldCarDescription.getText();
			int month = model.getMonth() + 1;
			String carRentDate = model.getDay() + "-" + month+ "-" + model.getYear();
			String carLicensePlate = textFieldCarLicensePlate.getText();
			String renterName;
			String renterAddress = textFieldRenterAddress.getText();
			String renterTelephoneNumber = textFieldRenterTelephoneNumber.getText();
			String renterEmailAddress = textFieldRenterEmailAddress.getText();
			
			try {
				carBrand = comboBoxCarBrand.getSelectedItem().toString();
			} catch (Exception e1) {
				carBrand = "";
				e1.printStackTrace();
			}
			
			try {
				carType = comboBoxCarType.getSelectedItem().toString();
			} catch (Exception e2) {
				carType = "";
				e2.printStackTrace();
			}			
			
			try {
				renterName = comboBoxRenterName.getSelectedItem().toString();
			} catch (Exception e1) {
				renterName = "";
				e1.printStackTrace();
			}
			
			boolean isInputValid = inputValidator(carBrand, carType, carDescription, carRentDate, carLicensePlate, renterName, renterAddress, renterTelephoneNumber, renterEmailAddress);
			
			if ( isInputValid ) {
				mainForm.addRentFormData(carBrand, carType, carDescription, carRentDate, carLicensePlate, renterName, renterAddress, renterTelephoneNumber, renterEmailAddress);
				
				JOptionPane.showMessageDialog(null, "Rent Form successfully submitted!", "Submit Success", JOptionPane.INFORMATION_MESSAGE);
				inputClear();
				this.hide();
			}
			
			System.out.println("Car Brand : " + carBrand);
			System.out.println("Car Type : " + carType);
			System.out.println("Car Description : " + carDescription);
			System.out.println("Car Rent Date : " + carRentDate + " - " + isDateFilled);
			System.out.println("Car License Plate : " + carLicensePlate);
			System.out.println("Renter Name : " + renterName);
			System.out.println("Renter Address : " + renterAddress);
			System.out.println("Renter Telephone Number : " + renterTelephoneNumber);
			System.out.println("Renter Email Address : " + renterEmailAddress);
		}
		
		if ( e.getSource().equals(buttonClear) ) {
			inputClear();
		}
	}
	
//	public static void main(String[] args) {
//		new BorrowForm();
//	}
}
