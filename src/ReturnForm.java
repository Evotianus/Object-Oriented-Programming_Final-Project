import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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

public class ReturnForm extends JFrame implements ActionListener {
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
	private JLabel labelCarReturnDate = new JLabel("Car Return Date");
	
	private JComboBox<String> comboBoxCarBrand = new JComboBox<String>();
	private JComboBox<String> comboBoxCarType = new JComboBox<String>();
	
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarBrand = new JTextField();
	private JTextField textFieldCarReturnDate = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();
	
	
	// Renter Detail
	private JPanel panelRenterDetail = new JPanel();
	private JPanel panelRenterHeader = new JPanel();
	
	private JPanel panelRenterName = new JPanel();
	private JPanel panelCarRentDate = new JPanel();
	private JPanel panelCarReturnDate = new JPanel();
	private JPanel panelRenterDayElapsed = new JPanel();
	private JPanel panelRenterFine = new JPanel();
	
	private JLabel labelRenterName = new JLabel("Renter Name");
	private JLabel labelCarRentDate = new JLabel("Car Rent Date");
	private JLabel labelRenterDayElapsed = new JLabel("Rent Period");
	private JLabel labelRenterFine = new JLabel("Rental Fee");
	
	private boolean isDateFilled = false;
	private boolean isRentDateFilled = false;
	
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
				
				calculateElapsedDay(textFieldCarRentDate.getText());
				return strDate;					
			}
			calculateElapsedDay("");
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
	
	private UtilDateModel modelRent = new UtilDateModel();
	private Properties pRent = new Properties();
	private JDatePanelImpl datePanelRent = new JDatePanelImpl(modelRent, pRent);
	private JDatePickerImpl datePickerRent = new JDatePickerImpl(datePanelRent, new AbstractFormatter() {
		
		@Override
		public String valueToString(Object value) throws ParseException {
			// TODO Auto-generated method stub
			if ( value != null ) {
				Calendar cal = (Calendar) value;
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String strDate = format.format(cal.getTime());
				isRentDateFilled = true;
				
				return strDate;					
			}
			isRentDateFilled = false;
			
			return "";
		}
		
		@Override
		public Object stringToValue(String text) throws ParseException {
			// TODO Auto-generated method stub
			isRentDateFilled = false;
			return "";
		}
	});
	
