package ServerViews;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListProblemUI extends JPanel{
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnViewProblem;
	private JButton btnCreateProblem;
	private AbstractButton btnDeleteProblem;

	public ListProblemUI() {
		setLayout(new BorderLayout());
		
		JPanel pn = new JPanel();
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(new BorderLayout());
		String[] colName = {"Mã bài","Tên","�?ộ khó","Dạng bài"};
		tableModel = new DefaultTableModel(colName, 20);
		table = new JTable(tableModel);
		JScrollPane js = new JScrollPane(table);
		pn1.add(js, BorderLayout.CENTER);
		
		pn.add(pn1);
		
		JPanel pn2 = new JPanel();
		pn2.add(btnViewProblem = new JButton("View Problem"));
		btnViewProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// View Problem
				
			}
		});
		
		pn2.add(btnCreateProblem = new JButton("Create Problem"));
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
		
		pn2.add(btnDeleteProblem = new JButton("Delete Problem"));
		btnDeleteProblem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				tableModel.removeRow(i);
			}
		});	
		
		pn.add(pn2);
		
		add(pn);
	}
	
}
