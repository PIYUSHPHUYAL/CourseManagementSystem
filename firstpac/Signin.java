package firstpac;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import secondpac.Forgetpass;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import java.awt.Button;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Signin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private String userInput;
    private static String selectedUser;
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
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

	public Signin() {
		setTitle("Login Panel");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Signin.class.getResource("/images/1111.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250,250,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		JLabel user_toggle = new JLabel("Select User:");
		user_toggle.setBounds(152, 410, 106, 25);
		contentPane.add(user_toggle);
		user_toggle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		
		JComboBox<String> combobox_of_user = new JComboBox<>();
		combobox_of_user.setToolTipText("");
		combobox_of_user.setBounds(136, 445, 136, 25);
		// Adding items to the combo box
		combobox_of_user.addItem("Select the User");
		combobox_of_user.addItem("Student");
		combobox_of_user.addItem("Administrator");
		combobox_of_user.addItem("Teacher");
		combobox_of_user.setSelectedItem("Select the User");
		contentPane.add(combobox_of_user);
		
		
		JLabel email_add = new JLabel("User Name/Email:");
		email_add.setBounds(38, 330, 146, 21);
		contentPane.add(email_add);
		email_add.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField_1.setBounds(38, 363, 146, 25);
		contentPane.add(textField_1);
	    Border customBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    textField_1.setBorder(customBorder);
	    textField_1.setBackground(new Color(250, 250, 250));
		textField_1.setColumns(10);
		
		
		JLabel pass = new JLabel("Password:");
		pass.setBounds(236, 327, 91, 25);
		contentPane.add(pass);
		pass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));

		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		passwordField.setBounds(211, 363, 126, 25);
	    Border customBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    passwordField.setBorder(customBorder1);
	    passwordField.setBackground(new Color(250, 250, 250));
		contentPane.add(passwordField);
		

		
        JButton login_btn = new JButton("Log in");
        login_btn.setForeground(Color.WHITE);
        login_btn.setBackground(Color.LIGHT_GRAY);
        login_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInput = textField_1.getText(); // User can enter email or username
                char[] passwordChars = passwordField.getPassword();
                selectedUser = (String) combobox_of_user.getSelectedItem();

                // Database operations
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    // Create a PreparedStatement to check user credentials
                    String query = "SELECT * FROM signup_info WHERE (email = ? OR user_name = ?) AND password = ? AND user_type = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, userInput);
                        preparedStatement.setString(2, userInput);
                        preparedStatement.setString(3, new String(passwordChars));
                        preparedStatement.setString(4, selectedUser);

                        // Execute the query
                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                             dispose();
                        	 redirectToDashboard(userInput, selectedUser);
                        	
                        } else {
                            // Invalid credentials, show an error message
                            JOptionPane.showMessageDialog(contentPane, "Invalid username/email or password!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Error in database operation", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        login_btn.setBounds(448, 539, 242, 43);
        login_btn.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(login_btn);



  
        showPasswordCheckBox = new JCheckBox("");
        showPasswordCheckBox.setBounds(343, 367, 21, 21);
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePasswordVisibility();
            }
        });
        contentPane.add(showPasswordCheckBox);
			
			JButton btnNewButton = new JButton("Forgot your password?");
			btnNewButton.setBorderPainted(false);  // Set the border to null
			btnNewButton.setContentAreaFilled(false);  
			btnNewButton.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
			         Forgetpass logIn = new Forgetpass();
			         logIn.setVisible(true);
	            }
	        });
			btnNewButton.setForeground(Color.BLACK);
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
			btnNewButton.setBounds(116, 480, 176, 27);
			contentPane.add(btnNewButton);
				
				JButton login_btn_1= new JButton("Not Signedup yet!? Sign up here!");
				login_btn_1.setBounds(448, 586, 242, 33);
				contentPane.add(login_btn_1);
				login_btn_1.setForeground(Color.BLACK);
				login_btn_1.setBackground(Color.BLACK);
		        login_btn_1.setBorderPainted(false);  // Set the border to null
		        login_btn_1.setContentAreaFilled(false);  
		        login_btn_1.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	openSignupPanel();
		            }
		        });
				login_btn_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				
				JLabel lblNewLabel_1 = new JLabel("Course");
				lblNewLabel_1.setBounds(41, 110, 119, 65);
				contentPane.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
				
				JLabel lblNewLabel_1_1 = new JLabel("Management");
				lblNewLabel_1_1.setBounds(37, 177, 246, 65);
				contentPane.add(lblNewLabel_1_1);
				lblNewLabel_1_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
				
				JLabel lblNewLabel_1_2 = new JLabel("System");
				lblNewLabel_1_2.setBounds(35, 241, 136, 65);
				contentPane.add(lblNewLabel_1_2);
				lblNewLabel_1_2.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(0, 0, 786, 629);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(Signin.class.getResource("/images/olia-gozha-J4kK8b9Fgj8-unsplash.png")));
				lblNewLabel_3.setBounds(0, 0, 786, 629);
				contentPane.add(lblNewLabel_3);
				
				
				
				
	}


	private void togglePasswordVisibility() {
	    if (showPasswordCheckBox.isSelected()) {
	        passwordField.setEchoChar((char) 0); // Show the password
	    } else {
	      passwordField.setEchoChar('*'); // Hide the password
	    }
	}

    private void redirectToDashboard(String userInput, String selectedUser) {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.setUserInformation(userInput, selectedUser);
      

    }

    
    private void  openSignupPanel(){
    	 dispose();
         Signup logIn = new Signup();
         logIn.setVisible(true);
    }
}