import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MainForm extends JFrame implements ActionListener, WindowListener {
	
	private JDesktopPane jdPane = new JDesktopPane();
	
	private JPanel panelContent = new JPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menuForm = new JMenu("Form");
	private JMenu menuInsert = new JMenu("Insert");
	private JMenu menuUser = new JMenu("User");
	private JMenu menuHistory = new JMenu("History");
	
	private JMenuItem menuItemUserChangePassword = new JMenuItem("Change Password");
	private JMenuItem menuItemUserLogOut = new JMenuItem("Log Out");
	private JMenuItem menuItemFormRent = new JMenuItem("Rent");
	private JMenuItem menuItemFormReturn = new JMenuItem("Return");
	private JMenuItem menuItemInsertCar = new JMenuItem("Insert new Car");
	private JMenuItem menuItemInsertUser = new JMenuItem("Insert new User");
	private JMenuItem menuItemHistoryReturnForm = new JMenuItem("Car Return History");
	
	private BorrowForm borrowForm = new BorrowForm(this);
	private ReturnForm returnForm = new ReturnForm(this);
	private InsertCar insertCar = new InsertCar(this);
	private InsertAccount insertAccount = new InsertAccount(this);
	private ChangePasswordForm changePasswordForm = new ChangePasswordForm(this);
	private LoginForm loginForm = new LoginForm(this);
	private ReturnFormHistory returnFormHistory = new ReturnFormHistory(this);
	
	// Table
	private JTable table_car;
	private JScrollPane scrollPane_table_car;
	private DefaultTableModel dtm_table_car;
	
	private JTable table_account;
	private JScrollPane scrollPane_table_account;
	private DefaultTableModel dtm_table_account;
	
	// Logged User
	private Account loggedUser;
	
	// Databases
	private ArrayList<Car> carList = new ArrayList<>();
	private ArrayList<Account> accountList = new ArrayList<>();
	private ArrayList<RentFormData> rentFormDataList = new ArrayList<>();
	private ArrayList<ReturnFormData> returnFormDataList = new ArrayList<>();
	
	public void init_menubar() {
		menuBar.add(menuForm);
		menuForm.add(menuItemFormRent);
		menuForm.add(new JSeparator());
		menuForm.add(menuItemFormReturn);
		
		menuBar.add(menuInsert);
		menuInsert.add(menuItemInsertCar);
		menuInsert.add(new JSeparator());
		menuInsert.add(menuItemInsertUser);
		
		menuBar.add(menuUser);
		menuUser.add(menuItemUserChangePassword);
		menuUser.add(new JSeparator());
		menuUser.add(menuItemUserLogOut);
		
		menuBar.add(menuHistory);
		menuHistory.add(menuItemHistoryReturnForm);
		
		menuItemFormRent.addActionListener(this);
		menuItemFormReturn.addActionListener(this);
		
		menuItemInsertCar.addActionListener(this);
		menuItemInsertUser.addActionListener(this);
		
		menuItemUserChangePassword.addActionListener(this);
		menuItemUserLogOut.addActionListener(this);
		
		menuItemHistoryReturnForm.addActionListener(this);
		
//		jdPane.add(menuBar);
	}
	
	public void init_car_data() {
		File carFile = new File("./src/database/car/database-car.txt");
		
		try {
			Scanner scan = new Scanner(carFile);
			
			String[] rawLine;
			
			String carName;
			String carType;
			String carDescription;
			String carLicensePlate;
			boolean isCarAvailable;
			
			while ( scan.hasNextLine() ) {
				rawLine = scan.nextLine().split("#");
				
				carName = rawLine[0];
				carType = rawLine[1];
				carDescription = rawLine[2];
				carLicensePlate = rawLine[3];
				isCarAvailable = Boolean.parseBoolean(rawLine[4]);
				
				carList.add(new Car(carName, carType, carDescription, carLicensePlate, isCarAvailable));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init_rent_form_data() {
		File rentFormFile = new File("./src/database/rent-form/database-rent-form.txt");
		
		try {
			Scanner scan = new Scanner(rentFormFile);
			
			String[] rawLine;
			
			String carBrand;
			String carType;
			String carDescription;
			String carRentDate;
			String carLicensePlate;
			String renterName;
			String renterAddress;
			String renterTelephoneNumber;
			String renterEmailAddress;
			boolean isCarReturned;
			
			while ( scan.hasNextLine() ) {
				rawLine = scan.nextLine().split("#");
				
				carBrand = rawLine[0];
				carType = rawLine[1];
				carDescription = rawLine[2];
				carRentDate = rawLine[3];
				carLicensePlate = rawLine[4];
				renterName = rawLine[5];
				renterAddress = rawLine[6];
				renterTelephoneNumber = rawLine[7];
				renterEmailAddress = rawLine[8];
				isCarReturned = Boolean.parseBoolean(rawLine[9]);
				
				rentFormDataList.add(new RentFormData(carBrand, carType, carDescription, carRentDate, carLicensePlate, renterName, renterAddress, renterTelephoneNumber, renterEmailAddress, isCarReturned));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init_return_form_data() {
		File returnFormFile = new File("./src/database/return-form/database-return-form.txt");
		
		try {
			Scanner scan = new Scanner(returnFormFile);
			
			String[] rawLine;
			
			String carBrand;
			String carType;
			String carRentDate;
			String carReturnDate;
			String carLicensePlate;
			String renterName;
			int renterFine;
			
			while ( scan.hasNextLine() ) {
				rawLine = scan.nextLine().split("#");
				
				carBrand = rawLine[0];
				carType = rawLine[1];
				carRentDate = rawLine[2];
				carReturnDate = rawLine[3];
				carLicensePlate = rawLine[4];
				renterName = rawLine[5];
				renterFine = Integer.parseInt(rawLine[6]);
				
				returnFormDataList.add(new ReturnFormData(carBrand, carType, carRentDate, carReturnDate, carLicensePlate, renterName, renterFine));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init_account_data() {
		File accountFile = new File("./src/database/account/database-account.txt");
		
		try {
			Scanner scan = new Scanner(accountFile);
			
			String[] rawLine;
			
			String username;
			String password;
			String address;
			String telephoneNumber;
			String email;
			boolean isAdmin;
			
			while ( scan.hasNextLine() ) {
				rawLine = scan.nextLine().split("#");
				
				username = rawLine[0];
				password = rawLine[1];
				address = rawLine[2];
				telephoneNumber = rawLine[3];
				email = rawLine[4];
				isAdmin = Boolean.parseBoolean(rawLine[5]);
				
				accountList.add(new Account(username, password, address, telephoneNumber, email, isAdmin));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void init_table_car() {
		String[] column = {"Car Name", "Car Type", "Car License Plate", "Car Availability"};
		
		dtm_table_car = new DefaultTableModel(column, 0);
		
		table_car.setModel(dtm_table_car);
		
		for (Car car : carList) {
			String carName = car.getCarName();
			String carType = car.getCarType();
			String carLicensePlate = car.getCarLicensePlate();
			String isCarAvailable;
			if (car.isCarAvailable()) {
				isCarAvailable = "true";
			} else {
				isCarAvailable = "false";
			}
			
			Object[] row = {carName, carType, carLicensePlate, isCarAvailable};
			dtm_table_car.addRow(row);
		}
	}
	
	public void init_table_account() {
		String[] column = {"Username", "Password", "Address", "Telephone", "Email", "Is Admin"};
		
		dtm_table_account = new DefaultTableModel(column, 0);
		
		table_account.setModel(dtm_table_account);
		
		for (Account account : accountList) {
			System.out.println(account.getUsername());
			String username = account.getUsername();
			String password = account.getPassword();
			String address = account.getAddress();
			String telephone = account.getTelephoneNumber();
			String email = account.getEmail();
			String isAdmin;
			if (account.isAdmin()) {
				isAdmin = "true";				
			} else {
				isAdmin = "false";
			}
			
			Object[] row = {username, password, address, telephone, email, isAdmin};
			
			setBackground(Color.RED);
			
			dtm_table_account.addRow(row);
		}
	}
	
	public void init_components() {
		table_car = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                String status = (String)getValueAt(row, 3);
                if ("true".equals(status)) {
                    c.setBackground(Color.GREEN);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }
                return c;
            }
		};
		
		scrollPane_table_car = new JScrollPane(table_car);
		
		table_account = new JTable() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		scrollPane_table_account = new JScrollPane(table_account);
		
		panelContent.setLayout(new BorderLayout());
		
		panelContent.add(new JLabel("Car List"), "North");
		panelContent.add(scrollPane_table_car, "Center");
//		panelContent.add(scrollPane_table_account, "Center");
	}
	
	public void init_dummy_data() {
//		accountList.add(new Account("user", "user", "Jl. Makan", "08123", "user@gmail.com", true));
	}
	
	public MainForm() {
		loginForm.show();
		// TODO Auto-generated constructor stub
		init_components();
		init_car_data();
		init_account_data();
		init_rent_form_data();
		init_return_form_data();
		init_table_car();
		init_table_account();
		init_menubar();
		
		init_dummy_data();
		
		add(jdPane);	
		addWindowListener(this);
		
		setContentPane(panelContent);
		
		setJMenuBar(menuBar);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	public boolean authAccount(String username, String password) {
		System.out.println(username + " - " + password);
		
		for (Account account : accountList) {
			if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
				if (account.isAdmin()) {
					loggedUser = new Account(username, password, "", "", "", true);
					return true;					
				}
			}
		}
		return false;
	}
	
	public void changePassword(String username, String newPassword) {
		for (Account account : accountList ) {
			if ( account.getUsername().equals(username) ) {
				account.setPassword(newPassword);
			}
		}
	}
	
	public void addRentFormData(String carBrand, String carType, String carDescription, String carRentDate, String carLicensePlate,
			String renterName, String renterAddress, String renterTelephoneNumber, String renterEmailAddress) {
		for (Car car : carList) {
			if (car.getCarName().equals(carBrand) && car.getCarType().equals(carType) && car.getCarLicensePlate().equals(carLicensePlate)) {
				car.setCarAvailable(false);
			}
		}
		
		rentFormDataList.add(new RentFormData(carBrand, carType, carDescription, carRentDate, carLicensePlate, renterName, renterAddress, renterTelephoneNumber, renterEmailAddress, false));
		
		init_table_car();
	}
	
	public void addReturnFormData(String carBrand, String carType, String carRentDate, String carReturnDate,
			String carLicensePlate, String renterName, int renterFine) {
		for (RentFormData rentFormData : rentFormDataList) {
			if (rentFormData.getCarBrand().equals(carBrand) && rentFormData.getCarType().equals(carType) && rentFormData.getRenterName().equals(renterName) && rentFormData.getCarRentDate().equals(carRentDate)) {
				rentFormData.setCarReturned(true);
				break;
			}
		}
		
		for (Car car : carList) {
			if (car.getCarName().equals(carBrand) && car.getCarType().equals(carType) && car.getCarLicensePlate().equals(carLicensePlate)) {
				car.setCarAvailable(true);
			}
		}
		
		returnFormDataList.add(new ReturnFormData(carBrand, carType, carRentDate, carReturnDate, carLicensePlate, renterName, renterFine));
		
		init_table_car();
	}
	
	public void addNewAccount(String username, String password, String address, String telephoneNumber, String email) {
		accountList.add(new Account(username, password, address, telephoneNumber, email, false));
	}
	
	public void addNewCar(String carBrand, String carType, String carDescription, String carLicensePlate) {
		carList.add(new Car(carBrand, carType, carDescription, carLicensePlate, true));
	}
	
	public static void main(String[] args) {
		new MainForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ( e.getSource().equals(menuItemFormRent) ) {
//			this.hide();
			borrowForm.show();
			borrowForm.init_form_data(carList, accountList);
		}
		
		if ( e.getSource().equals(menuItemFormReturn) ) {
//			this.hide();
			returnForm.show();
			returnForm.init_form_data(carList, rentFormDataList);
		}
		
		if ( e.getSource().equals(menuItemUserChangePassword) ) {
			changePasswordForm.loadAccountData(loggedUser, accountList);
			changePasswordForm.show();
		}
		
		if ( e.getSource().equals(menuItemUserLogOut) ) {
			loggedUser = null;
			this.hide();
			JOptionPane.showMessageDialog(null, "Account has been logged out!", "Logout", JOptionPane.INFORMATION_MESSAGE);
			loginForm.show();
		}
		
		if ( e.getSource().equals(menuItemInsertCar) ) {
			insertCar.load_car_data(carList);
			insertCar.show();
		}
		
		if ( e.getSource().equals(menuItemInsertUser) ) {
			insertAccount.load_account_data(accountList);
			insertAccount.show();
		}
		
		if ( e.getSource().equals(menuItemHistoryReturnForm) ) {
			returnFormHistory.load_return_form_data(returnFormDataList);
			returnFormHistory.show();
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			FileWriter writer = new FileWriter("./src/database/car/database-car.txt");
			
			for (Car car : carList) {
				writer.write(car.getCarName() + "#" + car.getCarType() + "#" + car.getCarDescription() + "#" + car.getCarLicensePlate() + "#" + car.isCarAvailable() + "\n");				
			}
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter("./src/database/account/database-account.txt");
			
			for (Account account : accountList) {
				writer.write(account.getUsername() + "#" + account.getPassword() + "#" + account.getAddress() + "#" + account.getAddress() + "#" + account.getEmail() + "#" + account.isAdmin() + "\n");
			}
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter("./src/database/rent-form/database-rent-form.txt");
			
			for (RentFormData rentFormData : rentFormDataList) {
				writer.write(rentFormData.getCarBrand() + "#" + rentFormData.getCarType() + "#" + rentFormData.getCarDescription() + "#" + rentFormData.getCarRentDate() + "#" + rentFormData.getCarLicensePlate() + "#" + rentFormData.getRenterName() + "#" + rentFormData.getRenterAddress() + "#" + rentFormData.getRenterTelephoneNumber() + "#" + rentFormData.getRenterEmailAddress() + "#" + rentFormData.isCarReturned() + "\n");
			}
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter("./src/database/return-form/database-return-form.txt");
			
			for (ReturnFormData returnFormData : returnFormDataList) {
				writer.write(returnFormData.getCarBrand() + "#" + returnFormData.getCarType() + "#" + returnFormData.getCarRentDate() + "#" + returnFormData.getCarReturnDate() + "#" + returnFormData.getCarLicensePlate() + "#" + returnFormData.getRenterName() + "#" + returnFormData.getRenterFine());
			}
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
