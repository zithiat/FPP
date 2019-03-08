package day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ch7TextFrame1 extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3037952919347081964L;

	private static final int FRAME_WIDTH    = 300;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 200;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * Default width for buttons
     */
    private static final int BUTTON_WIDTH  = 80;

    /**
     * Default height for buttons
     */
    private static final int BUTTON_HEIGHT = 30;

    /**
     * The Swing button for Cancel
     */
    private JButton cancelButton;


    /**
     * The Swing button for OK
     */
    private JButton okButton;

    /**
     * The JTextField for the user to enter a text
     */
    private JTextField inputLine;



//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch7TextFrame1 frame = new Ch7TextFrame1();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch7TextFrame1() {
        Container contentPane;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program Ch7TextFrame1");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout( null );
        contentPane.setBackground( Color.white );

        //create and place two buttons on the frame
        okButton = new JButton("OK");
        okButton.setBounds(70, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(160, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(cancelButton);

        //register this frame as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        inputLine = new JTextField();
        inputLine.setBounds(90, 50, 130, 25);
        contentPane.add(inputLine);

        inputLine.addActionListener(this);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();

            String  buttonText = clickedButton.getText();

            setTitle("You clicked " + buttonText);

        } else { //the event source is inputLine
            setTitle("You entered '" + inputLine.getText() + "'");
        }
    }

}
