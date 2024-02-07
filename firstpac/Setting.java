package firstpac;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import secondpac.Editcourse;
import secondpac.Makeprogress;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class Setting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	 private void callFunction() {
	        Function Instance = new Function();
	        Instance.DashboardAndNotification(contentPane);
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setting frame = new Setting();
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
	
	   private boolean validatePassword(String identifier, String currentPassword) {
	        boolean isValid = false;

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cms", "root", "")) {
	            // Check if identifier is numeric (ID) or alphanumeric (username)
	            String sql = "";
	            if (identifier.matches("\\d+")) {
	                // If numeric, use ID
	                sql = "SELECT * FROM signup_info WHERE id = ? AND password = ?";
	            } else {
	                // If alphanumeric, use username
	                sql = "SELECT * FROM signup_info WHERE user_name = ? AND password = ?";
	            }

	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, identifier);
	                statement.setString(2, currentPassword);

	                // Execute the query and check if any rows are returned
	                // If yes, validation succeeds; otherwise, it fails
	                isValid = statement.executeQuery().next();
	            }
	        } catch (SQLException e) {
	            // Handle database exceptions
	            e.printStackTrace();
	        }

	        return isValid;
	    }

	    private boolean updatePassword(String identifier, String newPassword) {
	        boolean isUpdated = false;

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cms", "root", "")) {
	            // Check if identifier is numeric (ID) or alphanumeric (username)
	            String sql = "";
	            if (identifier.matches("\\d+")) {
	                // If numeric, use ID
	                sql = "UPDATE signup_info SET password = ? WHERE id = ?";
	            } else {
	                // If alphanumeric, use username
	                sql = "UPDATE signup_info SET password = ? WHERE user_name = ?";
	            }

	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, newPassword);
	                statement.setString(2, identifier);

	                // Execute the update query and check if it was successful
	                int rowsAffected = statement.executeUpdate();
	                isUpdated = rowsAffected > 0;
	            }
	        } catch (SQLException e) {
	            // Handle database exceptions
	            e.printStackTrace();
	        }

	        return isUpdated;
	    }
	
	public Setting() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(250,250,250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		callFunction();
		
		JLabel lblNewLabel_2 = new JLabel("Settings");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(239, 40, 306, 82);
		contentPane.add(lblNewLabel_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setOpaque(false);
		editorPane.setBounds(287, 208, 179, 29);
		contentPane.add(editorPane);
		editorPane.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
	    Border customBorder11 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    editorPane.setBorder(customBorder11);
		
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setOpaque(false);
		editorPane_1.setBounds(287, 318, 179, 29);
		contentPane.add(editorPane_1);
		editorPane_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
	    Border customBorder111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    editorPane_1.setBorder(customBorder111);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Current Password");
		lblNewLabel_1_2_1.setBounds(284, 268, 182, 29);
		contentPane.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		
		JEditorPane editorPane_1_1 = new JEditorPane();
		editorPane_1_1.setOpaque(false);
		editorPane_1_1.setBounds(287, 419, 179, 29);
		contentPane.add(editorPane_1_1);
		editorPane_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
	    Border customBorder1111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    editorPane_1_1.setBorder(customBorder1111);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Enter New Password");
		lblNewLabel_1_2_1_1.setBounds(287, 370, 173, 29);
		contentPane.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		
		JButton btnChange = new JButton("Change");
		btnChange.setOpaque(false);
		btnChange.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnChange.setBounds(320, 485, 113, 60);
		contentPane.add(btnChange);
	    Border customBorder11111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    btnChange .setBorder(customBorder11111);
		btnChange.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		           String identifier = editorPane.getText();
		           String currentPassword = editorPane_1.getText();
		           String newPassword = editorPane_1_1.getText();

		           if (validatePassword(identifier, currentPassword)) {
		               if (updatePassword(identifier, newPassword)) {
		                   JOptionPane.showMessageDialog(null, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			                dispose();
			                Signin dash = new Signin();
			                dash.setVisible(true);
		               } else {
		                   JOptionPane.showMessageDialog(null, "Failed to change password.", "Error", JOptionPane.ERROR_MESSAGE);
		               }
		           } else {
		               JOptionPane.showMessageDialog(null, "Invalid current password.", "Error", JOptionPane.ERROR_MESSAGE);
		           }
		       }
		   });
		btnChange.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Your Id/username");
		lblNewLabel_1_2.setBounds(285, 169, 195, 29);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Setting.class.getResource("/images/abstract-blue-geometric-shapes-background (1).jpg")));
		lblNewLabel.setBounds(0, 0, 786, 628);
		contentPane.add(lblNewLabel);
	    setLocationRelativeTo(null);
		
	}
}
