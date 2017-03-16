package ServerViews;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateProblemUI extends JPanel {

	private JTextField txtMaBai;
	private JTextField txtTenBai;
	private JTextField txtDoKho;
	private JTextField txtDangBai;
	private JTextArea txtDeBai;
	private JButton btnFileDeBai;
	private JButton btnInput;
	private JButton btnOutput;
	private JButton btnCreateProblem;
	private JButton btnReset;
	private JButton btnCancel;
	private JLabel lblOutputNotify;
	private JLabel lblInputNotify;
	private JLabel lblFileDeBaiNotify;

	public CreateProblemUI() {
		setLayout(new BorderLayout());

		JPanel pn = new JPanel();
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));

		JPanel pn1 = new JPanel();
		JLabel lblMaBai;
		pn1.add(lblMaBai = new JLabel("Mã bài: "));
		pn1.add(txtMaBai = new JTextField(20));
		JLabel lblTenBai;
		pn1.add(lblTenBai = new JLabel("Tên bài: "));
		pn1.add(txtTenBai = new JTextField(20));
		txtMaBai.requestFocus();

		pn.add(pn1);

		JPanel pn2 = new JPanel();
		JLabel lblDoKho;
		pn2.add(lblDoKho = new JLabel("Độ khó: "));
		pn2.add(txtDoKho = new JTextField(20));
		JLabel lblDangBai;
		pn2.add(lblDangBai = new JLabel("Dạng bài: "));
		pn2.add(txtDangBai = new JTextField(20));

		pn.add(pn2);

		JPanel pn3 = new JPanel();
		JLabel lblDeBai;
		pn3.add(lblDeBai = new JLabel("Đề bài: "));
		txtDeBai = new JTextArea(10, 46);
		JScrollPane jsb = new JScrollPane(txtDeBai);
		pn3.add(jsb);

		pn.add(pn3);

		JPanel pn4 = new JPanel();
		pn4.add(btnFileDeBai = new JButton("Browse"));
		pn4.add(lblFileDeBaiNotify = new JLabel("No file selected"));

		btnFileDeBai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						lblFileDeBaiNotify.setText(file + " ");
						txtDeBai.read(new FileReader(file.getAbsolutePath()), null);
					} catch (IOException ex) {
						lblFileDeBaiNotify.setText("Error");
					}
				} else {
					// log.append("Open command cancelled by user." );
				}
			}
		});

		pn.add(pn4);

		JPanel pn5 = new JPanel();
		JLabel lblInput;
		pn5.add(lblInput = new JLabel("Input: "));
		pn5.add(btnInput = new JButton("Browse"));
		pn5.add(lblInputNotify = new JLabel("No Folder selected"));

		btnInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser folderChoose = new JFileChooser();
				folderChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				folderChoose.showSaveDialog(null);
				File folder = folderChoose.getCurrentDirectory();
				lblInputNotify.setText(folder + " ");
			}
		});

		JLabel lblOutput;
		pn5.add(lblOutput = new JLabel("Output: "));
		pn5.add(btnOutput = new JButton("Browse"));
		pn5.add(lblOutputNotify = new JLabel("No Folder selected"));

		btnOutput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser folderChoose = new JFileChooser();
				folderChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				folderChoose.showSaveDialog(null);
				File folder = folderChoose.getCurrentDirectory();
				lblOutputNotify.setText(folder + " ");
			}
		});

		pn.add(pn5);

		JPanel pn6 = new JPanel();
		pn6.add(btnCreateProblem = new JButton("Create Problem"));
		pn6.add(btnReset = new JButton("Reset"));
		pn6.add(btnCancel = new JButton("Cancel"));

		btnCreateProblem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// CreateProblem

			}
		});

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetText();
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel main = new MainUI();
				removeAll();
				setLayout(new BorderLayout(0, 0));
				add(main);
				validate();
				repaint();
			}
		});

		pn.add(pn6);
		
		add(pn);
		
		lblDeBai.setPreferredSize(lblDoKho.getPreferredSize());
		lblMaBai.setPreferredSize(lblDoKho.getPreferredSize());
		lblInput.setPreferredSize(lblDoKho.getPreferredSize());
		
		lblTenBai.setPreferredSize(lblDangBai.getPreferredSize());
		lblOutput.setPreferredSize(lblDangBai.getPreferredSize());
	}

	protected void resetText() {
		txtMaBai.setText("");
		txtTenBai.setText("");
		txtDoKho.setText("");
		txtDangBai.setText("");
		txtDeBai.setText("");
		lblFileDeBaiNotify.setText("No file selected");
		lblInputNotify.setText("No Folder selected");
		lblOutputNotify.setText("No Folder selected");
		txtMaBai.requestFocus();
	}
}
