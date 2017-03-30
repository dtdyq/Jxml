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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttributeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField setPath;
	private JTextField setName;
	private JTextField setValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttributeFrame frame = new AttributeFrame("",new JTextArea());
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
	public AttributeFrame(String fileName,JTextArea XMLText) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 190, 417, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNodePath = new JLabel("Node Path:");
		lblNodePath.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNodePath.setBounds(22, 32, 102, 28);
		contentPane.add(lblNodePath);
		
		setPath = new JTextField();
		setPath.setFont(new Font("宋体", Font.PLAIN, 18));
		setPath.setBounds(134, 33, 241, 27);
		contentPane.add(setPath);
		setPath.setColumns(10);
		
		JLabel lblAttributeName = new JLabel("Attribute Name:");
		lblAttributeName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAttributeName.setBounds(22, 90, 147, 28);
		contentPane.add(lblAttributeName);
		
		JLabel lblAttributeValue = new JLabel("Attribute Value:");
		lblAttributeValue.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAttributeValue.setBounds(22, 150, 147, 28);
		contentPane.add(lblAttributeValue);
		
		setName = new JTextField();
		setName.setFont(new Font("宋体", Font.PLAIN, 18));
		setName.setBounds(194, 93, 181, 27);
		contentPane.add(setName);
		setName.setColumns(10);
		
		setValue = new JTextField();
		setValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=setPath.getText();
				String aName=setName.getText();
				String aValue=setValue.getText();
				DocUtil.setAttr(fileName, path, aName, aValue);
				XMLText.setText(Doc.getFile(fileName));
				dispose();
			}
		});
		setValue.setFont(new Font("宋体", Font.PLAIN, 18));
		setValue.setColumns(10);
		setValue.setBounds(194, 153, 181, 27);
		contentPane.add(setValue);
		
		JButton setAttr = new JButton("SetAttr");
		setAttr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=setPath.getText();
				String aName=setName.getText();
				String aValue=setValue.getText();
				DocUtil.setAttr(fileName, path, aName, aValue);
				XMLText.setText(Doc.getFile(fileName));
				dispose();
			}
		});
		setAttr.setFont(new Font("宋体", Font.PLAIN, 18));
		setAttr.setBounds(56, 202, 110, 36);
		contentPane.add(setAttr);
		
		JButton setCancel = new JButton("Cencel");
		setCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setCancel.setFont(new Font("宋体", Font.PLAIN, 18));
		setCancel.setBounds(206, 202, 110, 36);
		contentPane.add(setCancel);
	}

}
