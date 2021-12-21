package databaseManager.userManager;

import databaseManager.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authorise {
    private String user_id;
    private String email;
    private String pass;
    private String name;
    private Connection con;
    private boolean auth;
    public Authorise() throws SQLException {
        user_id = null;
        name = null;
        email = null;
        auth = false;
        con = DatabaseConnection.getInstance();
    }

    public boolean authorise_by_mail(String email, String pass) throws SQLException {
        String query = "select * from `user_info` where email = (?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String server_pass = rs.getString(4);
            if(!pass.equals(server_pass)) return auth=false;
            this.pass = server_pass;
            this.name = rs.getString(1);
            this.user_id = rs.getString(2);
            this.email = rs.getString(3);
        }
        if(name==null) return auth = false;
        return auth=true;
    }

    public boolean authorise_by_id(String id, String pass) throws SQLException {
        String query = "select * from `user_info` where `user_id` = (?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String server_pass = rs.getString(4);
            if(!pass.equals(server_pass)) return auth=false;
            this.pass = server_pass;
            this.name = rs.getString(1);
            this.user_id = rs.getString(2);
            this.email = rs.getString(3);
        }
        if(name==null) return auth=false;
        return auth=true;
    }

    public boolean isAuthorised() {
        return auth;
    }

    public String getName() {
        if(auth) return name;
        return "Error: Unauthorised Access\n";
    }

    public String getEmail() {
        if(auth) return email;
        return "Error: Unauthorised Access\n";
    }

    public String getUser_id() {
        if(auth) return user_id;
        return "Error: Unauthorised Access\n";
    }

    public UserInfo getSerializedInfo(){
        return new UserInfo(this.name,this.email,this.user_id);
    }
}
