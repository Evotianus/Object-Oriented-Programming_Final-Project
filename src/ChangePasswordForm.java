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

public class ChangePasswordForm extends JFrame {
	
	private JPanel windowPanel = new JPanel();
	
	private JPanel headerPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel usernamePanel = new JPanel();
	private JPanel passwordPanel = new JPanel();
	private JPanel confirmPasswordPanel = new JPanel();
	
	private JLabel headerLabel = new JLabel("Change Password Form");
	
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	
	private JTextField textFieldUsername = new JTextField();
	private JTextField textFieldPassword = new JTextField();
	private JTextField textFieldConfirmPassword = new JTextField();
	
	private JButton buttonChangePassword = new JButton("Update");
	
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
		
		passwordPanel.setLayout(new GridLayout(1, 2));
		passwordPanel.add(passwordLabel);
		textFieldPassword.setPreferredSize(new Dimension(200, 25));
		passwordPanel.add(textFieldPassword);
		
		confirmPasswordPanel.setLayout(new GridLayout(1, 2));
		confirmPasswordPanel.add(confirmPasswordLabel);
		textFieldConfirmPassword.setPreferredSize(new Dimension(200, 25));
		confirmPasswordPanel.add(textFieldConfirmPassword);
		
//		inputPanel.setLayout(new GridLayout(3, 2));
		
		inputPanel.add(usernamePanel);
		inputPanel.add(passwordPanel);
		inputPanel.add(confirmPasswordPanel);
		
		windowPanel.add(inputPanel, "Center");
		
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(buttonChangePassword);
		
		windowPanel.add(buttonPanel, "South");
	}
	
	public ChangePasswordForm() {
		// TODO Auto-generated constructor stub
		init_window();
		init_components();
		
		add(windowPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChangePasswordForm();
	}
}
