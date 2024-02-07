package secondpac;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import firstpac.Dashboard;
import firstpac.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.UIManager;

public class Editstudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private JEditorPane editorPane_1;
    private JEditorPane editorPane_2;
    private JEditorPane editorPane_3;
    private JEditorPane editorPane_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editstudent frame = new Editstudent();
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
	public Editstudent() {
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
        
        JLabel lblNewLabel = new JLabel("   Edit Student");
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
        
        
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane.setBounds(144, 82, 97, 29);
        panel_2.add(editorPane);
        
        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_1.setBounds(144, 121, 97, 29);
        panel_2.add(editorPane_1);
        
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_2.setBounds(144, 160, 97, 29);
        panel_2.add(editorPane_2);
        
        JEditorPane editorPane_3 = new JEditorPane();
        editorPane_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3.setBounds(144, 199, 97, 29);
        panel_2.add(editorPane_3);
        
        
        JEditorPane editorPane_4 = new JEditorPane();
        editorPane_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_4.setBounds(144, 43, 97, 29);
        panel_2.add(editorPane_4);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the student details from the editor panes
                    int studentId = Integer.parseInt(editorPane.getText());
                    String name = editorPane_1.getText();
                    String email = editorPane_2.getText();
                    String phone = editorPane_3.getText();
                    String course = editorPane_4.getText();

                    // Update the student in the database
                    if (updateCourse(studentId, name, email, phone, course)) {
                        JOptionPane.showMessageDialog(contentPane, "Student updated successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        openstu();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Error updating student", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Kindly make changes then update", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setBounds(106, 261, 76, 35);
        panel_2.add(btnUpdate);

        
        JLabel lblNewLabel_1 = new JLabel("Student's Id");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(21, 82, 113, 29);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Student's Name");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(21, 121, 121, 29);
        panel_2.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Email");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(21, 160, 102, 29);
        panel_2.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Phone");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(21, 199, 102, 29);
        panel_2.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Course");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2_1.setBounds(21, 43, 102, 29);
        panel_2.add(lblNewLabel_1_2_1);

        

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	((JFrame) SwingUtilities.getWindowAncestor(btnBack)).dispose(); 
            	  Student dash = new Student();
 	             dash.setVisible(true);
            }
        });
        
        fetchCourseDetails();
	}
    private void fetchCourseDetails() {
        int courseId = 1; // Replace with the actual course ID
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT name, email, phone, course FROM progress_report WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Populate the editor panes with the existing information
                    editorPane_1.setText(resultSet.getString("name"));
                    editorPane_2.setText(resultSet.getString("email"));
                    editorPane_3.setText(resultSet.getString("phone"));
                    editorPane_4.setText(resultSet.getString("course")); 
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to update a course in the database
    private boolean updateCourse(int courseId, String name, String email, String phone, String course) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE progress_report SET name = ?, email = ?, phone = ?, course = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, phone);
                preparedStatement.setString(4, course);
                preparedStatement.setInt(5, courseId);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
}
    private void openstu() {
        dispose();
        Student dash = new Student();
        dash.setVisible(true);
    }
}