package day09.prog71;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * Default frame width
	 */
	private static final int FRAME_WIDTH = 560;

	/**
	 * Default frame height
	 */
	private static final int FRAME_HEIGHT = 200;

	/**
	 * X coordinate of the frame default origin point
	 */
	private static final int FRAME_X_ORIGIN = 150;

	/**
	 * Y coordinate of the frame default origin point
	 */
	private static final int FRAME_Y_ORIGIN = 250;
	
	private JTextField nameTxf;
	private JTextField streetTxf;
	private JTextField cityTxf;
	private JTextField stateTxf;
	private JTextField zipTxf;

	private static final long serialVersionUID = -3224490791677722423L;

	public MyFrame() {
		setTitle("");
		handleWindowClosing();
	}

	public MyFrame(String title) throws HeadlessException {
		setTitle(title);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		// register 'Exit upon closing' as a default close operation
		// setDefaultCloseOperation( EXIT_ON_CLOSE );
		handleWindowClosing();
		
		Container ctnPane;
		ctnPane = getContentPane( );
		ctnPane.setLayout( null );
        
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(30, 5, 140, 25);
        ctnPane.add(nameLbl);
        
        nameTxf = new JTextField();
        nameTxf.setBounds(30, 30, 140, 25);
        ctnPane.add(nameTxf);
        
        JLabel strLbl = new JLabel("Street");
        strLbl.setBounds(200, 5, 140, 25);
        ctnPane.add(strLbl);
        
        streetTxf = new JTextField();
        streetTxf.setBounds(200, 30, 140, 25);
        ctnPane.add(streetTxf);
        
        JLabel cityLbl = new JLabel("City");
        cityLbl.setBounds(370, 5, 120, 25);
        ctnPane.add(cityLbl);
        
        cityTxf = new JTextField();
        cityTxf.setBounds(370, 30, 140, 25);
        ctnPane.add(cityTxf);
        
        JLabel stateLbl = new JLabel("State");
        stateLbl.setBounds(125, 60, 140, 25);
        ctnPane.add(stateLbl);
        
        stateTxf = new JTextField();
        stateTxf.setBounds(125, 85, 140, 25);
        ctnPane.add(stateTxf);
        
        JLabel zipLbl = new JLabel("Zip");
        zipLbl.setBounds(295, 60, 140, 25);
        ctnPane.add(zipLbl);
        
        zipTxf = new JTextField();
        zipTxf.setBounds(295, 85, 140, 25);
        ctnPane.add(zipTxf);
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(220, 125, 120, 25);
        submitBtn.addActionListener(this);
		ctnPane.add(submitBtn);
	}

	private void handleWindowClosing() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				dispose();
				// other clean-up
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) { //  && ((JButton) e.getSource()).getText().equals("Submit")
            System.out.println(nameTxf.getText());
            System.out.println(streetTxf.getText());
            System.out.println(cityTxf.getText() + ", " + stateTxf.getText() + " " + zipTxf.getText());
        }
	}
}
