package databaseManager.userManager;

import databaseManager.DatabaseConnection;

import java.sql.*;

/**
 * Class for registering new user on the server and handling related issues.
 * @author kishan
 */

public class NewUser {
    private String name;
    private String email;
    private String pass;
    private String user_id;
    private Connection con;

    /**
     * Constructor accepts and sets the Name and password of the user only,
     * user_id and email will be set using separate methods to ensure uniqueness.
     * @param name Name of the User
     * @param pass Password hash
     * @throws SQLException
     */
    public NewUser(String name, String pass) throws SQLException {
        this.name = name;
        this.pass = pass;
        con = DatabaseConnection.getInstance();
    }

    /**
     * method to set user_id
     * @param user_id
     * @return true if unique user_id is set successfully
     * @throws SQLException
     */
    public boolean setUser_id(String user_id) throws SQLException {
        String query = "select `user_id` from user_info";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            if(rs.getString(1).equals(user_id)) return false;
        }
        this.user_id = user_id;
        return true;
    }

    /**
     * method to set email
     * @param email
     * @return true if unique user_id is set successfully
     * @throws SQLException
     */
    public boolean setEmail(String email) throws SQLException {
        String query = "select `email` from user_info";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (rs.getString(1).equals(email)) return false;
        }
        this.email = email;
        return true;
    }

    /**
     * method to register a user on server
     * @return true if user is registered successfully
     * @throws SQLException
     */
    public boolean register() throws SQLException {
        String query = "insert into `user_info` values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,user_id);
        ps.setString(3,email);
        ps.setString(4,pass);
        return ps.execute();
    }
}
