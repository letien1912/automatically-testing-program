package ServerViews;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Server_MainUI extends JFrame {
	
	private JPanel contentPane;
	private JButton btnCreateContest;
	private JButton btnCreateProblem;
	private JButton btnLoadContest;
	private JButton btnListProblem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_MainUI frame = new Server_MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server_MainUI() {
		setTitle("Hệ thống chấm bài tự động");
		setSize(1020, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		JPanel main = new MainUI();
		contentPane.removeAll();
		contentPane.setLayout(new BorderLayout(0,0));
		contentPane.add(main);
		contentPane.validate();
		contentPane.repaint();
	}
}
