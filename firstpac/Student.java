package firstpac;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import secondpac.Addstudent;
import secondpac.Deletestudent;
import secondpac.Editstudent;
import secondpac.Makeprogress;
import secondpac.OpenProgress;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

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
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


    private void populateTable(String searchText) {
        // Database operations to get filtered data based on searchText
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT name, email, phone,course, id FROM progress_report WHERE name LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, searchText + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a DefaultTableModel for the JTable
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID"); 
                model.addColumn("Name");              
                model.addColumn("Email");
                model.addColumn("Phone");
                model.addColumn("Course");

                // Populate the model with data from the ResultSet
                while (resultSet.next()) {
                    Object[] row = {resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("course")
                    };
                    model.addRow(row);
                }
                // Set the model to the JTable
                table.setModel(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error fetching data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
	public Student() {
	 	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
	 	 setTitle("Student"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(250,250,250));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250,250,250));
		callFunction();
		
		JLabel lblNewLabel_2 = new JLabel("Students");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(239, 40, 306, 82);
		contentPane.add(lblNewLabel_2);
		
		JButton btnProgress = new JButton("Progress");
		btnProgress.setOpaque(false);
		btnProgress.setBounds(605, 121, 173, 65);
		contentPane.add(btnProgress);
		   Border customBorder1111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
		   btnProgress.setBorder(customBorder1111);
		btnProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		dispose();  
 	          	   OpenProgress tt = new  OpenProgress();
 	          	    tt.setVisible(true);
         
            }
        });
		btnProgress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnProgress.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(243, 121, 173, 140);
		contentPane.add(btnNewButton);
	    Border customBorder11111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    btnNewButton.setBorder(customBorder11111);
		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Administrator".equals(Dashboard.usertype)) {
    				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();
              	    Addstudent tt = new Addstudent();
              	    tt.setVisible(true);
 				
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Access Denied. Only Administrator can Add a student.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		

		
		JButton btnRemoveCourse = new JButton("   Delete ");
		btnRemoveCourse.setOpaque(false);
		btnRemoveCourse.setBounds(420, 195, 173, 65);
		contentPane.add(btnRemoveCourse);
	    Border customBorder111111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    btnRemoveCourse.setBorder(customBorder111111);
		btnRemoveCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Administrator".equals(Dashboard.usertype)) {
    			      dispose(); 
    	          	   Deletestudent tt = new Deletestudent();
    	          	    tt.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Access Denied. Only Administrator can Delete a student.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
		
				btnRemoveCourse.setBackground(Color.LIGHT_GRAY);
				btnRemoveCourse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
				
				
		
		JLabel lblNewLabel = new JLabel("       Search");
		lblNewLabel.setBounds(605, 225, 173, 35);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
	    Border custom1 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    lblNewLabel.setBorder(custom1);
		
		JButton btnUpdate = new JButton("   Update");
		btnUpdate.setOpaque(false);
		btnUpdate.setBounds(420, 121, 173, 65);
		contentPane.add(btnUpdate);
	    Border customBorder1111111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    btnUpdate.setBorder(customBorder1111111);
		btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Administrator".equals(Dashboard.usertype)) {
    				((JFrame) SwingUtilities.getWindowAncestor( btnUpdate )).dispose(); 
 	          	   Editstudent tt = new Editstudent();
 	          	    tt.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Access Denied. Only Administrator can Update a student.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
				
		        textField = new JTextField();
		        textField.setOpaque(false);
		        textField.setBounds(605, 194, 173, 26);
		        contentPane.add(textField);
		        textField.setColumns(10);
		        
		        
		        // Create the JTable
		        table = new JTable();
		        JScrollPane scrollPane = new JScrollPane(table);
		        scrollPane.setBounds(241, 265, 545, 361);
		        scrollPane.setOpaque(false);
		        scrollPane.getViewport().setOpaque(false);
		        contentPane.add(scrollPane);
		        
		        JLabel lblNewLabel_1 = new JLabel("");
		        lblNewLabel_1.setIcon(new ImageIcon(Student.class.getResource("/images/abstract-blue-geometric-shapes-background (1).jpg")));
		        lblNewLabel_1.setBounds(0, 0, 786, 626);
		        contentPane.add(lblNewLabel_1);
		        
		                textField.getDocument().addDocumentListener(new DocumentListener() {
		                    @Override
		                    public void insertUpdate(DocumentEvent e) {
		                        updateTable();
		                    }
		        
		                    @Override
		                    public void removeUpdate(DocumentEvent e) {
		                        updateTable();
		                    }
		        
		                    @Override
		                    public void changedUpdate(DocumentEvent e) {
		                        updateTable();
		                    }
		        
		                    private void updateTable() {
		                        String searchText = textField.getText().trim();
		                        populateTable(searchText);
		                    }
		                });
		                populateTable(textField.getText());
		
		
	}
	
    
    public int getStudentCount() {
        int count = 0;

        // Database operations to get the count
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT COUNT(*) AS count FROM progress_report";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error fetching data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return count;
    }
}
