package ServerViews;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainUI extends JPanel{

	private JButton btnCreateContest;
	private JButton btnCreateProblem;
	private JButton btnLoadContest;
	private JButton btnListProblem;

	public MainUI() {
		setLayout(new BorderLayout());
		
		JPanel pn = new JPanel();
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
		
		Font font = new Font("Times New Roman", Font.BOLD, 30);
		Dimension size = new Dimension(500, 70);
		
		JPanel pn1 = new JPanel();
		pn1.add(btnCreateContest = new JButton("Create New Local Contest"));
		btnCreateContest.setPreferredSize(size);
		btnCreateContest.setFont(font);
		pn.add(pn1);
		
		JPanel pn2 = new JPanel();
		pn2.add(btnCreateProblem = new JButton("Create Problem"));
		btnCreateProblem.setPreferredSize(size);
		btnCreateProblem.setFont(font);
		pn.add(pn2);
		
		JPanel pn3 = new JPanel();
		pn3.add(btnLoadContest = new JButton("Load Online Contest"));
		btnLoadContest.setPreferredSize(size);
		btnLoadContest.setFont(font);
		pn.add(pn3);
		
		JPanel pn4 = new JPanel();
		pn4.add(btnListProblem = new JButton("List Problem"));
		btnListProblem.setPreferredSize(size);
		btnListProblem.setFont(font);
		pn.add(pn4);
		
		
		add(pn);
		
		//pack();
		
		//event
		
		/*btnCreateContest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateContest.setVisible(true);
				
			}
		});*/
		
		btnCreateProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel createProblem = new CreateProblemUI();
				removeAll();
				setLayout(new BorderLayout(0,0));
				add(createProblem);
				validate();
				repaint();
			}
		});
		
		//btnLoadContest.addActionListener(this);
		
		btnListProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel listProblem = new ListProblemUI();
				removeAll();
				setLayout(new BorderLayout(0,0));
				add(listProblem);
				validate();
				repaint();
			}
		});
		
	}
}
