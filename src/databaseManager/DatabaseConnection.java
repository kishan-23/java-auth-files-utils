package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton pattern used Class to get database connection instance anywhere in the project.
 * @author kishan
 */

public class DatabaseConnection {
    private static Connection instance;

    private DatabaseConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/code_rt","root","");
        } catch (SQLException throwables) {
            System.out.println("Error in making Database Connection");
            throwables.printStackTrace();
        }
        instance = con;
    }

    /**
     * public method to get the database connection instance
     * @return single instance of database connection
     */
    public static Connection getInstance() throws SQLException {
        if(instance==null||instance.isClosed()) new DatabaseConnection();
        return instance;
    }
}
