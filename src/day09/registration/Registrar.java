package day09.registration;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Registrar extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7525408099713432300L;
	private JFrame frame;
	private JTable profTbl;
	
	private ArrayList<Professor> profList = new ArrayList<Professor>();

	private JTextField txtNameProf;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Registrar window = new Registrar("Registration app");
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Registrar() {
		setTitle("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private Registrar(String title) {
		setTitle(title);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(this);
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(this);
		mnFile.add(mntmSave);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(this);
		mnFile.add(mntmQuit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0 };
		gridBagLayout.rowHeights = new int[] { 518, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);

		// Professor tab
		JTabbedPane profTPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Professor", null, profTPanel, null);
		
		JPanel panelProf = new JPanel();
		profTPanel.addTab("Professor", null, panelProf, null);
		panelProf.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(16, 24, 51, 16);
		panelProf.add(lblName);
		
		txtNameProf = new JTextField();
		txtNameProf.setBounds(75, 20, 180, 25);
		panelProf.add(txtNameProf);
		txtNameProf.setColumns(10);
		
		JButton btnAddProf = new JButton("Add Professor");
		btnAddProf.setBounds(75, 60, 120, 25);
		btnAddProf.addActionListener(this);
		panelProf.add(btnAddProf);
		
		JButton btnClearProf = new JButton("Clear Professor");
		btnClearProf.setBounds(190, 60, 120, 25);
		btnClearProf.addActionListener(this);
		panelProf.add(btnClearProf);
		
		JScrollPane scrollPaneProf = new JScrollPane();
		scrollPaneProf.setBounds(16, 105, 375, 293);
		panelProf.add(scrollPaneProf);
		
		DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
	    profTbl = new JTable(model);
		profTbl.setFillsViewportHeight(true);
		scrollPaneProf.setColumnHeaderView(profTbl);
		
		// Student tab
		JTabbedPane studTPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Student", null, studTPanel, null);

		// Course tab
		JTabbedPane crsTPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Course", null, crsTPanel, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem tmp = (JMenuItem) e.getSource();
			switch (tmp.getText()) {
			case "Quit":
				System.exit(0);
				break;
			case "Save":
				// Save all data to CSV
				break;
			case "Open": 
				// Read all data from CSV
				break;
			default:
				break;
			}
		} else {
			if (e.getSource() instanceof JButton) {
				JButton jb = (JButton) e.getSource();
				switch (jb.getText()) {
				case "Add Professor":
					System.out.println("Add Professor");
					addProfessor();
					break;
				case "Clear Professor":
					System.out.println("Clear Professor");
					clearProffesor();
					break;
				default:
					break;
				}
			}
		}
	}
	
	private void addProfessor() {
		Professor p = new Professor();
		int id = profList.size() + 1;
		String name = txtNameProf.getText();
		p.setId(id + "");
		p.setName(txtNameProf.getText());
		profList.add(p);
		DefaultTableModel profModel = (DefaultTableModel) profTbl.getModel();
		profModel.addRow(new Object[]{id + "", name});
	}
	
	private void clearProffesor() {
		txtNameProf.setText("");
	}
//	
//	private void addStudent() {
//		
//	}
//	
//	private void clearStudent() {
//		
//	}
}
