import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MainWindow implements ActionListener {

	private JFrame frame;
	private JTable table;
	private static Integer cells[][];
	private Resolver r;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		cells = new Integer[8][8];
		for(int x = 0; x < 8; x ++)
		{
			for (int y = 0; y < 8; y++)
			{
				cells[y][x] = 0;
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 183, 203);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable(cells, new Object[]
				{"1", "2","3","4","5","6","7","8"});
		table.setCellSelectionEnabled(true);
		frame.getContentPane().add(table, BorderLayout.NORTH);
		
		JButton btnSetFirst = new JButton("Set First");
		btnSetFirst.addActionListener(this);
		btnSetFirst.setActionCommand("start");
		frame.getContentPane().add(btnSetFirst, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reset");
		mnNewMenu.add(mntmNewMenuItem_1);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("start"))
		{
			Integer ix = table.getSelectionModel().getLeadSelectionIndex();
			Integer iy = table.getColumnModel().getSelectionModel().getLeadSelectionIndex();
			System.out.println(ix.toString() + " " + iy.toString());
			r = new Resolver(ix,iy, cells);
			Integer[][] newcells = r.Start();
			for(int x = 0; x < 8; x++)
			{
				for (int y = 0; y < 8; y++)
				{
					cells[x][y] = newcells[x][y];
				}
			}
			System.out.println();
			r.printtbl(cells);
			table.selectAll();
			table.clearSelection();
			if(r.pass < 8)
			{
				JOptionPane.showMessageDialog(null, "Failed");
			}else{
				JOptionPane.showMessageDialog(null, "Success!");
			}
		}
	}
	
}
