package firstpac;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import secondpac.Addcourse;
import secondpac.Deletecourse;
import secondpac.Editcourse;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Courses extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
	private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static String usertype;
    
	  private void callFunction() {
	        Function Instance = new Function();
	        Instance.DashboardAndNotification(contentPane);
	    }
	  
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Courses frame = new Courses();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JTable table;

    private void populateTable(String searchText) {
        // Database operations to get filtered data based on searchText
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT id, coursename, no_of_seats, batch FROM addcourse WHERE coursename LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, searchText + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a DefaultTableModel for the JTable
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Course Name");
                model.addColumn("No of Seats");
                model.addColumn("Batch");

                // Populate the model with data from the ResultSet
                while (resultSet.next()) {
                    Object[] row = {
                            resultSet.getInt("id"),
                            resultSet.getString("coursename"),
                            resultSet.getString("no_of_seats"),
                            resultSet.getString("batch")
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

    public Courses() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 663);
        contentPane = new JPanel();
    	contentPane.setBackground(new Color(250,250,250));
        setContentPane(contentPane);
        contentPane.setLayout(null);  
        setLocationRelativeTo(null);
        setResizable(false);
        callFunction();
        contentPane.setBackground(new Color(250,250,250));
	    Border customBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    Border customBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	    Border customBorder11 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
	
	  
        
        // Create the JTable
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.setBounds(243, 271, 543, 355);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setOpaque(false); // Set viewport's opaque property to false
        contentPane.add(scrollPane);
        
        
        JButton btnNewButton = new JButton("Add Course");
        btnNewButton.setOpaque(false);
        btnNewButton.setBounds(243, 121, 173, 140);
        contentPane.add(btnNewButton);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        btnNewButton.setBorder(customBorder11);
        
        
                JButton btnRemoveCourse = new JButton("Delete Course");
                btnRemoveCourse.setOpaque(false);
                btnRemoveCourse.setBounds(605, 121, 173, 65);
                contentPane.add(btnRemoveCourse);
                btnRemoveCourse.setBackground(Color.WHITE);
                btnRemoveCourse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
                btnRemoveCourse.setBorder(customBorder1);
                
                

                

                JLabel lblSearch = new JLabel("        Search");
                lblSearch.setBounds(605, 225, 173, 35);
                contentPane.add(lblSearch);
                lblSearch.setForeground(Color.BLACK);
                lblSearch.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                lblSearch.setBackground(Color.WHITE);
                Border customBorder111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
                lblSearch.setBorder(customBorder);
                
                
                
                
                
                


                

                textField = new JTextField();
                textField.setOpaque(false);
                textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
                textField.setBounds(605, 194, 173, 26);
                contentPane.add(textField);
                textField.setColumns(10);
                

                
                JButton btnEditCourse = new JButton("Edit Course");
                btnEditCourse.setOpaque(false);
                btnEditCourse.setBounds(420, 121, 173, 140);
                contentPane.add(btnEditCourse);
                btnEditCourse.setBackground(Color.WHITE);
                btnEditCourse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
                btnEditCourse .setBorder(customBorder111);
                
                JLabel lblNewLabel_2 = new JLabel("Courses");
                lblNewLabel_2.setBounds(239, 40, 286, 82);
                contentPane.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
                lblNewLabel_2.setBackground(Color.WHITE);
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(Courses.class.getResource("/images/abstract-blue-geometric-shapes-background (1).jpg")));
                lblNewLabel.setBounds(0, 0, 786, 626);
                contentPane.add(lblNewLabel);
                
                btnEditCourse.addActionListener(new ActionListener() {
                	// METHOD OVERRIDING HERE AS DYNAMIC BINDING RUN-TIME POLYMORPHISM
                    @Override    
                    public void actionPerformed(ActionEvent e) {
                        if ("Administrator".equals(Dashboard.usertype)) {
               	            dispose();  
                      	    Editcourse cs2 = new Editcourse();
                      	    cs2.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can edit courses.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
                
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
                
                btnRemoveCourse.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ("Administrator".equals(Dashboard.usertype)) {
                           	dispose();  
                      	    Deletecourse cs2 = new Deletecourse();
                      	    cs2.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can delete courses.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
        
                btnNewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ("Administrator".equals(Dashboard.usertype)) {
                            dispose();
                            Addcourse addCourse = new Addcourse();
                            addCourse.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can add courses.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
        
        
        
    }
    

    
    public int getCourseCount() {
        int count = 0;

        // Database operations to get the count
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT COUNT(*) AS count FROM addcourse";
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