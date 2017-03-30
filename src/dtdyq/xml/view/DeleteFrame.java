package dtdyq.xml.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dtdyq.xml.Dao.Doc;
import dtdyq.xml.domain.DocUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField deletePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame frame = new DeleteFrame("",new JTextArea());
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
	public DeleteFrame(String fileName,JTextArea XMLText) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 180, 382, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeletedNodePath = new JLabel("Deleted Node Path:");
		lblDeletedNodePath.setFont(new Font("宋体", Font.PLAIN, 20));
		lblDeletedNodePath.setBounds(23, 41, 217, 36);
		contentPane.add(lblDeletedNodePath);
		
		deletePath = new JTextField();
		deletePath.setFont(new Font("宋体", Font.PLAIN, 18));
		deletePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEvent(fileName,XMLText);
				
				dispose();
			}
		});
		deletePath.setBounds(80, 102, 248, 31);
		contentPane.add(deletePath);
		deletePath.setColumns(10);
		
		JButton deleteDelete = new JButton("Delete");
		deleteDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEvent(fileName,XMLText);
				dispose();
			}
		});
		
		deleteDelete.setFont(new Font("宋体", Font.PLAIN, 20));
		deleteDelete.setBounds(80, 167, 105, 31);
		contentPane.add(deleteDelete);
		
		JButton deleteCancel = new JButton("Cancel");
		deleteCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		deleteCancel.setFont(new Font("宋体", Font.PLAIN, 20));
		deleteCancel.setBounds(209, 167, 105, 31);
		contentPane.add(deleteCancel);
	}
	private void deleteEvent(String fileName,JTextArea XMLText){
		String path=deletePath.getText();
		DocUtil.deleteNode(fileName, path);
		XMLText.setText(Doc.getFile(fileName));
	}
}