//	private JComboBox<String> comboBoxRenterName = new JComboBox<String>();
	
	private JTextField textFieldRenterName = new JTextField();
	private JTextField textFieldCarRentDate = new JTextField();
	private JTextField textFieldRenterDayElapsed = new JTextField();
	private JTextField textFieldRenterFine = new JTextField();
	
	
	// Button Event Listener
	private JPanel panelReturnFormButton = new JPanel();
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonClear = new JButton("Clear");
	
	
	private MainForm mainForm;
	
	
	// Database
	private ArrayList<Car> carList;
	private ArrayList<String> carBrandList = new ArrayList<>(Arrays.asList("Select Car Brand"));
	private ArrayList<String> carTypeList = new ArrayList<>();
	private ArrayList<RentFormData> rentFormDataList;
	private ArrayList<String> formDataAccountUsernameList = new ArrayList<>(Arrays.asList("Select Renter"));
	
	
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
		
		panelCarDetail.add(panelCarType);
		
		
		panelCarRentDate.setLayout(new GridLayout(1,4));
		panelCarRentDate.add(new JPanel());
		panelCarRentDate.add(labelCarRentDate);
		panelCarRentDate.add(textFieldCarRentDate);
		panelCarRentDate.add(new JPanel());
		
		textFieldCarRentDate.setEnabled(false);
		
		panelCarDetail.add(panelCarRentDate);
		
		
		panelCarReturnDate.setLayout(new GridLayout(1,4));
		panelCarReturnDate.add(new JPanel());
		panelCarReturnDate.add(labelCarReturnDate);
		panelCarReturnDate.add(datePicker);
		panelCarReturnDate.add(new JPanel());
		
		panelCarDetail.add(panelCarReturnDate);
		
		
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
		panelRenterDetail.setLayout(new GridLayout(4, 1));
		
		panelRenterHeader.setLayout(new FlowLayout());
		panelRenterHeader.add(new JLabel("Renter Details"));
		
		panelRenterDetail.add(panelRenterHeader);
		
		
		panelRenterName.setLayout(new GridLayout(1, 4));
		panelRenterName.add(new JPanel());
		panelRenterName.add(labelRenterName);
		textFieldRenterName.setPreferredSize(new Dimension(300, 25));
		panelRenterName.add(textFieldRenterName);
		panelRenterName.add(new JPanel());
		
		textFieldRenterName.setEnabled(false);
		
		panelRenterDetail.add(panelRenterName);
		
		
		panelRenterDayElapsed.setLayout(new GridLayout(1,4));
		panelRenterDayElapsed.add(new JPanel());
		panelRenterDayElapsed.add(labelRenterDayElapsed);
		panelRenterDayElapsed.add(textFieldRenterDayElapsed);
		panelRenterDayElapsed.add(new JPanel());
		
		textFieldRenterDayElapsed.setEnabled(false);
		
		panelRenterDetail.add(panelRenterDayElapsed);
		
		
		panelRenterFine.setLayout(new GridLayout(1,4));
		panelRenterFine.add(new JPanel());
		panelRenterFine.add(labelRenterFine);
		panelRenterFine.add(textFieldRenterFine);
		panelRenterFine.add(new JPanel());
		
		textFieldRenterFine.setEnabled(false);
		
		panelRenterDetail.add(panelRenterFine);
		
		comboBoxCarBrand.addActionListener(this);
		comboBoxCarType.addActionListener(this);
		
		panelSpacing.setPreferredSize(new Dimension(3, 1));
		panelWindow.add(panelRenterDetail);
		panelWindow.add(panelSpacing);
	}
	
	void init_button_components() {
//		panelReturnFormButton.setLayout(new FlowLayout());
		
		panelReturnFormButton.add(buttonAdd);
		panelReturnFormButton.add(buttonClear);
		
		buttonAdd.addActionListener(this);
		buttonClear.addActionListener(this);
		
		panelWindow.add(panelReturnFormButton);
	}
	
	void init_window() {
//		setLayout(new GridLayout(10, 1));
//		panelWindow.setLayout(new GridLayout(4, 1));
		add(panelWindow);
		setTitle("Return Form");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}
	
	public void init_form_data(ArrayList<Car> carList, ArrayList<RentFormData> rentFormDataList) {
		this.carList = carList;
		this.rentFormDataList = rentFormDataList;
		
		for (RentFormData rentFormData : rentFormDataList) {
			if ( !carBrandList.contains(rentFormData.getCarBrand()) && rentFormData.isCarReturned() == false ) {
				carBrandList.add(rentFormData.getCarBrand());
			}		
		}
		
		comboBoxCarBrand.setModel(new DefaultComboBoxModel<String>(carBrandList.toArray(new String[0])));
	}
	
	public boolean inputValidator(String carBrand, String carType, String carRentDate, String carReturnDate, String carLicensePlate, String renterName, int renterFine) {
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
		if (isDateFilled == false) {
			errorMessage += "Car Return Date must be filled!\n";
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
		textFieldCarRentDate.setText("");
		textFieldCarLicensePlate.setText("");
		textFieldRenterName.setText("");
		textFieldRenterDayElapsed.setText("");
		textFieldRenterFine.setText("");
		model.setValue(null);
		modelRent.setValue(null);
		isDateFilled = false;
	}
	
	public void calculateElapsedDay(String rentDate) {
		if(rentDate.length() == 0) return;
		
		String[] carRentDateRaw = rentDate.split("-");
		
		int rentDateDay = Integer.parseInt(carRentDateRaw[0]);
		int rentDateMonth = Integer.parseInt(carRentDateRaw[1]);
		int rentDateYear = Integer.parseInt(carRentDateRaw[2]);
		
		int returnDateDay = model.getDay();
		int returnDateMonth = model.getMonth() + 1;
		int returnDateYear = model.getYear();
		
//		System.out.println(returnDateMonth + " - " + rentDateMonth);
		
		int dayCount = ((returnDateDay - rentDateDay) * 1) + ((returnDateMonth - rentDateMonth) * 30) + ((returnDateYear - rentDateYear) * 365);
		
//		System.out.println(dayCount);
		textFieldRenterDayElapsed.setText("" + dayCount);
		

		Integer totalFine = Integer.parseInt(textFieldRenterDayElapsed.getText()) * 70;
		textFieldRenterFine.setText(totalFine.toString());
	}
	
	public ReturnForm(MainForm mainForm) {
		this.mainForm = mainForm;
		
		init_car_components();
		init_renter_components();
		init_button_components();
		init_window(); 	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource().equals(comboBoxCarBrand) ) {
			
			carTypeList.clear();
			
			if ( comboBoxCarBrand.getSelectedItem().equals("Select Car Brand") ) {
				comboBoxCarType.setModel(new DefaultComboBoxModel<String>(carTypeList.toArray(new String[0])));
				comboBoxCarType.setEnabled(false);
				return;
			}
			comboBoxCarType.setEnabled(true);
			
			carTypeList.add("Select Car Type");
			for (RentFormData rentFormData : rentFormDataList) {
				if ( rentFormData.getCarBrand().equals(comboBoxCarBrand.getSelectedItem()) ) {
					if ( carTypeList.contains(rentFormData.getCarType()) == false ) {
						carTypeList.add(rentFormData.getCarType());
					}
				}
			}
			
			comboBoxCarType.setModel(new DefaultComboBoxModel<String>(carTypeList.toArray(new String[0])));
		}
		
		if ( e.getSource().equals(comboBoxCarType) ) {
			if ( comboBoxCarType.getSelectedItem().equals("Select Car Type") ) {
				textFieldCarLicensePlate.setText("");
				
				return;
			}
			int rentDay, rentMonth, rentYear;
			String rentDateRaw[];
			for (RentFormData rentFormData : rentFormDataList) {
				if (rentFormData.getCarBrand().equals(comboBoxCarBrand.getSelectedItem()) && rentFormData.getCarType().equals(comboBoxCarType.getSelectedItem())) {
					rentDateRaw = rentFormData.getCarRentDate().split("-");
					rentDay = Integer.parseInt(rentDateRaw[0]);
					rentMonth = Integer.parseInt(rentDateRaw[1]);
					rentYear = Integer.parseInt(rentDateRaw[2]);
					
					Date date1= new Date();
					try {
						date1 = new SimpleDateFormat("dd-MM-yyyy").parse(rentFormData.getCarRentDate());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					modelRent.setValue(date1);
					textFieldCarLicensePlate.setText(rentFormData.getCarLicensePlate());
					textFieldRenterName.setText(rentFormData.getRenterName());
					textFieldCarRentDate.setText(rentFormData.getCarRentDate());
				}
			}

			// Model is the date text field
//			System.out.println(model.getDay());
		}
		
		if ( e.getSource().equals(buttonAdd) ) {
			String carBrand;
			String carType;
			String carRentDate = textFieldCarRentDate.getText();
			String carReturnDate = model.getDay() + "-" + model.getMonth() + "-" + model.getYear(); 
			String carLicensePlate = textFieldCarLicensePlate.getText();
			String renterName = textFieldRenterName.getText();
			Integer renterFine = Integer.parseInt(textFieldRenterFine.getText());
			
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
			
			boolean isInputValid = inputValidator(carBrand, carType, carRentDate, carReturnDate, carLicensePlate, renterName, renterFine);
			
			if ( isInputValid ) {
				mainForm.addReturnFormData(carBrand, carType, carRentDate, carReturnDate, carLicensePlate, renterName, renterFine);
				
				JOptionPane.showMessageDialog(null, "Return Form successfully submitted!", "Submit Success", JOptionPane.INFORMATION_MESSAGE);
				inputClear();
				this.hide();
			}
		}
		
		if ( e.getSource().equals(buttonClear) ) {
			inputClear();
		}
	}
	
//	public static void main(String[] args) {
//		new ReturnForm();
//	}
}
