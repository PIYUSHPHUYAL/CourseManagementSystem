package firstpac;

import java.awt.Color;
import javax.swing.border.Border;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import secondpac.Forgetpass;


import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
public class Signup extends JFrame {

	private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JCheckBox showPasswordCheckBox;
	private JPasswordField passwordField_1;
	private JCheckBox showPasswordCheckBox_1;
	private JPasswordField passwordField_2;
	/**
	 * Launch the application.A
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("Sign up Panel");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Signin.class.getResource("/images/1111.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250,250,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 setLocationRelativeTo(null);
		 setResizable(false);
		 
			JLabel user_toggle = new JLabel("Phone No:");
			user_toggle.setBounds(37, 398, 134, 21);
			contentPane.add(user_toggle);
			user_toggle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		 
	        JComboBox<String> combobox_of_user = new JComboBox<>();
	        combobox_of_user.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	        combobox_of_user.setBounds(37, 470, 134, 25);
	        combobox_of_user.addItem("Select a User");
	        combobox_of_user.addItem("Student");
	        combobox_of_user.addItem("Administrator");
	        combobox_of_user.addItem("Teacher");
	        combobox_of_user.setSelectedItem("Select the User");
	        Border customComboBoxBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	        combobox_of_user.setBorder(customComboBoxBorder);
	        combobox_of_user.setBackground(new Color(240, 240, 240));
	        contentPane.add(combobox_of_user);
			
			
	        // Styling for JComboBox 2
	        JComboBox<String> combobox_of_user_1 = new JComboBox<>();
	        combobox_of_user_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	        combobox_of_user_1.setModel(new DefaultComboBoxModel<>(new String[]{"Select a Course", "BIT", "BIBM", "MIBM"}));
	        combobox_of_user_1.setBounds(37, 508, 134, 25);
	        Border customComboBoxBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	        combobox_of_user_1.setBorder(customComboBoxBorder2);
	        combobox_of_user_1.setBackground(new Color(240, 240, 240));
	        contentPane.add(combobox_of_user_1);
		
			  
			JLabel user_toggle_1 = new JLabel("User Name:");
			user_toggle_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
			user_toggle_1.setBounds(38, 330, 133, 21);
			contentPane.add(user_toggle_1);
			
			
			textField = new JTextField();
			textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			textField.setBounds(38, 363, 133, 25);
			contentPane.add(textField);
		    Border customBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    textField.setBorder(customBorder);
		    textField.setBackground(new Color(250, 250, 250));
			textField.setColumns(10);
			
			

			
			
			
			
			JLabel email_add = new JLabel("Email Address:");
			email_add.setBounds(211, 328, 164, 25);
			contentPane.add(email_add);
			email_add.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			textField_2.setBounds(211, 363, 126, 25);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		    Border customBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    textField_2.setBorder(customBorder1);
		    textField_2.setBackground(new Color(250, 250, 250));
			
			// Adding a focus listener to perform email validation when the field loses focus
			textField_2.addFocusListener(new FocusAdapter() {
			    @Override
			    public void focusLost(FocusEvent e) {
			        validateEmail(textField_2.getText());
			    }
			});

			
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			passwordField.setBounds(211, 435, 134, 25);
			contentPane.add(passwordField);
		    Border customBorder11 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    passwordField.setBorder(customBorder11);
		    passwordField.setBackground(new Color(250, 250, 250));
			
			
	        passwordField.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                validatePassword(passwordField.getPassword());
	            }
	        });
			
			
	        JButton signupButton = new JButton("Sign up");
	        signupButton.setForeground(Color.WHITE);
	        signupButton.setBackground(Color.LIGHT_GRAY);
	        signupButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Validate other fields...
	                if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || passwordField.getPassword().length == 0 || passwordField_1.getPassword().length == 0 || passwordField_2.getPassword().length == 0 || combobox_of_user.getSelectedIndex() == 0 || combobox_of_user_1.getSelectedIndex() == 0) {
	                    JOptionPane.showMessageDialog(contentPane, "Please fill in all the required fields", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                // Get user input
	                String userName = textField.getText();
	                String phone = textField_1.getText();
	                String email = textField_2.getText();
	                char[] password = passwordField.getPassword();
	                char[] confirmPassword = passwordField_1.getPassword();
	                String selectedUser = (String) combobox_of_user.getSelectedItem();
	                String selectedCourse = (String) combobox_of_user_1.getSelectedItem();
	                char[] answer = passwordField_2.getPassword();

	                // Check if passwords match
	                if (!Arrays.equals(password, confirmPassword)) {
	                    JOptionPane.showMessageDialog(contentPane, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                // Database operations
	                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	                    // Create a PreparedStatement to insert user information
	                    String insertQuery = "INSERT INTO signup_info (user_name, phone, email, password, user_type, course,security_answer) VALUES (?, ?, ?, ?, ?, ?, ?)";
	                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	                        preparedStatement.setString(1, userName);
	                        preparedStatement.setString(2, phone);
	                        preparedStatement.setString(3, email);
	                        preparedStatement.setString(4, new String(password));
	                        preparedStatement.setString(5, selectedUser);
	                        preparedStatement.setString(6, selectedCourse);
	                        preparedStatement.setString(7, new String(answer));

	                        // Check if the selected user is a student before setting the course
	                        if ("Student".equals(selectedUser)) {
	                            preparedStatement.setString(6, selectedCourse);
	                        } else {
	                            preparedStatement.setNull(6, Types.VARCHAR); // Set course to NULL for non-student users
	                        }

	                        // Execute the update
	                        preparedStatement.executeUpdate();
	                    }

	                    // Inform the user about successful signup
	                    JOptionPane.showMessageDialog(contentPane, "Sign up successful", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    openSignin();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(contentPane, "Error in database operation", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });

	        signupButton.setBounds(448, 539, 242, 43);
	        signupButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	        contentPane.add(signupButton);
			

	        showPasswordCheckBox = new JCheckBox("");
	        showPasswordCheckBox.setBounds(357, 437, 21, 21);
	        showPasswordCheckBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                togglePasswordVisibility1();
	            }
	        });
	        contentPane.add(showPasswordCheckBox);
	        
	        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
	        lblConfirmPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
	        lblConfirmPassword.setBounds(211, 470, 178, 33);
	        contentPane.add(lblConfirmPassword);
	        
	        passwordField_1 = new JPasswordField();
	        passwordField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
	        passwordField_1.setBounds(211, 510, 134, 25);
	        contentPane.add(passwordField_1);
		    Border customBorder111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    passwordField_1.setBorder(customBorder111);
		    passwordField_1.setBackground(new Color(250, 250, 250));
	        
	        
	        showPasswordCheckBox_1 = new JCheckBox("");
	        showPasswordCheckBox_1.setBounds(354, 512, 21, 21);
	        showPasswordCheckBox_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                togglePasswordVisibility2();
	            }
	        });
	        contentPane.add(showPasswordCheckBox_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Your Favourite Person?");
	        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
	        lblNewLabel_2.setBounds(37, 557, 145, 25);
	        contentPane.add(lblNewLabel_2);
	        
	        passwordField_2 = new JPasswordField();
	        passwordField_2.setBounds(211, 557, 133, 25);
	        contentPane.add(passwordField_2);
		    Border customBorder1111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    passwordField_2.setBorder(customBorder1111);
		    passwordField_2.setBackground(new Color(250, 250, 250));
	        
	        textField_1 = new JTextField();
	        textField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
	        textField_1.setBounds(38, 435, 133, 25);
	        contentPane.add(textField_1);
	        textField_1.setColumns(10);
		    Border customBorder11111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		    textField_1.setBorder(customBorder11111);
		    textField_1.setBackground(new Color(250, 250, 250));
	        
	        
	        JLabel pass = new JLabel("Password:");
	        pass.setBounds(212, 392, 96, 33);
	        contentPane.add(pass);
	        pass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
	        
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
	        
	        JButton login_btn_1 = new JButton("Already Siggnedin? Click here!");
	        login_btn_1.setOpaque(false);
	        login_btn_1.setBorderPainted(false);  // Set the border to null
	        login_btn_1.setContentAreaFilled(false);  
	        login_btn_1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Perform the action when the mouse is clicked near the button
	                dispose();
	                Signin dash = new Signin();
	                dash.setVisible(true);
	            }
	        });
	        login_btn_1.setForeground(Color.BLACK);
	        login_btn_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	        login_btn_1.setBackground(Color.LIGHT_GRAY);
	        login_btn_1.setBounds(448, 586, 242, 33);
	        contentPane.add(login_btn_1);
	        
	        JLabel lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/images/olia-gozha-J4kK8b9Fgj8-unsplash.png")));
	        lblNewLabel.setBounds(0, 0, 786, 629);
	        contentPane.add(lblNewLabel);

				
	}
	
	 private void togglePasswordVisibility1() {
	        if (showPasswordCheckBox  .isSelected()) {
	            passwordField.setEchoChar((char) 0); // Show the password
	        } else {
	            passwordField.setEchoChar('*'); // Hide the password
	        }
	        // Only validate the password if it's not visible
	        if (!showPasswordCheckBox.isSelected()) {
	            validatePassword(passwordField.getPassword());
	        }
	    }
	 private void togglePasswordVisibility2() {
	        if (showPasswordCheckBox_1  .isSelected()) {
	            passwordField_1.setEchoChar((char) 0); // Show the password
	        } else {
	            passwordField_1.setEchoChar('*'); // Hide the password
	        }
	        // Only validate the password if it's not visible
	        if (!showPasswordCheckBox_1.isSelected()) {
	            validatePassword(passwordField_1.getPassword());
	        }
	    }
	 
		private void validatePassword(char[] cs) {
		    String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%]).{8,}$";

		    if (!Pattern.matches(passwordPattern, new String(cs))) {
		        // Show a pop-up error for incorrect password format
		        JOptionPane.showMessageDialog(contentPane, "Please enter a password in (Abc@123) format", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		
		// Method to validate email using a regular expression
		private void validateEmail(String email) {
		    String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";
		    if (Pattern.matches(emailPattern, email)) {
		    } else {
		        
		        JOptionPane.showMessageDialog(contentPane, "Invalid email format or not a Gmail address", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		
	    private void openSignin() {
	        dispose();
	        Signin dash = new Signin();
	        dash.setVisible(true);
	    }
}
