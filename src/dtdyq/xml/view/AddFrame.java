package dtdyq.xml.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dtdyq.xml.Dao.Doc;
import dtdyq.xml.domain.DocUtil;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField addParent;
	private JTextField addName;
	private JTextField addLocation;
	private JTextField addValue;
	private JButton addAdd;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame("",new JTextArea());
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
	public AddFrame(String fileName,JTextArea XMLText) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParentNode = new JLabel("Parent Node:");
		lblParentNode.setFont(new Font("宋体", Font.PLAIN, 18));
		lblParentNode.setBounds(10, 27, 121, 24);
		contentPane.add(lblParentNode);
		
		addParent = new JTextField();
		addParent.setFont(new Font("宋体", Font.PLAIN, 18));
		addParent.setBounds(124, 27, 97, 30);
		contentPane.add(addParent);
		addParent.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNumber.setBounds(243, 27, 72, 24);
		contentPane.add(lblNumber);
		
		JLabel lblNodeName = new JLabel("Node Name:");
		lblNodeName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNodeName.setBounds(44, 85, 107, 30);
		contentPane.add(lblNodeName);
		
		JLabel lblNodeValue = new JLabel("Node Value:");
		lblNodeValue.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNodeValue.setBounds(44, 141, 107, 30);
		contentPane.add(lblNodeValue);
		
		addName = new JTextField();
		addName.setFont(new Font("宋体", Font.PLAIN, 18));
		addName.setBounds(161, 88, 220, 30);
		contentPane.add(addName);
		addName.setColumns(10);
		
		Vector<String> list=new Vector<>();
		list.add("head");
		list.add("insert");
		list.add("append");
		
		addLocation = new JTextField();
		addLocation.setToolTipText("the location of parent node in the xml file");
		addLocation.setFont(new Font("宋体", Font.PLAIN, 18));
		addLocation.setColumns(10);
		addLocation.setBounds(313, 27, 97, 30);
		contentPane.add(addLocation);
		
		addValue = new JTextField();
		addValue.setFont(new Font("宋体", Font.PLAIN, 18));
		addValue.setColumns(10);
		addValue.setBounds(161, 144, 220, 30);
		contentPane.add(addValue);
		
		Vector<Integer> numlist=new Vector<>();
		for(int i=0;i<500;i++){
			numlist.add(i);
		}
		
		addAdd = new JButton("Add");
		addAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String pName=addParent.getText();
				int index=Integer.parseInt(addLocation.getText());
				String nodeName=addName.getText();
				String nodeValue=addValue.getText();
				try {
					DocUtil.addNode(fileName, pName, index, nodeName, nodeValue);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				XMLText.setText(Doc.getFile(fileName));
				dispose();
			}
		});
		addAdd.setFont(new Font("宋体", Font.PLAIN, 18));
		addAdd.setBounds(124, 203, 93, 29);
		contentPane.add(addAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 18));
		btnCancel.setBounds(266, 203, 93, 29);
		contentPane.add(btnCancel);
	}
}
