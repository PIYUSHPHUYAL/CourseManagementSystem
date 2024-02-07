package firstpac;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.SystemColor;


/**
Hiearchial Inheritance is used here for CMS
 */
public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;
	static String usertype;
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	
	
	 public void setUserInformation(String username, String usertype) {
	        this.username = username;
	        Dashboard.usertype = usertype;
	    String welcomeMessage = "Welcome, " + username + " (" + usertype + ")";
		    
		    // Display the welcome message in a JOptionPane
		    JOptionPane.showMessageDialog(contentPane, welcomeMessage, "Welcome", JOptionPane.INFORMATION_MESSAGE);
		    
			JPanel panel = new JPanel();
			panel.setBounds(242, 353, 541, 276);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(83, 33, 384, 212);
			panel_2.setBackground(new Color(250, 250, 250));
			panel.add(panel_2);
			panel_2.setLayout(null);
			
	
			JLabel lblUsername = new JLabel("");
			lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			lblUsername.setBounds(176, 19, 223, 44);
			panel_2.add(lblUsername);

			JLabel lblPhone = new JLabel("");
			lblPhone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			lblPhone.setBounds(145, 78, 200, 44);
			panel_2.add(lblPhone);

			JLabel lblEmail = new JLabel("");
			lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
			lblEmail.setBounds(145, 141, 213, 44);
			panel_2.add(lblEmail);
		    
		    
		    
		     // Fetch user information from the database
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

	            String query = "SELECT user_name, phone, email FROM signup_info WHERE user_name = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, username);

	                ResultSet resultSet = preparedStatement.executeQuery();
	                if (resultSet.next()) {
	                    String fetchedUsername = resultSet.getString("user_name");
	                    String fetchedPhone = resultSet.getString("phone");
	                    String fetchedEmail = resultSet.getString("email");

	                    // Set the fetched information in the JTextFields
	                    lblUsername.setText(fetchedUsername);
	                    lblPhone.setText(fetchedPhone);
	                    lblEmail.setText(fetchedEmail);

	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(contentPane, "Error fetching user information", "Error", JOptionPane.ERROR_MESSAGE);
	        }
		    
		    
	    }


	
	  private void callFunction() {
	        Function me = new Function();
	        me.DashboardAndNotification(contentPane);

	
	    }
	
	  
	    public Dashboard() {
	    
	    	
			setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
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
			callFunction();
			
			JLabel lblNewLabel_2 = new JLabel("Dashboard");
			lblNewLabel_2.setBackground(new Color(250,250,250));
			lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
			lblNewLabel_2.setBounds(239, 40, 395, 82);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_4 = new JLabel("Available Courses");
			lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(254, 190, 171, 32);
			contentPane.add(lblNewLabel_4);
			
			
			
			
//			getting count of courses from database of courses.java and showing here
			   Courses courses = new Courses();
		        int courseCount = courses.getCourseCount();
		        JLabel lblNewLabel_5 = new JLabel(Integer.toString(courseCount));
		        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		        lblNewLabel_5.setBounds(325, 232, 34, 60);
		        contentPane.add(lblNewLabel_5);

			
			
			
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setOpaque(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();  
		      	    Courses tt = new Courses();
		      	    tt.setVisible(true);
				}
			});
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setBounds(239, 161, 186, 190);
			contentPane.add(btnNewButton);
		    Border customBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    btnNewButton.setBorder(customBorder);

			
			JLabel lblNewLabel_4_1 = new JLabel("Total Tutors");
			lblNewLabel_4_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
			lblNewLabel_4_1.setBounds(457, 190, 117, 32);
			contentPane.add(lblNewLabel_4_1);
			
			
		

			
			
//			getting count of tutors from database of courses.java and showing here
			   Tutors tut = new Tutors();
		        int tutorCount = tut.getTutorCount();
		        JLabel lblNewLabel_5_1 = new JLabel(Integer.toString(tutorCount));
				lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
				lblNewLabel_5_1.setBounds(502, 232, 59, 60);
				contentPane.add(lblNewLabel_5_1);
			
			
			
			
			
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();  
		      	   Tutors  tt = new Tutors();
		      	    tt.setVisible(true);
				}
			});
			btnNewButton_1.setBackground(Color.ORANGE);
			btnNewButton_1.setOpaque(false);
			btnNewButton_1.setBounds(429, 161, 176, 190);
			contentPane.add(btnNewButton_1);
		    Border customBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    btnNewButton_1.setBorder(customBorder1);
			
			
//			getting count of students from database of courses.java and showing here
			   Student stu = new Student();
		        int stuCount = stu.getStudentCount();
		        JLabel lblNewLabel_5_1_1 = new JLabel(Integer.toString(stuCount));
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel_5_1_1.setBounds(683, 232, 59, 60);
			contentPane.add(lblNewLabel_5_1_1);
			
			JLabel lblNewLabel_4_1_1 = new JLabel("Total Students");
			lblNewLabel_4_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
			lblNewLabel_4_1_1.setBounds(642, 190, 134, 32);
			contentPane.add(lblNewLabel_4_1_1);
			
			JButton btnNewButton_1_1 = new JButton("");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();  
		      	    Student tt = new Student();
		      	    tt.setVisible(true);
				}
			});
			btnNewButton_1_1.setBackground(Color.BLACK);
			btnNewButton_1_1.setOpaque(false);
			btnNewButton_1_1.setBounds(607, 161, 176, 190);
			contentPane.add(btnNewButton_1_1);
		    Border customBorder11 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    btnNewButton_1_1.setBorder(customBorder11);
			
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setBounds(242, 353, 541, 276);
			contentPane.add(panel);
			panel.setLayout(null);
			

			JPanel panel_2 = new JPanel();
			panel_2.setOpaque(false);
			panel_2.setBounds(0, 31, 458, 212);
			panel_2.setBackground(new Color(250, 250, 250));
			panel.add(panel_2);
			panel_2.setLayout(null);

			JLabel lblNewLabel_4_2 = new JLabel("Username:");
			lblNewLabel_4_2.setBounds(38, 27, 143, 32);
			panel_2.add(lblNewLabel_4_2);
			lblNewLabel_4_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));

			JLabel lblNewLabel_4_3 = new JLabel("Phone:");
			lblNewLabel_4_3.setBounds(38, 83, 102, 32);
			panel_2.add(lblNewLabel_4_3);
			lblNewLabel_4_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));

			JLabel lblNewLabel_4_4 = new JLabel("Email:");
			lblNewLabel_4_4.setBounds(38, 148, 102, 32);
			panel_2.add(lblNewLabel_4_4);
			lblNewLabel_4_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/abstract-blue-geometric-shapes-background (1).jpg")));
			lblNewLabel.setBounds(0, 0, 783, 629);
			contentPane.add(lblNewLabel);

		
			
			JLabel lblUsername = new JLabel("");
			lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			lblUsername.setBounds(176, 19, 223, 44);
			panel_2.add(lblUsername);

			JLabel lblPhone = new JLabel("");
			lblPhone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			lblPhone.setBounds(145, 78, 200, 44);
			panel_2.add(lblPhone);

			JLabel lblEmail = new JLabel("");
			lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
			lblEmail.setBounds(145, 141, 213, 44);
			panel_2.add(lblEmail);
}	
}