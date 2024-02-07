package firstpac;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class Function extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Function frame = new Function();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Function() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Function.class.getResource("/images/1111.png")));
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250,250,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		DashboardAndNotification(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 212, 629);
		contentPane.add(panel);
		panel.setLayout(null);
		
	

	}



	
	void DashboardAndNotification(JPanel contentPane) {
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Function.class.getResource("/images/vvvvv.png")));
		lblNewLabel_1.setBounds(20, 103, 38, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Function.class.getResource("/images/wwwwwwwwwwwwwwwww (1).png")));
		lblNewLabel_1_1.setBounds(20, 194, 38, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Function.class.getResource("/images/tuttttttt (1).png")));
		lblNewLabel_1_2.setBounds(20, 282, 38, 38);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(Function.class.getResource("/images/stuuuu (1).png")));
		lblNewLabel_1_3.setBounds(20, 368, 38, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setIcon(new ImageIcon(Function.class.getResource("/images/hhhhhhhhhhhhhhhhhh (1).png")));
		lblNewLabel_1_4.setBounds(20, 456, 38, 38);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setIcon(new ImageIcon(Function.class.getResource("/images/logggg (1).png")));
		lblNewLabel_1_5.setBounds(20, 547, 38, 38);
		contentPane.add(lblNewLabel_1_5);

		    

	
	
	JButton btnNewButton_2 = new JButton("Dashboard");
	btnNewButton_2.setSelected(true);
	btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2.setBackground(Color.gray);
	btnNewButton_2.setBounds(30, 103, 179, 38);
	btnNewButton_2.setBorderPainted(false);  
	btnNewButton_2.setContentAreaFilled(false);  
	contentPane.add(btnNewButton_2);
	btnNewButton_2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
//			 dispose(); here dispose aint working so the below code is used to disclose
			 ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2)).dispose();
			    Dashboard dashboard = new Dashboard();
			    dashboard.setVisible(true);
        }
    });

	
	
	JButton btnNewButton_2_1 = new JButton("Courses");
	btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2_1.setBackground(Color.gray);
	btnNewButton_2_1.setBounds(30, 194, 179, 38);
	contentPane.add(btnNewButton_2_1);
	btnNewButton_2_1.setBorderPainted(false);  
	btnNewButton_2_1.setContentAreaFilled(false); 
	btnNewButton_2_1.setBorderPainted(false);  
	btnNewButton_2_1.setContentAreaFilled(false);  
	btnNewButton_2_1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
	    	 ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2_1)).dispose();
		    Courses courses = new Courses();
		    courses.setVisible(true);
        }
    });

	

	JButton btnNewButton_2_1_2 = new JButton("Tutors");
	btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2_1_2.setBackground(Color.gray);
	btnNewButton_2_1_2.setBounds(30, 282, 179, 38);
	contentPane.add(btnNewButton_2_1_2);
	btnNewButton_2_1_2.setBorderPainted(false);  
	btnNewButton_2_1_2.setContentAreaFilled(false); 
	btnNewButton_2_1_2.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
	    	 ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2_1_2)).dispose();
		    Tutors tutor = new Tutors();
		    tutor.setVisible(true);
        }
    });

	
	
	JButton btnNewButton_2_1_2_1 = new JButton("Students");
	btnNewButton_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2_1_2_1.setBackground(Color.gray);
	btnNewButton_2_1_2_1.setBounds(30, 368, 179, 38);
	contentPane.add(btnNewButton_2_1_2_1);
	btnNewButton_2_1_2_1.setBorderPainted(false);  
	btnNewButton_2_1_2_1.setContentAreaFilled(false); 
	btnNewButton_2_1_2_1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
	    	 ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2_1_2_1)).dispose();  
			   Student student = new Student();
			    student.setVisible(true);
	    }
	});

	
	JButton btnNewButton_2_1_2_2_1 = new JButton("Settings");
	btnNewButton_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2_1_2_2_1.setBackground(Color.gray);
	btnNewButton_2_1_2_2_1.setBounds(30, 456, 179, 38);
	contentPane.add(btnNewButton_2_1_2_2_1);
	btnNewButton_2_1_2_2_1.setBorderPainted(false);  
	btnNewButton_2_1_2_2_1.setContentAreaFilled(false); 
	btnNewButton_2_1_2_2_1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
	    	 ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2_1_2_2_1)).dispose();  
			   Setting dashboard = new Setting();
			    dashboard.setVisible(true);
	    }
	});
	
	
	JButton btnNewButton_2_1_2_2_1_1 = new JButton("Logout");
	btnNewButton_2_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
	btnNewButton_2_1_2_2_1_1.setBackground(Color.gray);
	btnNewButton_2_1_2_2_1_1.setBounds(30, 547, 179, 38);
	contentPane.add(btnNewButton_2_1_2_2_1_1);
	btnNewButton_2_1_2_2_1_1.setBorderPainted(false);  
	btnNewButton_2_1_2_2_1_1.setContentAreaFilled(false); 
	btnNewButton_2_1_2_2_1_1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
	        int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to logout?", "Logout",
	                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	        if (choice == JOptionPane.YES_OPTION) {
	            // User clicked Yes, proceed with logout
	            ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_2_1_2_2_1_1)).dispose();
	            Signin logout = new Signin();
	            logout.setVisible(true);
	        } else {
	            // User clicked No, do nothing
	        }
	    }
	});


	 }
}