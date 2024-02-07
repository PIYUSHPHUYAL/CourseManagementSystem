package secondpac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import firstpac.Dashboard;
import firstpac.Student;
import firstpac.Tutors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Component;

public class Makeprogress extends JFrame {

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
					Makeprogress frame = new Makeprogress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        


	public Makeprogress() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
    	contentPane.setBackground(new Color(250,250,250));
        setContentPane(contentPane);
        contentPane.setLayout(null);  
        setLocationRelativeTo(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 486, 63);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        

        
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(397, 21, 79, 32);
        panel_1.add(btnBack);
        btnBack.setBackground(Color.LIGHT_GRAY);
        
        JLabel lblProgressReport = new JLabel("Progress Report");
        lblProgressReport.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblProgressReport.setBackground(Color.GRAY);
        lblProgressReport.setBounds(165, 8, 183, 50);
        panel_1.add(lblProgressReport);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(240,240,240));
        panel_1_1.setBounds(0, 64, 486, 399);
        contentPane.add(panel_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("Student Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(10, 37, 130, 29);
        panel_1_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Course:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(10, 86, 65, 29);
        panel_1_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Enter Student's Id");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(288, 59, 145, 29);
        panel_1_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Module Grades:");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_3.setBounds(32, 149, 169, 29);
        panel_1_1.add(lblNewLabel_1_3);
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setOpaque(false);
        editorPane.setBounds(126, 37, 107, 29);
        panel_1_1.add(editorPane);
        
        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setOpaque(false);
        editorPane_1.setBounds(73, 86, 96, 29);
        panel_1_1.add(editorPane_1);
        
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setBounds(322, 86, 65, 29);
        panel_1_1.add(editorPane_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 188, 159, 211);
        panel_1_1.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Level4");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1.setBounds(38, 10, 65, 29);
        panel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_4 = new JLabel("Module1:");
        lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_4.setBounds(10, 70, 81, 29);
        panel.add(lblNewLabel_1_1_4);
        
        JLabel lblNewLabel_1_1_5 = new JLabel("Module2:");
        lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_5.setBounds(10, 118, 81, 29);
        panel.add(lblNewLabel_1_1_5);
        
        JLabel lblNewLabel_1_1_6 = new JLabel("Module3:");
        lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_6.setBounds(10, 160, 81, 29);
        panel.add(lblNewLabel_1_1_6);
        
        JEditorPane editorPane_1_1 = new JEditorPane();
        editorPane_1_1.setBounds(87, 70, 39, 29);
        panel.add(editorPane_1_1);
        
        JEditorPane editorPane_1_2 = new JEditorPane();
        editorPane_1_2.setBounds(86, 118, 39, 29);
        panel.add(editorPane_1_2);
        
        JEditorPane editorPane_1_2_1 = new JEditorPane();
        editorPane_1_2_1.setBounds(87, 160, 39, 29);
        panel.add(editorPane_1_2_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(158, 188, 159, 211);
        panel_1_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Level5");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_2.setBounds(46, 10, 65, 29);
        panel_2.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_4_1 = new JLabel("Module1:");
        lblNewLabel_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_4_1.setBounds(10, 71, 81, 29);
        panel_2.add(lblNewLabel_1_1_4_1);
        
        JLabel lblNewLabel_1_1_5_1 = new JLabel("Module2:");
        lblNewLabel_1_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_5_1.setBounds(10, 116, 81, 29);
        panel_2.add(lblNewLabel_1_1_5_1);
        
        JLabel lblNewLabel_1_1_6_1 = new JLabel("Module3:");
        lblNewLabel_1_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_6_1.setBounds(10, 155, 81, 29);
        panel_2.add(lblNewLabel_1_1_6_1);
        
        JEditorPane editorPane_1_2_1_1 = new JEditorPane();
        editorPane_1_2_1_1.setBounds(87, 71, 39, 29);
        panel_2.add(editorPane_1_2_1_1);
        
        JEditorPane editorPane_1_2_1_2 = new JEditorPane();
        editorPane_1_2_1_2.setBounds(87, 116, 39, 29);
        panel_2.add(editorPane_1_2_1_2);
        
        JEditorPane editorPane_1_2_1_3 = new JEditorPane();
        editorPane_1_2_1_3.setBounds(87, 155, 39, 29);
        panel_2.add(editorPane_1_2_1_3);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(317, 188, 169, 211);
        panel_1_1.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("Level6");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_3.setBounds(48, 10, 65, 29);
        panel_3.add(lblNewLabel_1_1_3);
        
        JLabel lblNewLabel_1_1_4_2 = new JLabel("Module1:");
        lblNewLabel_1_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_4_2.setBounds(10, 71, 81, 29);
        panel_3.add(lblNewLabel_1_1_4_2);
        
        JLabel lblNewLabel_1_1_5_2 = new JLabel("Module2:");
        lblNewLabel_1_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_5_2.setBounds(10, 110, 81, 29);
        panel_3.add(lblNewLabel_1_1_5_2);
        
        JLabel lblNewLabel_1_1_6_2 = new JLabel("Module3:");
        lblNewLabel_1_1_6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_6_2.setBounds(10, 149, 81, 29);
        panel_3.add(lblNewLabel_1_1_6_2);
        
        JEditorPane editorPane_1_2_1_4 = new JEditorPane();
        editorPane_1_2_1_4.setBounds(88, 71, 39, 29);
        panel_3.add(editorPane_1_2_1_4);
        
        JEditorPane editorPane_1_2_1_5 = new JEditorPane();
        editorPane_1_2_1_5.setBounds(88, 110, 39, 29);
        panel_3.add(editorPane_1_2_1_5);
        
        JEditorPane editorPane_1_2_1_6 = new JEditorPane();
        editorPane_1_2_1_6.setBounds(88, 149, 39, 29);
        panel_3.add(editorPane_1_2_1_6);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		   
        	     // Retrieve data from the input components
        	        String studentName = editorPane.getText();
        	        String course = editorPane_1.getText();
        	        String studentId = editorPane_2.getText();
        	        String l4m1 = editorPane_1_1.getText();
        	        String l4m2 = editorPane_1_2.getText();
        	        String l4m3 = editorPane_1_2_1.getText();
        	        String l5m1 = editorPane_1_2_1_1.getText();
        	        String l5m2 = editorPane_1_2_1_2.getText();
        	        String l5m3 = editorPane_1_2_1_3.getText();
        	        String l6m1 = editorPane_1_2_1_4.getText();
        	        String l6m2 = editorPane_1_2_1_5.getText();
        	        String l6m3 = editorPane_1_2_1_6.getText();

        	        // Database operations to insert data into the progress_report table
        	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        	        	
        	        	
        	        	
        	        	
        	        	
        	        	
        	            // Query to retrieve student name
        	            String nameQuery = "SELECT name FROM progress_report WHERE id = ?";
        	            try (PreparedStatement nameStatement = connection.prepareStatement(nameQuery)) {
        	                nameStatement.setString(1, studentId);
        	                ResultSet nameResultSet = nameStatement.executeQuery();

        	                // Fetch the student name if it exists
        	                String studentN = nameResultSet.next() ? nameResultSet.getString("name") : "No name ";

        	                // Set the fetched name to editorPane_1
        	                editorPane.setText(studentN);
        	            }
        	        	
        	        
        	         // Query to retrieve student courses
        	            String coursesQuery = "SELECT course FROM progress_report WHERE id = ?";
        	            try (PreparedStatement coursesStatement = connection.prepareStatement(coursesQuery)) {
        	                coursesStatement.setString(1, studentId);
        	                ResultSet coursesResultSet = coursesStatement.executeQuery();

        	                // Fetch the courses if they exist
        	                StringBuilder coursesStringBuilder = new StringBuilder();
        	                while (coursesResultSet.next()) {
        	                    coursesStringBuilder.append(coursesResultSet.getString("course")).append(", ");
        	                }

        	                // Remove the trailing comma and space if any
        	                String courses = coursesStringBuilder.length() > 0 ? coursesStringBuilder.substring(0, coursesStringBuilder.length() - 2) : "No courses";

        	                // Set the fetched courses to editorPane_2
        	                editorPane_1.setText(courses);
        	            }

        	        	
        	        	
        	        	String query = "UPDATE progress_report SET  l4m1=?, l4m2=?, l4m3=?, l5m1=?, l5m2=?, l5m3=?, l6m1=?, l6m2=?, l6m3=? WHERE id=?";
        	        	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	        	    preparedStatement.setString(1, l4m1);
        	        	    preparedStatement.setString(2, l4m2);
        	        	    preparedStatement.setString(3, l4m3);
        	        	    preparedStatement.setString(4, l5m1);
        	        	    preparedStatement.setString(5, l5m2);
        	        	    preparedStatement.setString(6, l5m3);
        	        	    preparedStatement.setString(7, l6m1);
        	        	    preparedStatement.setString(8, l6m2);
        	        	    preparedStatement.setString(9, l6m3);
        	        	    preparedStatement.setString(10, studentId); // Assuming student_id is the column you use in the WHERE clause

        	        	    int rowsAffected = preparedStatement.executeUpdate();

        	        	    if (rowsAffected > 0) {
        	        	        JOptionPane.showMessageDialog(contentPane, "Data added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        	        	    } else {
        	        	        JOptionPane.showMessageDialog(contentPane, "Failed to add data", "Error", JOptionPane.ERROR_MESSAGE);
        	        	    }
        	        	}
        	        } catch (SQLException ex) {
        	            ex.printStackTrace();
        	            JOptionPane.showMessageDialog(contentPane, "Error inserting data into the database", "Error", JOptionPane.ERROR_MESSAGE);
        	        }

        	        
        		
        		
        		
        		
        		
        		
        	}
        });
        btnNewButton.setBounds(322, 149, 65, 29);
        panel_1_1.add(btnNewButton);
        
      
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             dispose();
             Tutors coursesPanel = new Tutors();
              coursesPanel.setVisible(true);
            }
        });
        
        
     
        
	}
}
