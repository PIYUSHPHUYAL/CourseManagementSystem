package secondpac;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import firstpac.Dashboard;
import firstpac.Tutors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.UIManager;

public class Addtutor extends JFrame {

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
					Editcourse frame = new Editcourse();
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
	public Addtutor() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
    	contentPane.setBackground(new Color(250,250,250));
        setContentPane(contentPane);
        contentPane.setLayout(null);  
        setLocationRelativeTo(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 486, 63);
        contentPane.add(panel_1);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.setBackground(Color.LIGHT_GRAY);
        btnBack_1.setBounds(626, 17, 79, 32);
        panel_1.add(btnBack_1);
        
        JLabel lblNewLabel = new JLabel("   Add Tutor");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBackground(Color.GRAY);
        lblNewLabel.setBounds(167, 4, 154, 50);
        panel_1.add(lblNewLabel);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(397, 17, 79, 32);
        panel_1.add(btnBack);
        btnBack.setBackground(Color.LIGHT_GRAY);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(UIManager.getColor("Button.background"));
        panel.setBounds(0, 62, 486, 401);
        contentPane.add(panel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBounds(100, 28, 285, 306);
        panel.add(panel_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("Tutor's Name");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(21, 58, 102, 29);
        panel_2.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Email");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(21, 119, 102, 29);
        panel_2.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Phone");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(21, 176, 102, 29);
        panel_2.add(lblNewLabel_1_3);
        
        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_1.setBounds(144, 58, 97, 29);
        panel_2.add(editorPane_1);
        
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_2.setBounds(144, 119, 97, 29);
        panel_2.add(editorPane_2);
        
        JEditorPane editorPane_3 = new JEditorPane();
        editorPane_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3.setBounds(144, 176, 97, 29);
        panel_2.add(editorPane_3);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	((JFrame) SwingUtilities.getWindowAncestor(btnBack)).dispose(); 
            }
        });
        
      JButton btnAdd = new JButton("Add");
      btnAdd.setBackground(Color.WHITE);
      btnAdd.setBounds(103, 236, 76, 35);
      panel_2.add(btnAdd);
  
            	btnAdd.addActionListener(new ActionListener() {
            	    public void actionPerformed(ActionEvent e) {
            	        // Get user input
            	        String name = editorPane_1.getText();
            	        String email = editorPane_2.getText();
            	        String phone = editorPane_3.getText();
 
            	        
            	        // Check if any of the fields are blank
            	        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            	            JOptionPane.showMessageDialog(contentPane, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            	            return; // Stop further execution
            	        }
            	        
            	        
            	        // Database operations
            	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            	            // Create a PreparedStatement to insert user information
            	            String insertQuery = "INSERT INTO addtutor (name,email,phone) VALUES ( ?, ?, ?)";
            	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	                preparedStatement.setString(1, name);
            	                preparedStatement.setString(2, email);
            	                preparedStatement.setString(3, phone);
            	               
            	                // Execute the update
            	                preparedStatement.executeUpdate();
            	            }

            	            // Inform the user about successful signup
            	            JOptionPane.showMessageDialog(contentPane, "Tutor added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            	            opentutor();
            	        } catch (SQLException ex) {
            	            ex.printStackTrace();
            	            JOptionPane.showMessageDialog(contentPane, "Error in database operation", "Error", JOptionPane.ERROR_MESSAGE);
            	        }
            	    }
            	});

        

        
	}

    private void opentutor() {
        dispose();
       Tutors dash = new Tutors();
        dash.setVisible(true);
    }


}
