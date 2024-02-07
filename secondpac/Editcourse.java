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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.UIManager;

import firstpac.Courses;
import firstpac.Dashboard;

import javax.swing.JOptionPane;

public class Editcourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JEditorPane editorPane_1;
    private JEditorPane editorPane_2;
    private JEditorPane editorPane_3;
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

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

    public Editcourse() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 250, 250));
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

        JLabel lblNewLabel = new JLabel("   Edit Course");
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

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setBounds(106, 261, 76, 35);
        panel_2.add(btnUpdate);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane.setBounds(144, 36, 97, 29);
        panel_2.add(editorPane);

        JLabel lblNewLabel_1 = new JLabel("Course Id");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(21, 36, 89, 29);
        panel_2.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Course Name");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(21, 89, 102, 29);
        panel_2.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Batch");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(21, 148, 102, 29);
        panel_2.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("No of Seats");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(21, 199, 102, 29);
        panel_2.add(lblNewLabel_1_3);

        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_1.setBounds(144, 89, 97, 29);
        panel_2.add(editorPane_1);

        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_2.setBounds(144, 148, 97, 29);
        panel_2.add(editorPane_2);

        JEditorPane editorPane_3 = new JEditorPane();
        editorPane_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane_3.setBounds(144, 199, 97, 29);
        panel_2.add(editorPane_3);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	((JFrame) SwingUtilities.getWindowAncestor(btnBack)).dispose(); 
            	dispose();
           	 Courses coursesPanel = new Courses();
                coursesPanel.setVisible(true);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the course details from the editor panes
                    int courseId = Integer.parseInt(editorPane.getText());
                    String courseName = editorPane_1.getText();
                    String batch = editorPane_2.getText();
                    String seats = editorPane_3.getText();

                    // Update the course in the database
                    if (updateCourse(courseId, courseName, batch, seats)) {
                        JOptionPane.showMessageDialog(contentPane, "Course updated successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Error updating course", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Kindly make changes then update", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	((JFrame) SwingUtilities.getWindowAncestor(btnBack_1)).dispose(); 
            	 Courses coursesPanel = new Courses();
                 coursesPanel.setVisible(true);
            }
        });

        // Fetch the course details based on the provided course ID
        fetchCourseDetails();
    }

    private void fetchCourseDetails() {
        int courseId = 1; // Replace with the actual course ID
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT coursename, batch, no_of_seats FROM addcourse WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Populate the editor panes with the existing information
                    editorPane_1.setText(resultSet.getString("coursename"));
                    editorPane_2.setText(resultSet.getString("batch"));
                    editorPane_3.setText(resultSet.getString("no_of_seats"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to update a course in the database
 // Method to update a course in the database
    private boolean updateCourse(int courseId, String courseName, String batch, String seats) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE addcourse SET coursename = ?, batch = ?, no_of_seats = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, courseName);
                preparedStatement.setString(2, batch);
                preparedStatement.setString(3, seats);
                preparedStatement.setInt(4, courseId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // Course updated successfully, refresh the displayed details
                    fetchCourseDetails();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}

