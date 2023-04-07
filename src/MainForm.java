import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MainForm extends JFrame {
	
	private JDesktopPane jdPane = new JDesktopPane();
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menuForm = new JMenu("Form");
	private JMenu menuRegistration = new JMenu("Registration");
	
	private JMenuItem menuItemRegistrationChangePassword = new JMenuItem("Change Password");
	private JMenuItem menuItemRegistrationLogOut = new JMenuItem("Log Out");
	private JMenuItem menuItemFormRent = new JMenuItem("Rent");
	private JMenuItem menuItemFormReturn = new JMenuItem("Return");
	
	public void init_menubar() {
		menuBar.add(menuForm);
		menuForm.add(menuItemFormRent);
		menuForm.add(new JSeparator());
		menuForm.add(menuItemFormReturn);
		
//		jdPane.add(menuBar);
	}
	
	public MainForm() {
		// TODO Auto-generated constructor stub
		
		add(jdPane);
		init_menubar();
		
		setJMenuBar(menuBar);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainForm();
	}
	
}
