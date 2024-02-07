package secondpac;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import firstpac.Courses;
import firstpac.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class Addcourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Addcourse frame = new Addcourse();
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
    public Addcourse() {
    	

    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 780, 650);
        contentPane = new JPanel();
    	contentPane.setBackground(new Color(250,250,250));
        setContentPane(contentPane);
        contentPane.setLayout(null);  
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(30, 74, 705, 542);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Course Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(10, 0, 105, 29);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Batch");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(223, 0, 49, 29);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("No of Seats");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(376, 0, 106, 29);
        panel.add(lblNewLabel_1_2);
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane.setBounds(10, 35, 116, 36);
        panel.add(editorPane);
        
        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_1.setBounds(191, 35, 116, 36);
        panel.add(editorPane_1);
        
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_2.setBounds(366, 35, 116, 36);
        panel.add(editorPane_2);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(240,240,240));
        panel_2.setBounds(0, 122, 233, 420);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 233, 44);
        panel_3.setBackground(Color.GRAY);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_1_3 = new JLabel("Level 4");
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setBounds(87, 10, 77, 29);
        panel_3.add(lblNewLabel_1_3);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 45, 233, 187);
        panel_2.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_1_3_3 = new JLabel("Modules");
        lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3.setBounds(83, 10, 77, 29);
        panel_4.add(lblNewLabel_1_3_3);
        
        JEditorPane editorPane_3 = new JEditorPane();
        editorPane_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3.setBounds(59, 42, 116, 36);
        panel_4.add(editorPane_3);
        
        JEditorPane editorPane_4 = new JEditorPane();
        editorPane_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_4.setBounds(59, 91, 116, 36);
        panel_4.add(editorPane_4);
        
        JEditorPane editorPane_5 = new JEditorPane();
        editorPane_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_5.setBounds(59, 141, 116, 36);
        panel_4.add(editorPane_5);
        
        JLabel lblNewLabel_1_3_3_3 = new JLabel("Tutors");
        lblNewLabel_1_3_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3_3.setBounds(92, 242, 62, 29);
        panel_2.add(lblNewLabel_1_3_3_3);
        
        JEditorPane editorPane_3_4 = new JEditorPane();
        editorPane_3_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_4.setBounds(59, 270, 116, 36);
        panel_2.add(editorPane_3_4);
        
        JEditorPane editorPane_3_5 = new JEditorPane();
        editorPane_3_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_5.setBounds(59, 316, 116, 36);
        panel_2.add(editorPane_3_5);
        
        JEditorPane editorPane_3_6 = new JEditorPane();
        editorPane_3_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_6.setBounds(59, 363, 116, 36);
        panel_2.add(editorPane_3_6);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(240,240,240));
        panel_2_1.setBounds(242, 122, 226, 420);
        panel.add(panel_2_1);
        panel_2_1.setLayout(null);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBounds(0, 0, 226, 44);
        panel_3_1.setBackground(Color.GRAY);
        panel_2_1.add(panel_3_1);
        panel_3_1.setLayout(null);
        
        JLabel lblNewLabel_1_3_1 = new JLabel("Level 5");
        lblNewLabel_1_3_1.setForeground(Color.WHITE);
        lblNewLabel_1_3_1.setBounds(88, 10, 78, 29);
        panel_3_1.add(lblNewLabel_1_3_1);
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBounds(0, 45, 226, 187);
        panel_2_1.add(panel_4_1);
        panel_4_1.setLayout(null);
        
        JLabel lblNewLabel_1_3_3_1 = new JLabel("Modules");
        lblNewLabel_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3_1.setBounds(77, 10, 77, 29);
        panel_4_1.add(lblNewLabel_1_3_3_1);
        
        JEditorPane editorPane_3_1 = new JEditorPane();
        editorPane_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_1.setBounds(52, 42, 116, 36);
        panel_4_1.add(editorPane_3_1);
        
        JEditorPane editorPane_3_2 = new JEditorPane();
        editorPane_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_2.setBounds(52, 93, 116, 36);
        panel_4_1.add(editorPane_3_2);
        
        JEditorPane editorPane_3_3 = new JEditorPane();
        editorPane_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_3.setBounds(52, 141, 116, 36);
        panel_4_1.add(editorPane_3_3);
        
        JLabel lblNewLabel_1_3_3_3_1 = new JLabel("Tutors");
        lblNewLabel_1_3_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3_3_1.setBounds(85, 242, 62, 29);
        panel_2_1.add(lblNewLabel_1_3_3_3_1);
        
        JEditorPane editorPane_3_7 = new JEditorPane();
        editorPane_3_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_7.setBounds(54, 270, 116, 36);
        panel_2_1.add(editorPane_3_7);
        
        JEditorPane editorPane_3_8 = new JEditorPane();
        editorPane_3_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_8.setBounds(54, 316, 116, 36);
        panel_2_1.add(editorPane_3_8);
        
        JEditorPane editorPane_3_9 = new JEditorPane();
        editorPane_3_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_9.setBounds(54, 362, 116, 36);
        panel_2_1.add(editorPane_3_9);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setBackground(new Color(240,240,240));
        panel_2_2.setBounds(479, 122, 226, 420);
        panel.add(panel_2_2);
        panel_2_2.setLayout(null);
        
        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBounds(0, 0, 226, 44);
        panel_3_2.setBackground(Color.GRAY);
        panel_2_2.add(panel_3_2);
        panel_3_2.setLayout(null);
        
        JLabel lblNewLabel_1_3_2 = new JLabel("Level 6");
        lblNewLabel_1_3_2.setForeground(Color.WHITE);
        lblNewLabel_1_3_2.setBounds(88, 10, 78, 29);
        panel_3_2.add(lblNewLabel_1_3_2);
        lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBounds(0, 45, 226, 187);
        panel_2_2.add(panel_4_2);
        panel_4_2.setLayout(null);
        
        JLabel lblNewLabel_1_3_3_2 = new JLabel("Modules");
        lblNewLabel_1_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3_2.setBounds(80, 10, 77, 29);
        panel_4_2.add(lblNewLabel_1_3_3_2);
        
        JEditorPane editorPane_3_1_1 = new JEditorPane();
        editorPane_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_1_1.setBounds(53, 39, 116, 36);
        panel_4_2.add(editorPane_3_1_1);
        
        JEditorPane editorPane_3_1_2 = new JEditorPane();
        editorPane_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_1_2.setBounds(53, 90, 116, 36);
        panel_4_2.add(editorPane_3_1_2);
        
        JEditorPane editorPane_3_1_3 = new JEditorPane();
        editorPane_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_1_3.setBounds(53, 141, 116, 36);
        panel_4_2.add(editorPane_3_1_3);
        
        JLabel lblNewLabel_1_3_3_3_2 = new JLabel("Tutors");
        lblNewLabel_1_3_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3_3_3_2.setBounds(86, 242, 62, 29);
        panel_2_2.add(lblNewLabel_1_3_3_3_2);
        
        JEditorPane editorPane_3_10 = new JEditorPane();
        editorPane_3_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_10.setBounds(54, 269, 116, 36);
        panel_2_2.add(editorPane_3_10);
        
        JEditorPane editorPane_3_11 = new JEditorPane();
        editorPane_3_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_11.setBounds(54, 315, 116, 36);
        panel_2_2.add(editorPane_3_11);
        
        JEditorPane editorPane_3_12 = new JEditorPane();
        editorPane_3_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3_12.setBounds(54, 361, 116, 36);
        panel_2_2.add(editorPane_3_12);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("No of Years");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2_1.setBounds(548, 0, 106, 29);
        panel.add(lblNewLabel_1_2_1);
        
        JEditorPane editorPane_2_1 = new JEditorPane();
        editorPane_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_2_1.setBounds(538, 35, 116, 36);
        panel.add(editorPane_2_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(30, 10, 705, 63);
        contentPane.add(panel_1);
                panel_1.setLayout(null);
        
        
                JButton btnBack = new JButton("Back");
                btnBack.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		dispose();
                        Courses coursesPanel = new Courses();
                        coursesPanel.setVisible(true);
                	}
                });
                btnBack.setBounds(626, 17, 79, 32);
                panel_1.add(btnBack);
                btnBack.setBackground(Color.LIGHT_GRAY);
                
                JLabel lblNewLabel = new JLabel("Course Details");
                lblNewLabel.setBounds(284, 10, 154, 50);
                panel_1.add(lblNewLabel);
                lblNewLabel.setBackground(Color.GRAY);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                JButton btnAdd = new JButton("Add");
                btnAdd.setBackground(Color.LIGHT_GRAY);
                btnAdd.setBounds(23, 23, 79, 32);
                panel_1.add(btnAdd);
                    	btnAdd.addActionListener(new ActionListener() {
                    	    public void actionPerformed(ActionEvent e) {
                    	        // Get user input
                    	        String course = editorPane.getText();
                    	        String batch = editorPane_1.getText();
                    	        String no_of_seats = editorPane_2.getText();
                    	       
                    	        String l4m1 = editorPane_3.getText();
                    	        String l4m2 = editorPane_4.getText();
                    	        String l4m3 = editorPane_5.getText();
                    	        String l4t1 = editorPane_3_4.getText();
                    	        String l4t2 = editorPane_3_5.getText();
                    	        String l4t3 = editorPane_3_6.getText();

                    	        String l5m1 = editorPane_3_1.getText();
                    	        String l5m2 = editorPane_3_2.getText();
                    	        String l5m3 = editorPane_3_3.getText();
                    	        String l5t1 = editorPane_3_7.getText();
                    	        String l5t2 = editorPane_3_8.getText();
                    	        String l5t3 = editorPane_3_9.getText();

                    	        String l6m1 = editorPane_3_1_1.getText();
                    	        String l6m2 = editorPane_3_1_2.getText();
                    	        String l6m3 = editorPane_3_1_3.getText();
                    	        String l6t1 = editorPane_3_10.getText();
                    	        String l6t2 = editorPane_3_11.getText();
                    	        String l6t3 = editorPane_3_12.getText();
                    	        String no_of_years = editorPane_2_1.getText();
                    	        
                    	        // Check if any of the fields are blank
                    	        if (course.isEmpty() || batch.isEmpty() || no_of_seats.isEmpty() || no_of_years.isEmpty() ||
                    	            l4m1.isEmpty() || l4m2.isEmpty() || l4m3.isEmpty() || l4t1.isEmpty() || l4t2.isEmpty() || l4t3.isEmpty() ||
                    	            l5m1.isEmpty() || l5m2.isEmpty() || l5m3.isEmpty() || l5t1.isEmpty() || l5t2.isEmpty() || l5t3.isEmpty() ||
                    	            l6m1.isEmpty() || l6m2.isEmpty() || l6m3.isEmpty() || l6t1.isEmpty() || l6t2.isEmpty() || l6t3.isEmpty()) {
                    	            JOptionPane.showMessageDialog(contentPane, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    	            return; // Stop further execution
                    	        }
                    	        
                    	        
                    	        // Database operations
                    	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    	            // Create a PreparedStatement to insert user information
                    	            String insertQuery = "INSERT INTO addcourse (coursename,batch,no_of_seats,l4m1,l4m2,l4m3,l4t1,l4t2,l4t3,l5m1,l5m2,l5m3,l5t1,l5t2,l5t3,l6m1,l6m2,l6m3,l6t1,l6t2,l6t3,years) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    	                preparedStatement.setString(1, course);
                    	                preparedStatement.setString(2, batch);
                    	                preparedStatement.setString(3, no_of_seats);
                    	                preparedStatement.setString(4, l4m1);
                    	                preparedStatement.setString(5, l4m2);
                    	                preparedStatement.setString(6, l4m3);
                    	                preparedStatement.setString(7, l4t1);
                    	                preparedStatement.setString(8, l4t2);
                    	                preparedStatement.setString(9, l4t3);
                    	                preparedStatement.setString(10, l5m1);
                    	                preparedStatement.setString(11, l5m2);
                    	                preparedStatement.setString(12, l5m3);
                    	                preparedStatement.setString(13, l5t1);
                    	                preparedStatement.setString(14, l5t2);
                    	                preparedStatement.setString(15, l5t3);
                    	                preparedStatement.setString(16, l6m1);
                    	                preparedStatement.setString(17, l6m2);
                    	                preparedStatement.setString(18, l6m3);
                    	                preparedStatement.setString(19, l6t1);
                    	                preparedStatement.setString(20, l6t2);
                    	                preparedStatement.setString(21, l6t3);
                    	                preparedStatement.setString(22, no_of_years );
                    	                

                    	                // Execute the update
                    	                preparedStatement.executeUpdate();
                    	            }

                    	            // Inform the user about successful signup
                    	            JOptionPane.showMessageDialog(contentPane, "Course added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    	            opencourses();
                    	        } catch (SQLException ex) {
                    	            ex.printStackTrace();
                    	            JOptionPane.showMessageDialog(contentPane, "Error in database operation", "Error", JOptionPane.ERROR_MESSAGE);
                    	        }
                    	    }
                    	});

            
    }
     
    
 
    private void opencourses() {
        dispose();
        Courses dash = new Courses();
        dash.setVisible(true);
    }
}
