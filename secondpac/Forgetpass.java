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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import firstpac.Dashboard;
import javax.swing.JPasswordField;

public class Forgetpass extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_1;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Forgetpass frame = new Forgetpass();
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
    public Forgetpass() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Recover Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 486, 63);
        contentPane.add(panel_1);

        JLabel lblRecoverPassword = new JLabel("Recover Password");
        lblRecoverPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblRecoverPassword.setBackground(Color.GRAY);
        lblRecoverPassword.setBounds(141, 10, 191, 50);
        panel_1.add(lblRecoverPassword);

        JPanel panel = new JPanel();
        panel.setBounds(84, 206, 326, 154);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblWhoIsYour = new JLabel("Who is your favourite Person?");
        lblWhoIsYour.setBounds(44, 21, 251, 40);
        panel.add(lblWhoIsYour);
        lblWhoIsYour.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblWhoIsYour.setBackground(Color.GRAY);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(Color.LIGHT_GRAY);
        btnSubmit.setBounds(117, 112, 79, 32);
        panel.add(btnSubmit);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(98, 71, 125, 27);
        panel.add(textField);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setBounds(84, 167, 326, 40);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblSecurityQuestion = new JLabel("Security Question");
        lblSecurityQuestion.setBounds(94, 0, 145, 40);
        panel_2.add(lblSecurityQuestion);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSecurityQuestion.setBackground(Color.GRAY);

        JLabel lblUserId = new JLabel("Username/phone:");
        lblUserId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUserId.setBackground(Color.GRAY);
        lblUserId.setBounds(84, 104, 147, 40);
        contentPane.add(lblUserId);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(228, 113, 125, 27);
        contentPane.add(textField_1);

        setLocationRelativeTo(null);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the user's input
            	 String answer = textField.getText();
            	String userNameOrPhone = textField_1.getText();


                // Validate the input
                if (answer.isEmpty() || userNameOrPhone.isEmpty()) {
                    // Show an error message if any field is empty
                    // Handle the error as needed
                    return;
                }

                // Check the database for the provided information
                if (checkSecurityAnswer(userNameOrPhone, answer)) {
                    // Retrieve and display the password
                    String password = getPassword(userNameOrPhone);
                    displayPassword(password);
                } else {
                    // Show an error message if the information is incorrect
                    // Handle the error as needed
                    return;
                }
            }
        });
    }

    private boolean checkSecurityAnswer(String userNameOrPhone, String answer) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM signup_info WHERE user_name = ? OR phone = ? AND security_answer = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userNameOrPhone);
                preparedStatement.setString(2, userNameOrPhone);
                preparedStatement.setString(3, answer);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // If a record is found, the information is correct
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Error in database operation
        }
    }

    private String getPassword(String userNameOrPhone) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT password FROM signup_info WHERE user_name = ? OR phone = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userNameOrPhone);
                preparedStatement.setString(2, userNameOrPhone);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("password"); // Retrieve the password from the database
                    } else {
                        return null; // User not found
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null; // Error in database operation
        }
    }

    private void displayPassword(String password) {
        if (password != null) {
            // Show a popup with the password
            JOptionPane.showMessageDialog(this, "Your password is: " + password, "Password Retrieval", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Handle the case where the password is not found (user not found)
            JOptionPane.showMessageDialog(this, "User not found", "Password Retrieval", JOptionPane.ERROR_MESSAGE);
        }
    }
}
