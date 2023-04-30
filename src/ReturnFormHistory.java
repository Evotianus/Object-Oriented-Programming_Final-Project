import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReturnFormHistory extends JFrame implements ActionListener, WindowListener {

    private JDesktopPane jdPane = new JDesktopPane();
    private JPanel panelContent = new JPanel();

    private JTable table_rentedCar;
    private JScrollPane scrollPane_table_rentedCar;
    private DefaultTableModel dtm_table_rentedCar;

    private ArrayList<ReturnFormData> returnFormDataList = new ArrayList<>();

    private MainForm mainForm;

    public void init_table_rentedCar() {
		String[] column = {"Car Brand", "Car Type", "Rent Date", "Return Date", "Licence Plate", "Renter", "Total Rental Fee"};
		
		dtm_table_rentedCar = new DefaultTableModel(column, 0);
		
		table_rentedCar.setModel(dtm_table_rentedCar);
		
		for (ReturnFormData returnFormData : returnFormDataList) {
			
			String carBrand = returnFormData.getCarBrand();
			String carType = returnFormData.getCarType();
			String carRentDate = returnFormData.getCarRentDate();
			String carReturnDate = returnFormData.getCarReturnDate();
			String carLicencePlate = returnFormData.getCarLicensePlate();
			String renterName = returnFormData.getRenterName();
			Integer renterFine = returnFormData.getRenterFine();
			
			Object[] row = {carBrand, carType, carRentDate, carReturnDate, carLicencePlate, renterName, renterFine.toString()};
			dtm_table_rentedCar.addRow(row);
		}
	}

    public void init_components() {
        table_rentedCar = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		panelContent.setLayout(new BorderLayout());

        scrollPane_table_rentedCar = new JScrollPane(table_rentedCar);

        panelContent.add(new JLabel("Rented Car List"), "North");
		panelContent.add(scrollPane_table_rentedCar, "Center");

    }
    
    public void load_return_form_data(ArrayList<ReturnFormData> returnFormDataList) {
    	this.returnFormDataList = returnFormDataList;
    	
    	init_table_rentedCar();
    }

    public ReturnFormHistory(MainForm mainForm) {
        this.mainForm = mainForm;
		init_components();


		add(jdPane);

		setContentPane(panelContent);

        setSize(700, 500);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation();
		setVisible(false);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
    
}
