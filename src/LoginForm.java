import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class LoginForm extends JFrame {
	
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
		
		windowPanel.add(buttonPanel, "South");
	}
	
	public LoginForm() {
		// TODO Auto-generated constructor stub
		init_window();
		init_components();
		
		add(windowPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoginForm();
	}
}
