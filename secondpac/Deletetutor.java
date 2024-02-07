package secondpac;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import firstpac.Dashboard;
import firstpac.Tutors;

import javax.swing.JEditorPane;

public class Deletetutor extends JFrame {

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
					Deletetutor frame = new Deletetutor();
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
	public Deletetutor() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
    	contentPane.setBackground(new Color(250,250,250));
        setContentPane(contentPane);
        contentPane.setLayout(null);  
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240,240,240));
        panel.setBounds(0, 62, 486, 401);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(117, 48, 240, 301);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(68, 116, 97, 29);
        panel_2.add(editorPane);
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the tutor ID from the user input
                String tutorIdText = editorPane.getText().trim();

                // Check if the tutor ID is empty
                if (tutorIdText.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Please enter a tutor ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method without further processing
                }

                try {
                    int tutorId = Integer.parseInt(tutorIdText);

                    // Confirm deletion
                    int option = JOptionPane.showConfirmDialog(contentPane,
                            "Are you sure you want to delete this tutor?", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        // User confirmed, proceed with deletion
                        if (deleteCourse(tutorId)) {
                            JOptionPane.showMessageDialog(contentPane, "Tutor deleted successfully", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            opentut();
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Error deleting tutor", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Invalid tutor ID. Please enter a valid number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDelete.setBounds(78, 155, 76, 21);
        panel_2.add(btnDelete);
        btnDelete.setBackground(Color.WHITE);
        

        
        JLabel lblNewLabel_1 = new JLabel("Enter Tutor's Id");
        lblNewLabel_1.setBounds(58, 82, 130, 29);
        panel_2.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 486, 63);
        contentPane.add(panel_1);

        
        JLabel lblNewLabel = new JLabel("Delete Tutor");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBackground(Color.GRAY);
        lblNewLabel.setBounds(167, 4, 154, 50);
        panel_1.add(lblNewLabel);
        

        

        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(397, 17, 79, 32);
        panel_1.add(btnBack);
        btnBack.setBackground(Color.LIGHT_GRAY);
        
      
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	((JFrame) SwingUtilities.getWindowAncestor(btnBack)).dispose(); 
            }
        });
	}
	
    // Method to delete a course based on the course ID
    private boolean deleteCourse(int courseId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM addtutor WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseId);
                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    private void opentut() {
        dispose();
        Tutors dash = new Tutors();
        dash.setVisible(true);
    }
}
