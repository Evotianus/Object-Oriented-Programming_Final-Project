import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainForm extends JFrame {
	
	private JDesktopPane jdPane = new JDesktopPane();
	
	private JPanel panelContent = new JPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menuForm = new JMenu("Form");
	private JMenu menuRegistration = new JMenu("Registration");
	
	private JMenuItem menuItemRegistrationChangePassword = new JMenuItem("Change Password");
	private JMenuItem menuItemRegistrationLogOut = new JMenuItem("Log Out");
	private JMenuItem menuItemFormRent = new JMenuItem("Rent");
	private JMenuItem menuItemFormReturn = new JMenuItem("Return");
	
	
	// Table
	private JTable table_car;
	private JScrollPane scrollPane_table_car;
	private DefaultTableModel dtm_table_car;
	
	
	
	// Databases
	private ArrayList<Car> carList = new ArrayList<>();
	
	public void init_menubar() {
		menuBar.add(menuForm);
		menuForm.add(menuItemFormRent);
		menuForm.add(new JSeparator());
		menuForm.add(menuItemFormReturn);
		
//		jdPane.add(menuBar);
	}
	
	public void init_car_data() {
		File carFile = new File("./src/database/car/database-car.txt");
		
		try {
			Scanner scan = new Scanner(carFile);
			
			String[] rawLine;
			
			String carName;
			String carType;
			String carLicensePlate;
			boolean isCarAvailable;
			
			while ( scan.hasNextLine() ) {
				rawLine = scan.nextLine().split("#");
				
				carName = rawLine[0];
				carType = rawLine[1];
				carLicensePlate = rawLine[2];
				isCarAvailable = Boolean.parseBoolean(rawLine[3]);
				
				carList.add(new Car(carName, carType, carLicensePlate, isCarAvailable));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init_table_car() {
		String[] column = {"Car Name", "Car Type", "Car License Plate"};
		
		dtm_table_car = new DefaultTableModel(column, 0);
		
		table_car.setModel(dtm_table_car);
		
		for (Car car : carList) {
//			System.out.println("Car Name: " + car.getCarName());
//			System.out.println("Car Type: " + car.getCarType());
//			System.out.println("Car Licence Plate: " + car.getCarLicensePlate());
//			System.out.println("Car Status: " + car.isCarAvailable());
//			System.out.println("============================================================");
			
			String carName = car.getCarName();
			String carType = car.getCarType();
			String carLicensePlate = car.getCarLicensePlate();
//			boolean isCarAvailable = car.isCarAvailable();
			
			Object[] row = {carName, carType, carLicensePlate};
			dtm_table_car.addRow(row);
		}
	}
	
	public void init_components() {
		table_car = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		scrollPane_table_car = new JScrollPane(table_car);
		
		panelContent.setLayout(new BorderLayout());
		
		panelContent.add(new JLabel("Car List"), "North");
		panelContent.add(scrollPane_table_car, "Center");
	}
	
	public MainForm() {
		// TODO Auto-generated constructor stub
		init_components();
		init_car_data();
		init_table_car();
		init_menubar();
		
		add(jdPane);		
		
		setContentPane(panelContent);
		
		setJMenuBar(menuBar);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainForm();
	}
	
}
