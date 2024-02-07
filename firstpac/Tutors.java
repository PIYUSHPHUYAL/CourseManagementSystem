package firstpac;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import secondpac.Addcourse;
import secondpac.Addtutor;
import secondpac.Deletetutor;
import secondpac.Edittutor;
import secondpac.Makeprogress;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Tutors extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
	private static final String DB_URL = "jdbc:mysql://localhost/cms";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    
	  private void callFunction() {
	        Function Instance = new Function();
	        Instance.DashboardAndNotification(contentPane);
	    }
	  
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tutors frame = new Tutors();
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
            String query = "SELECT name, email, phone, id FROM addtutor WHERE name LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, searchText + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a DefaultTableModel for the JTable
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID"); 
                model.addColumn("Name");              
                model.addColumn("Email");
                model.addColumn("Phone");

                // Populate the model with data from the ResultSet
                while (resultSet.next()) {
                    Object[] row = {resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone")
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

    public Tutors() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Tutors");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 663);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250,250,250));
        contentPane.setLayout(null);  
        setContentPane(contentPane);
        setResizable(false);
        callFunction();
        
        JLabel lblNewLabel_2 = new JLabel("Tutors");
        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
        lblNewLabel_2.setBackground(Color.WHITE);
        lblNewLabel_2.setBounds(239, 40, 286, 82);
        contentPane.add(lblNewLabel_2);
        
                
                JButton btnAdd = new JButton("Add Tutor");
                btnAdd.setOpaque(false);
                btnAdd.setBounds(243, 121, 173, 140);
                contentPane.add(btnAdd);
                
                btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ("Administrator".equals(Dashboard.usertype)) {
//            		dispose();  
                      	    Addtutor tt = new Addtutor();
                      	    tt.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can add tutors.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });     
                btnAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
                btnAdd.setBackground(Color.WHITE);
        	    Border customBorder11 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
        	    btnAdd.setBorder(customBorder11);
                
                        
                        JButton btnEditCourse = new JButton("Edit ");
                        btnEditCourse.setOpaque(false);
                        btnEditCourse.setBounds(420, 121, 173, 65);
                        contentPane.add(btnEditCourse);
                        btnEditCourse.setBackground(Color.WHITE);
                        btnEditCourse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
                	    Border customBorder111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
                	    btnEditCourse.setBorder(customBorder111);
                        
                                
                        
                                
                                
                                JButton btnRemoveCourse = new JButton("Delete ");
                                btnRemoveCourse.setOpaque(false);
                                btnRemoveCourse.setBounds(420, 196, 173, 65);
                                contentPane.add(btnRemoveCourse);
                                btnRemoveCourse.setBackground(Color.WHITE);
                                btnRemoveCourse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
                        	    Border customBorder1111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
                        	    btnRemoveCourse.setBorder(customBorder1111);
                                
                                JLabel lblSearch = new JLabel("        Search");
                                lblSearch.setBounds(605, 225, 173, 35);
                                contentPane.add(lblSearch);
                                lblSearch.setForeground(Color.BLACK);
                                lblSearch.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                                lblSearch.setBackground(Color.WHITE);
                        	    Border customBorder11111 = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
                        	    lblSearch.setBorder(customBorder11111);
                                
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
                                       
                               		JButton btnMakeReport = new JButton("Make Report");
                               		btnMakeReport.setOpaque(false);
                            		btnMakeReport.setBounds(603, 122, 173, 65);
                            		contentPane.add(btnMakeReport);
                            	    Border cust = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(100, 100, 100));
                            	    btnMakeReport.setBorder(cust);
                            	    
                            	    
                            		btnMakeReport.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if ("Teacher".equals(Dashboard.usertype)) {
                                				dispose();  
                             	          	   Makeprogress tt = new  Makeprogress();
                             	          	    tt.setVisible(true);
                                            } else {
                                                JOptionPane.showMessageDialog(contentPane, "Access Denied. Only Tutors can make report.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                                            }
                                        }
                                    });
                            		btnMakeReport.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
                            		btnMakeReport.setBackground(Color.LIGHT_GRAY);
                            		
                            		JLabel lblNewLabel = new JLabel("");
                            		lblNewLabel.setIcon(new ImageIcon(Tutors.class.getResource("/images/abstract-blue-geometric-shapes-background (1).jpg")));
                            		lblNewLabel.setBounds(0, 0, 786, 636);
                            		contentPane.add(lblNewLabel);
                                       
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
//               	dispose();  
                                      	    Deletetutor cc = new Deletetutor();
                                      	    cc.setVisible(true);
                                        } else {
                                            JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can delete tutors.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                });   
                        
                        btnEditCourse.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if ("Administrator".equals(Dashboard.usertype)) {
//               	dispose();  
                              	    Edittutor tt = new Edittutor();
                              	    tt.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(contentPane, "Access Denied. Only administrators can edit tutors.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        });   
        
        
        
        
        

    }
    
    
    public int getTutorCount() {
        int count = 0;

        // Database operations to get the count
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT COUNT(*) AS count FROM addtutor";
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
