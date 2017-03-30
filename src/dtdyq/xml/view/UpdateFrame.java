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

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField updatePath;
	private JTextField updateName;
	private JTextField updateValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame("",new JTextArea());
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
	public UpdateFrame(String fileName,JTextArea XMLText) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 190, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNodePath = new JLabel("Node Path:");
		lblNodePath.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNodePath.setBounds(22, 41, 115, 31);
		contentPane.add(lblNodePath);
		
		updatePath = new JTextField();
		updatePath.setFont(new Font("宋体", Font.PLAIN, 18));
		updatePath.setBounds(138, 41, 234, 31);
		contentPane.add(updatePath);
		updatePath.setColumns(10);
		
		JLabel lblNodeName = new JLabel("Node Name:");
		lblNodeName.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNodeName.setBounds(22, 106, 115, 31);
		contentPane.add(lblNodeName);
		
		JLabel lblNodeValue = new JLabel("Node Value:");
		lblNodeValue.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNodeValue.setBounds(22, 153, 115, 31);
		contentPane.add(lblNodeValue);
		
		updateName = new JTextField();
		updateName.setFont(new Font("宋体", Font.PLAIN, 18));
		updateName.setColumns(10);
		updateName.setBounds(138, 106, 234, 31);
		contentPane.add(updateName);
		
		updateValue = new JTextField();
		updateValue.setFont(new Font("宋体", Font.PLAIN, 18));
		updateValue.setColumns(10);
		updateValue.setBounds(138, 153, 234, 31);
		contentPane.add(updateValue);
		
		JButton updateUpdate = new JButton("Update");
		updateUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=updatePath.getText();
				String nodeN=updateName.getText();
				String nodeV=updateValue.getText();
				DocUtil.updateNode(fileName, path, nodeN, nodeV);
				XMLText.setText(Doc.getFile(fileName));
				dispose();
			}
		});
		updateUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
		updateUpdate.setBounds(90, 212, 115, 31);
		contentPane.add(updateUpdate);
		
		JButton updateCancel = new JButton("Cancel");
		updateCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		updateCancel.setFont(new Font("宋体", Font.PLAIN, 20));
		updateCancel.setBounds(228, 212, 105, 31);
		contentPane.add(updateCancel);
	}

}
