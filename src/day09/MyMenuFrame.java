package day09;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyMenuFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8012651518213412336L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MyMenuFrame window = new MyMenuFrame("My Menu Frame");
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MyMenuFrame() {
		setTitle("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MyMenuFrame(String title) {
		setTitle(title);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(this);
		mnFile.add(mntmQuit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmErase = new JMenuItem("Erase");
		mntmErase.addActionListener(this);
		mnEdit.add(mntmErase);

		JMenu mnColor = new JMenu("Color");
		menuBar.add(mnColor);

		JMenuItem mntmRed = new JMenuItem("Red");
		mntmRed.addActionListener(this);
		mnColor.add(mntmRed);

		JMenuItem mntmGreen = new JMenuItem("Green");
		mntmGreen.addActionListener(this);
		mnColor.add(mntmGreen);

		JMenuItem mntmBlue = new JMenuItem("Blue");
		mntmBlue.addActionListener(this);
		mnColor.add(mntmBlue);

		JMenuItem mntmPink = new JMenuItem("Pink");
		mntmPink.addActionListener(this);
		mnColor.add(mntmPink);

		JMenuItem mntmBlack = new JMenuItem("Black");
		mntmBlack.addActionListener(this);
		mnColor.add(mntmBlack);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem tmp = (JMenuItem) e.getSource();
			switch (tmp.getText()) {
			case "Erase":
				frame.getContentPane().setBackground(null);
				break;
			case "Quit":
				System.exit(0);
				break;
			case "Red":
				frame.getContentPane().setBackground(Color.RED);
				break;
			case "Green": 
				frame.getContentPane().setBackground(Color.GREEN);
				break;
			case "Blue": 
				frame.getContentPane().setBackground(Color.BLUE);
				break;			
			case "Pink": 
				frame.getContentPane().setBackground(Color.PINK);
				break;
			case "Black": 
				frame.getContentPane().setBackground(Color.BLACK);
				break;
			default:
				break;
			}
		}
	}
}
