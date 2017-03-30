package dtdyq.xml.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dtdyq.xml.Dao.Doc;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainFrame extends JFrame {
	private String fileName;

	private JPanel contentPane;
	private JTextArea XMLText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("");
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
	public MainFrame(String fileName) {
		this.fileName=fileName;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 559);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSet = new JMenu("set");
		menuBar.add(mnSet);
		
		JCheckBoxMenuItem chckbxmntmEdit = new JCheckBoxMenuItem("Edit");
		chckbxmntmEdit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbxmntmEdit.isSelected()){
					XMLText.setEditable(true);
				}
				else{
					XMLText.setEditable(false);
				}
			}
		});
		
		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size=Integer.parseInt(JOptionPane.showInputDialog(null, null, null));
				XMLText.setFont(new Font("Consolas", Font.PLAIN, size));
			}
		});
		mnSet.add(mntmFont);
		mnSet.add(chckbxmntmEdit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 724, 412);
		contentPane.add(scrollPane);
		
		XMLText = new JTextArea();
		XMLText.setEditable(false);
		XMLText.setFont(new Font("Consolas", Font.PLAIN, 20));
		XMLText.setText(Doc.getFile(fileName));
		XMLText.setColumns(20);
		scrollPane.setViewportView(XMLText);
		
		JButton mainAdd = new JButton("Add");
		mainAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddFrame(fileName,XMLText).setVisible(true);
			}
		});
		mainAdd.setFont(new Font("宋体", Font.PLAIN, 20));
		mainAdd.setBounds(129, 456, 69, 33);
		contentPane.add(mainAdd);
		
		JButton mainUpdate = new JButton("Update");
		mainUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateFrame(fileName,XMLText).setVisible(true);
			}
		});
		mainUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
		mainUpdate.setBounds(208, 456, 108, 33);
		contentPane.add(mainUpdate);
		
		JButton mainDelete = new JButton("Delete");
		mainDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteFrame(fileName,XMLText).setVisible(true);
			}
		});
		mainDelete.setFont(new Font("宋体", Font.PLAIN, 20));
		mainDelete.setBounds(326, 456, 96, 33);
		contentPane.add(mainDelete);
		
		JButton mainSetattr = new JButton("SetAttr");
		mainSetattr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AttributeFrame(fileName,XMLText).setVisible(true);
			}
		});
		mainSetattr.setFont(new Font("宋体", Font.PLAIN, 20));
		mainSetattr.setBounds(432, 456, 108, 33);
		contentPane.add(mainSetattr);
		
		JButton mainView = new JButton("View");
		mainView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XMLText.setText("");
				XMLText.setText(Doc.getFile(fileName));
				XMLText.setCursor(new Cursor(0));
			}
		});
		mainView.setFont(new Font("宋体", Font.PLAIN, 20));
		mainView.setBounds(41, 456, 78, 33);
		contentPane.add(mainView);
		
		JButton mainSave = new JButton("Save");
		mainSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp=XMLText.getText();
				try {
					Files.write(Paths.get(fileName), temp.getBytes(),StandardOpenOption .WRITE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mainSave.setFont(new Font("宋体", Font.PLAIN, 20));
		mainSave.setBounds(550, 456, 78, 33);
		contentPane.add(mainSave);
		
		JButton mainClose = new JButton("Close");
		mainClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mainClose.setFont(new Font("宋体", Font.PLAIN, 20));
		mainClose.setBounds(638, 456, 96, 33);
		contentPane.add(mainClose);
	}
}
