import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
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

public class LoginForm extends JFrame implements ActionListener {
	
	private JPanel windowPanel = new JPanel();
	
	private JPanel headerPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel usernamePanel = new JPanel();
	private JPanel passwordPanel = new JPanel();
	
	private JLabel headerLabel = new JLabel("Login Form");
	
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	
	private JTextField textFieldUsername = new JTextField();
	private JTextField textFieldPassword = new JTextField();
	
	private JButton buttonLogin = new JButton("Login");
	private JButton buttonRegister = new JButton("Register");
	
	private MainForm mainForm;
	
	public void init_window() {		
		windowPanel.setLayout(new BorderLayout());
		
	}
	
	public void init_components() {
		headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
		headerPanel.add(headerLabel);
		
		windowPanel.add(headerPanel, "North");
		
		
		usernamePanel.setLayout(new FlowLayout());
		usernamePanel.add(usernameLabel);
		textFieldUsername.setPreferredSize(new Dimension(200, 25));
		usernamePanel.add(textFieldUsername);
		
		passwordPanel.setLayout(new FlowLayout());
		passwordPanel.add(passwordLabel);
		textFieldPassword.setPreferredSize(new Dimension(200, 25));
		passwordPanel.add(textFieldPassword);
		
		inputPanel.add(usernamePanel);
		inputPanel.add(passwordPanel);
		
		windowPanel.add(inputPanel, "Center");
		
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(buttonLogin);
		buttonPanel.add(buttonRegister);
		
		buttonLogin.addActionListener(this);
		
		windowPanel.add(buttonPanel, "South");
	}
	
	public LoginForm(MainForm mainForm) {
		this.mainForm = mainForm;
		
		init_window();
		init_components();
		
		add(windowPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
//		setVisible(true);
	}
	
	public boolean inputValidator() {
		String username = textFieldUsername.getText();
		String password = textFieldPassword.getText();
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
		
		if ( flag == true ) {
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error!", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public boolean authValidator() {	
		if ( mainForm.authAccount(textFieldUsername.getText(), textFieldPassword.getText()) ) {
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "Username or Password error!", "Login Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(buttonLogin) ) {	
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
//		new LoginForm();
//	}
}
