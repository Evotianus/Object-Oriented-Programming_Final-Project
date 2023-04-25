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

public class InsertAccount extends JFrame implements ActionListener {
    // window layout
    private JPanel panelWindow = new JPanel();
    private JPanel panelSpacing = new JPanel();

    // Account Detail
    private JPanel panelAccountDetail = new JPanel();
	private JPanel panelAccountHeader = new JPanel();

    private JPanel panelAccountName = new JPanel();
    private JPanel panelAccountPassword = new JPanel();
	private JPanel panelAccountNumber = new JPanel();
	private JPanel panelAccountAddress = new JPanel();
    private JPanel panelAccountEmailAddress = new JPanel();
	
    private JLabel labelAccountName = new JLabel("Name");
    private JLabel labelAccountPassword = new JLabel("Password");
	private JLabel labelAccountNumber = new JLabel("Phone Number");
	private JLabel labelAccountAddress = new JLabel("Home Address");
    private JLabel labelAccountEmailAddress = new JLabel("Email Address");
	
    private JTextField textFieldAccountName = new JTextField();
    private JTextField textFieldAccountPassword = new JTextField();
	private JTextField textFieldAccountNumber = new JTextField();
	private JTextField textFieldAccountAddress = new JTextField();
    private JTextField textFieldAccountEmailAddress = new JTextField();

    private JPanel panelAddAccountButton = new JPanel();
    private JButton buttonAdd = new JButton("Add");

    private MainForm mainForm;
    
    
    // Database
    private ArrayList<Account> accountList;

    void init_user_components() {
		panelAccountDetail.setLayout(new GridLayout(6, 1));
		
		panelAccountHeader.setLayout(new FlowLayout());
		panelAccountHeader.add(new JLabel("Renter Details"));
		
		panelAccountDetail.add(panelAccountHeader);
		
		
		panelAccountName.setLayout(new GridLayout(1, 4));
		panelAccountName.add(new JPanel());
		panelAccountName.add(labelAccountName);
		textFieldAccountName.setPreferredSize(new Dimension(300, 25));
		panelAccountName.add(textFieldAccountName);
		panelAccountName.add(new JPanel());
		
		panelAccountDetail.add(panelAccountName);
		
		
		panelAccountPassword.setLayout(new GridLayout(1, 4));
		panelAccountPassword.add(new JPanel());
		panelAccountPassword.add(labelAccountPassword);
		textFieldAccountPassword.setPreferredSize(new Dimension(300, 25));
		panelAccountPassword.add(textFieldAccountPassword);
		panelAccountPassword.add(new JPanel());
		
		panelAccountDetail.add(panelAccountPassword);
		
		
		panelAccountAddress.setLayout(new GridLayout(1,4));
		panelAccountAddress.add(new JPanel());
		panelAccountAddress.add(labelAccountAddress);
		panelAccountAddress.add(textFieldAccountAddress);
		panelAccountAddress.add(new JPanel());
		
		panelAccountDetail.add(panelAccountAddress);

		
		panelAccountNumber.setLayout(new GridLayout(1,4));
		panelAccountNumber.add(new JPanel());
		panelAccountNumber.add(labelAccountNumber);
		panelAccountNumber.add(textFieldAccountNumber);
		panelAccountNumber.add(new JPanel());
		
		panelAccountDetail.add(panelAccountNumber);
		
		
		panelAccountEmailAddress.setLayout(new GridLayout(1,4));
		panelAccountEmailAddress.add(new JPanel());
		panelAccountEmailAddress.add(labelAccountEmailAddress);
		panelAccountEmailAddress.add(textFieldAccountEmailAddress);
		panelAccountEmailAddress.add(new JPanel());
		
		panelAccountDetail.add(panelAccountEmailAddress);
		
		panelSpacing.setPreferredSize(new Dimension(3, 1));
		panelWindow.add(panelAccountDetail);
		panelWindow.add(panelSpacing);
	}

    void init_button_components() {        
        panelAddAccountButton.add(buttonAdd);
        
        buttonAdd.addActionListener(this);
        
        panelWindow.add(panelAddAccountButton);
    }
    
    void load_account_data(ArrayList<Account> accountList) {
    	this.accountList = accountList;
    }

    void init_window() {
        add(panelWindow);
        setTitle("Add Car");
        setSize(650, 225);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public boolean inputValidator(String accountUsername, String accountPassword, String accountAddress, String accountTelephoneNumber, String accountEmailAddress) {
    	boolean flag = false;
    	String errorMessage = "";
    	
    	if (accountUsername.equals("")) {
    		errorMessage += "Name must be filled!\n";
    		flag = true;
    	}
    	if (accountAddress.equals("")) {
    		errorMessage += "Address must be filled!\n";
    		flag = true;
    	}
    	if (accountTelephoneNumber.equals("")) {
    		errorMessage += "Telephone Number must be filled!\n";
    		flag = true;
    	}
    	if (accountEmailAddress.equals("")) {
    		errorMessage += "Email Address must be filled!\n";
    		flag = true;
    	}
    	if ( flag == true  ) {	
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
    	
    	// Validation for same user
    	for (Account account : accountList) {
    		if (account.getUsername().equals(accountUsername) && account.getPassword().equals(accountPassword) && account.getAddress().equals(accountAddress) && account.getTelephoneNumber().equals(accountTelephoneNumber) && account.getEmail().equals(accountEmailAddress)) {
    			JOptionPane.showMessageDialog(null, "Account with this detail already created!", "Account Error!", JOptionPane.ERROR_MESSAGE);
    			return false;    			
    		}
    	}
    	
		return true;
    }

    public InsertAccount(MainForm mainForm) {
        this.mainForm = mainForm;

        init_user_components();
        init_button_components();
        init_window();
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource().equals(buttonAdd) ) {
			String accountUsername = textFieldAccountName.getText();
			String accountPassword = textFieldAccountPassword.getText();
			String accountAddress = textFieldAccountAddress.getText();
			String accountTelephoneNumber = textFieldAccountNumber.getText();
			String accountEmailAddress = textFieldAccountEmailAddress.getText();
			
			boolean isInputValid = inputValidator(accountUsername, accountPassword, accountAddress, accountTelephoneNumber, accountEmailAddress);
			
			if ( isInputValid ) {
				mainForm.addNewAccount(accountUsername, accountPassword, accountAddress, accountTelephoneNumber, accountEmailAddress);
				
				JOptionPane.showMessageDialog(null, "Account successfully added!", "Insert Success", JOptionPane.INFORMATION_MESSAGE);
				this.hide();
			}
		}
	}
}
