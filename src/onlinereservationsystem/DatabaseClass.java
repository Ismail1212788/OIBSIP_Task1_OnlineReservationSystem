/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinereservationsystem;

/**
 *
 * @author kali-i
 */
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseClass {
    
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "OnlineReservationUser";
    static final String USER = "root";
    static final String PASSWORD = "root";
    
    
      public static void checkDatabaseConnection() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL , USER, PASSWORD)) {
            if (connection.isValid(5)) { 
                System.out.println("Database connection is active.");
            } else {
                System.out.println("Database connection is not active.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  public static void CreateDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            
            // Switch to the database
            connection.setCatalog(DB_NAME);

            String createTableQuery = "CREATE TABLE IF NOT EXISTS clients (" +
                    "id VARCHAR(255)," +
                    "name VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "city VARCHAR(255)," +
                    "contact VARCHAR(20)" +
                    ")";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table Created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
  public static int RegisterUser(String name, String Userid,String password, String city, String contact){
       try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            
            // Switch to the database
            connection.setCatalog(DB_NAME);

             String insertQuery = "INSERT INTO clients (id,name, password, city, contact) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, Userid);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, contact);
                
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
            return 1;
                } else {
                         
              return 0;  
                }
            

        }
       }
       
          catch (SQLException e) {
               JOptionPane.showMessageDialog(
            null,
            "Account Not Registered Succesfully Please Try Again", 
            "Error",          
            JOptionPane.ERROR_MESSAGE
        );
        }
        return -1;
       
       }

 public static boolean checkRecordExists(String id, String password) {
        boolean isfound = false;
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD)) {
            String query = "SELECT COUNT(*) FROM clients WHERE id = ? AND password = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, password);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        isfound = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isfound;
    }


    public static void createReservationTable() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS reservations (" +
                    "pnrNo VARCHAR(255) PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "contact VARCHAR(20) NOT NULL," +
                    "origin VARCHAR(255) NOT NULL," +
                    "destination VARCHAR(255) NOT NULL," +
                    "trainname VARCHAR(255) NOT NULL," +
                    "trainnumber VARCHAR(255) NOT NULL," +
                    "classtype VARCHAR(255) NOT NULL," +
                    "journeydate VARCHAR(255) NOT NULL" +
                    ")";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table 'reservations' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


       public static int insertReservation(String pnrNo, String name, String contact,
                                         String origin, String destination, String trainname,
                                         String trainnumber, String classtype, String journeydate) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD);
            String insertQuery = "INSERT INTO reservations (pnrNo, name, contact, origin, destination, trainname, trainnumber, classtype, journeydate) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, pnrNo);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, contact);
            preparedStatement.setString(4, origin);
            preparedStatement.setString(5, destination);
            preparedStatement.setString(6, trainname);
            preparedStatement.setString(7, trainnumber);
            preparedStatement.setString(8, classtype);
            preparedStatement.setString(9, journeydate);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                return 1;
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            return 0;
        }
        return -1;
    }
    
    public static ArrayList<String> getPNRsBySubstring(String substring) {
        String url = "jdbc:mysql://your_database_url";
        String username = "your_username";
        String password = "your_password";
        ArrayList<String> matchingPNRs = new ArrayList<>();

        try {
             Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD);
            String query = "SELECT pnrNo FROM reservations WHERE pnrNo LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,substring + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pnrNo = resultSet.getString("pnrNo");
                matchingPNRs.add(pnrNo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchingPNRs;
    }

    
     public static String fetchMatchingRecords(String substring) {
        StringBuilder result = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD)) {
            String query = "SELECT * FROM reservations WHERE pnrNo LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, substring);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String pnrNo = resultSet.getString("pnrNo");
                        String name = resultSet.getString("name");
                        String contact = resultSet.getString("contact");
                        String origin = resultSet.getString("origin");
                        String destination = resultSet.getString("destination");
                        String trainname = resultSet.getString("trainname");
                        String trainnumber = resultSet.getString("trainnumber");
                        String classtype = resultSet.getString("classtype");
                        String journeydate = resultSet.getString("journeydate");

                        // Append values to the result string
                        result.append(pnrNo).append(", ")
                              .append(name).append(", ")
                              .append(contact).append(", ")
                              .append(origin).append(", ")
                              .append(destination).append(", ")
                              .append(trainname).append(", ")
                              .append(trainnumber).append(", ")
                              .append(classtype).append(", ")
                              .append(journeydate).append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void deleteRecordsWithSubstring(String substring) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL+DB_NAME, USER, PASSWORD)) {
            String deleteQuery = "DELETE FROM reservations WHERE pnrNo LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, "%" + substring + "%");
                int rowsDeleted = preparedStatement.executeUpdate();
                System.out.println(rowsDeleted + " records deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    
}

