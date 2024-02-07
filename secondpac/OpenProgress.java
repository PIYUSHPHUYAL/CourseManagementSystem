package secondpac;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import firstpac.Dashboard;
import firstpac.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class OpenProgress extends JFrame {

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
					OpenProgress frame = new OpenProgress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private JTable table;
    private void populateTable(String studentId) {
    	
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240,240,240));
        panel.setBounds(0, 62, 486, 401);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JEditorPane editorPane_1 = new JEditorPane();
        editorPane_1.setOpaque(false);
        editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editorPane_1.setBounds(152, 41, 97, 29);
        panel.add(editorPane_1);
        
        
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setOpaque(false);
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editorPane_2.setBounds(91, 90, 97, 29);
        panel.add(editorPane_2);
        
        
        // Database operations to get filtered data based on studentId for all levels
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
           
            // Query to retrieve student name
            String nameQuery = "SELECT name FROM progress_report WHERE id = ?";
            try (PreparedStatement nameStatement = connection.prepareStatement(nameQuery)) {
                nameStatement.setString(1, studentId);
                ResultSet nameResultSet = nameStatement.executeQuery();

                // Fetch the student name if it exists
                String studentName = nameResultSet.next() ? nameResultSet.getString("name") : "No name ";

                // Set the fetched name to editorPane_1
                editorPane_1.setText(studentName);
            }
        	
        
         // Query to retrieve student courses
            String coursesQuery = "SELECT course FROM progress_report WHERE id = ?";
            try (PreparedStatement coursesStatement = connection.prepareStatement(coursesQuery)) {
                coursesStatement.setString(1, studentId);
                ResultSet coursesResultSet = coursesStatement.executeQuery();

                // Fetch the courses if they exist
                StringBuilder coursesStringBuilder = new StringBuilder();
                while (coursesResultSet.next()) {
                    coursesStringBuilder.append(coursesResultSet.getString("course")).append(", ");
                }

                // Remove the trailing comma and space if any
                String courses = coursesStringBuilder.length() > 0 ? coursesStringBuilder.substring(0, coursesStringBuilder.length() - 2) : "No courses";

                // Set the fetched courses to editorPane_2
                editorPane_2.setText(courses);
            }

            
        	String query = "SELECT id, name, course,l4m1, l4m2, l4m3, l5m1, l5m2, l5m3, l6m1, l6m2, l6m3 FROM progress_report WHERE id LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, studentId + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a DefaultTableModel for the JTable
                DefaultTableModel model = new DefaultTableModel();

                // Add columns for each level and module
                model.addColumn("Module");
                model.addColumn("L4");
                model.addColumn("L5");
                model.addColumn("L6");

                // Variables to store the total for each level
                int totalL4 = 0;
                int totalL5 = 0;
                int totalL6 = 0;

                // Check if there are any rows in the result set
                if (resultSet.next()) {
                    int rowCount = 0;
                    // Populate the model with data from the ResultSet
                    for (int i = 1; i <= 3; i++) { // Assuming there are 3 modules for each level
                        int l4Value = resultSet.getInt("l4m" + i);
                        int l5Value = resultSet.getInt("l5m" + i);
                        int l6Value = resultSet.getInt("l6m" + i);

                        // Update the totals
                        totalL4 += l4Value;
                        totalL5 += l5Value;
                        totalL6 += l6Value;

                        // Add the row for the module
                        Object[] row = {
                                "Module " + i,
                                l4Value,
                                l5Value,
                                l6Value
                        };
                        model.addRow(row);
                        rowCount++;
                    }

                    // Add a row for the averages
                    Object[] averageRow = {
                            "Total",
                            totalL4 / rowCount,
                            totalL5 / rowCount,
                            totalL6 / rowCount
                    };
                    model.addRow(averageRow);
                } else {
                    // Handle the case when there are no matching rows for the given studentId
                    // You may want to show a message or handle it based on your requirements
                }

                // Set the model to the JTable
                table.setModel(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error fetching data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
     
    }




	public OpenProgress() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/1111.png")));
        setTitle("Student");
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
        
        JLabel lblNewLabel_1 = new JLabel("Student Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(30, 41, 130, 29);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Course:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(30, 90, 65, 29);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Enter Student's Id");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(296, 51, 145, 29);
        panel.add(lblNewLabel_1_2);
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editorPane.setBounds(342, 90, 54, 29);
        panel.add(editorPane);
        


        editorPane.getDocument().addDocumentListener(new DocumentListener() {
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
                String searchText = editorPane.getText().trim();
                populateTable(searchText);
            }
        });
        
        
        // Create the JTable
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(486, 223);
        scrollPane.setLocation(0, 178);
        panel.add(scrollPane, BorderLayout.CENTER);

//        populateTable(editorPane_1.getText());
        
  
        JEditorPane editorPane_2 = new JEditorPane();
        editorPane_2.setOpaque(false);
        editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        editorPane_2.setBounds(91, 90, 97, 29);
        panel.add(editorPane_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Module Grades:");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_3.setBounds(30, 139, 169, 29);
        panel.add(lblNewLabel_1_3);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 486, 63);
        contentPane.add(panel_1);
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setLayout(null);
        
        
                JLabel lblProgressReport = new JLabel("Progress Report");
                lblProgressReport.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblProgressReport.setBackground(Color.GRAY);
                lblProgressReport.setBounds(129, 8, 183, 50);
                panel_1.add(lblProgressReport);
                
                JButton btnBack = new JButton("Back");
                btnBack.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                        dispose();
                        Student coursesPanel = new Student();
                         coursesPanel.setVisible(true);
                	}
                });
                btnBack.setBackground(Color.LIGHT_GRAY);
                btnBack.setBounds(397, 21, 79, 32);
                panel_1.add(btnBack);
        
      

        
        
        
        
        
        
	}
}
