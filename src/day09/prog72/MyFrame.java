package day09.prog72;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * Default frame width
	 */
	private static final int FRAME_WIDTH = 400;

	/**
	 * Default frame height
	 */
	private static final int FRAME_HEIGHT = 300;

	/**
	 * X coordinate of the frame default origin point
	 */
	private static final int FRAME_X_ORIGIN = 150;

	/**
	 * Y coordinate of the frame default origin point
	 */
	private static final int FRAME_Y_ORIGIN = 250;
	
	private JButton countBtn;
	private JButton reverseBtn;
	private JButton removeBtn;
	
	private JTextField inputTxf;
	private JTextField outputTxf;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 84488415705310300L;

	public MyFrame() {
		setTitle("");
		handleWindowClosing();
	}

	public MyFrame(String title) {
		setTitle(title);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		handleWindowClosing();
		
		Container ctnPane;
		ctnPane = getContentPane();
		
		JPanel jp = new JPanel();
		jp.setSize(270, 95);
		jp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		countBtn = new JButton("Count Letters");
		countBtn.setSize(120, 25);
		countBtn.addActionListener(this);
		jp.add(countBtn);
		
		reverseBtn = new JButton("Reverse Letters");
		reverseBtn.setSize(120, 25);
		reverseBtn.addActionListener(this);
		jp.add(reverseBtn);
		
		removeBtn = new JButton("Remove Duplicates");
		removeBtn.setSize(120, 25);
		removeBtn.addActionListener(this);
		jp.add(removeBtn);
		
		JLabel inputLbl = new JLabel("Input");
		jp.add(inputLbl);
		
		inputTxf = new JTextField();
		inputTxf.setSize(120, 25);
		jp.add(inputTxf);
		
		JLabel outputLbl = new JLabel("Output");
		jp.add(outputLbl);
		
		outputTxf = new JTextField();
		outputTxf.setSize(120, 25);
		jp.add(outputTxf);
		
		ctnPane.add(jp);
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

	}
}
