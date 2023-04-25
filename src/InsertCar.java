import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 1. CAR BRAND
// 2. CAR Type
// 3. CAR LICENSE PLATE

public class InsertCar extends JFrame implements ActionListener {
    // window layout
    private JPanel panelWindow = new JPanel();
    private JPanel panelSpacing = new JPanel();

    // Car Detail
    private JPanel panelCarDetail = new JPanel();
	private JPanel panelCarHeader = new JPanel();

    private JPanel panelCarBrand = new JPanel();
	private JPanel panelCarType = new JPanel();
	private JPanel panelCarDescription = new JPanel();
	private JPanel panelCarLicensePlate = new JPanel();
	
    private JLabel labelCarBrand = new JLabel("Car Brand");
	private JLabel labelCarType = new JLabel("Car Type");
	private JLabel labelCarDescription = new JLabel("Car Description");
	private JLabel labelCarLicensePlate = new JLabel("Car License Plate");
	
    private JTextField textFieldCarBrand = new JTextField();
	private JTextField textFieldCarType = new JTextField();
	private JTextField textFieldCarDescription = new JTextField();
	private JTextField textFieldCarLicensePlate = new JTextField();

    // Button
    private JPanel panelAddCarButton = new JPanel();
    private JButton buttonAdd = new JButton("Add");

    private MainForm mainForm;
    
    
    // Database
    private ArrayList<Car> carList;

    void init_car_components() {
        panelCarDetail.setLayout(new GridLayout(5, 1));
		
		panelCarHeader.setLayout(new FlowLayout());
		panelCarHeader.add(new JLabel("Add Car"));
		
		panelCarDetail.add(panelCarHeader);

        panelCarBrand.setLayout(new GridLayout(1, 4));
        panelCarBrand.add(new JPanel());
        panelCarBrand.add(labelCarBrand);
        textFieldCarBrand.setPreferredSize(new Dimension(300, 25));
        panelCarBrand.add(textFieldCarBrand);
        panelCarBrand.add(new JPanel());

        panelCarDetail.add(panelCarBrand);

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

    void init_button_components() {
        panelAddCarButton.add(buttonAdd);
        
        buttonAdd.addActionListener(this);
        
        panelWindow.add(panelAddCarButton);
    }
    
    void load_car_data(ArrayList<Car> carList) {
    	this.carList = carList;	
    }

    void init_window() {
        add(panelWindow);
        setTitle("Add Car");
        setSize(650, 225);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public boolean inputValidator(String carBrand, String carType, String carDescription, String carLicensePlate) {
    	boolean flag = false;
    	String errorMessage = "";
    	
    	if (carBrand.equals("")) {
    		errorMessage += "Car Brand must be filled!\n";
    		flag = true;
    	}
    	if (carType.equals("")) {
    		errorMessage += "Car Type must be filled!\n";
    		flag = true;
    	}
    	if (carDescription.equals("")) {
    		errorMessage += "Car Description must be filled!\n";
    		flag = true;
    	}
    	if (carLicensePlate.equals("")) {
    		errorMessage += "Car Licence Plate must be filled!\n";
    		flag = true;    		
    	}
    	
    	if ( flag == true  ) {	
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
    	
    	// Validation for same license plate
    	for (Car car : carList) {
    		if (car.getCarLicensePlate().equals(carLicensePlate)) {
    			JOptionPane.showMessageDialog(null, "Car with this License Plate already created!", "Car Error!", JOptionPane.ERROR_MESSAGE);
    			return false;  
    		}
    	}
    	
    	return true;
    }

    public InsertCar(MainForm mainForm) {
        this.mainForm = mainForm;

        init_car_components();
        init_button_components();
        init_window();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource().equals(buttonAdd) ) {
			String carBrand = textFieldCarBrand.getText();
			String carType = textFieldCarType.getText();
			String carDescription = textFieldCarDescription.getText();
			String carLicensePlate = textFieldCarLicensePlate.getText();
			
			boolean isInputValid = inputValidator(carBrand, carType, carDescription, carLicensePlate);
			
			if ( isInputValid ) {
				mainForm.addNewCar(carBrand, carType, carDescription, carLicensePlate);
				
				JOptionPane.showMessageDialog(null, "Car successfully added!", "Insert Success", JOptionPane.INFORMATION_MESSAGE);
				this.hide();
			}
		}
	}
}
