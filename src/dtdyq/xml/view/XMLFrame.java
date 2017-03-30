package dtdyq.xml.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XMLFrame extends JFrame {

	private JPanel contentPane;
	private JTextField FileName;
	private JButton XMLImport;
	private JButton XMLCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XMLFrame frame = new XMLFrame();
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
	public XMLFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 160, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTheXmlPath = new JLabel("the xml path:");
		lblTheXmlPath.setFont(new Font("宋体", Font.PLAIN, 20));
		lblTheXmlPath.setBounds(61, 37, 165, 35);
		panel.add(lblTheXmlPath);
		
		FileName = new JTextField();
		FileName.setFont(new Font("宋体", Font.PLAIN, 18));
		FileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame(FileName.getText()).setVisible(true);
				dispose();
			}
		});
		FileName.setBounds(61, 106, 259, 35);
		panel.add(FileName);
		FileName.setColumns(10);
		
		XMLImport = new JButton("Import");
		XMLImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame(FileName.getText()).setVisible(true);
				dispose();
			}
		});
		XMLImport.setFont(new Font("宋体", Font.PLAIN, 18));
		XMLImport.setBounds(164, 195, 93, 31);
		panel.add(XMLImport);
		
		XMLCancel = new JButton("Cancel");
		XMLCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		XMLCancel.setFont(new Font("宋体", Font.PLAIN, 18));
		XMLCancel.setBounds(282, 195, 93, 31);
		panel.add(XMLCancel);
	}
}
