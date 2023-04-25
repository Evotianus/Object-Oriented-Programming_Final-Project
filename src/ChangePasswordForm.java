import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class ChangePasswordForm extends JFrame implements ActionListener {
	
	private JPanel windowPanel = new JPanel();
	
	private JPanel headerPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel usernamePanel = new JPanel();
	private JPanel oldPasswordPanel = new JPanel();
	private JPanel newPasswordPanel = new JPanel();
	private JPanel confirmPasswordPanel = new JPanel();
	
	private JLabel headerLabel = new JLabel("Change Password Form");
	
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel oldPasswordLabel = new JLabel("Old Password");
	private JLabel newPasswordLabel = new JLabel("New Password");
	private JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	
	private JTextField textFieldUsername = new JTextField();
	private JTextField textFieldOldPassword = new JTextField();
	private JTextField textFieldNewPassword = new JTextField();
	private JTextField textFieldConfirmPassword = new JTextField();
	
	private JButton buttonChangePassword = new JButton("Update");
	
	private MainForm mainForm;
	
	private ArrayList<Account> accounts;
	private Account loggedAccount;
	
	public void init_window() {		
		windowPanel.setLayout(new BorderLayout());
		
	}
	
	public void init_components() {
		headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
		headerPanel.add(headerLabel);
		
		windowPanel.add(headerPanel, "North");
		
		
		usernamePanel.setLayout(new GridLayout(1, 2));
		usernamePanel.add(usernameLabel);
		textFieldUsername.setPreferredSize(new Dimension(200, 25));
		usernamePanel.add(textFieldUsername);
		
		oldPasswordPanel.setLayout(new GridLayout(1, 2));
		oldPasswordPanel.add(oldPasswordLabel);
		textFieldOldPassword.setPreferredSize(new Dimension(200, 25));
		oldPasswordPanel.add(textFieldOldPassword);
		
		newPasswordPanel.setLayout(new GridLayout(1, 2));
		newPasswordPanel.add(newPasswordLabel);
		textFieldNewPassword.setPreferredSize(new Dimension(200, 25));
		newPasswordPanel.add(textFieldNewPassword);
		
		confirmPasswordPanel.setLayout(new GridLayout(1, 2));
		confirmPasswordPanel.add(confirmPasswordLabel);
		textFieldConfirmPassword.setPreferredSize(new Dimension(200, 25));
		confirmPasswordPanel.add(textFieldConfirmPassword);
		
//		inputPanel.setLayout(new GridLayout(3, 2));
		
		inputPanel.add(usernamePanel);
		inputPanel.add(oldPasswordPanel);
		inputPanel.add(newPasswordPanel);
		inputPanel.add(confirmPasswordPanel);
		
		windowPanel.add(inputPanel, "Center");
		
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(buttonChangePassword);
		
		buttonChangePassword.addActionListener(this);
		
		windowPanel.add(buttonPanel, "South");
	}
	
	public void loadAccountData(Account account, ArrayList<Account> accounts) {
		textFieldUsername.setEditable(false);
		
		loggedAccount = account;
		this.accounts = accounts;
		
		textFieldUsername.setText(account.getUsername());
	}
	
	public ChangePasswordForm(MainForm mainForm) {
		this.mainForm = mainForm;
		
		// TODO Auto-generated constructor stub
		init_window();
		init_components();
		
		add(windowPanel);
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 240);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	public boolean inputValidator() {
		String username = textFieldUsername.getText();
		String password = textFieldOldPassword.getText();
		String newPassword = textFieldNewPassword.getText();
		String confirmNewPassword = textFieldConfirmPassword.getText();
		boolean flag = false;
		
		String errorMessage = new String();		
		
		if ( username.length() < 1 ) {
			errorMessage += "Username must be filled!\n";
			flag = true;
		}
		
		if ( password.length() < 1  ) {
			errorMessage += "Password must be filled!\n";
			flag = true;
		}
		
		if ( newPassword.length() < 1 ) {
			errorMessage += "New password must be filled!\n";
			flag = true;
		}
		
		if ( confirmNewPassword.length() < 1  ) {
			errorMessage += "New password confirmation must be filled!\n";
			flag = true;
		}
		
		if ( !newPassword.equals(confirmNewPassword) ) {
			errorMessage += "New password and confirm password must be same!\n";
			flag = true;
		}
		
		
		if ( flag == true ) {
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error!", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public boolean authValidator() {	
		if ( mainForm.authAccount(textFieldUsername.getText(), textFieldOldPassword.getText()) ) {
			mainForm.changePassword(textFieldUsername.getText(), textFieldNewPassword.getText());
			
			JOptionPane.showMessageDialog(null, "Password changed successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "Old password wrong!", "Login Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource().equals(buttonChangePassword) ) {
			boolean isInputValid = inputValidator();
			
			if ( !isInputValid ) {
				return;
			}
			
			boolean isAccountValid = authValidator();
			if ( isInputValid && isAccountValid ) {
				this.hide();
				mainForm.show();				
			}
		}
	}
	
//	public static void main(String[] args) {
//		new ChangePasswordForm();
//	}
}
