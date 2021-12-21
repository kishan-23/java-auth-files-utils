package databaseManager.userManager;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String user_id;
    private String email;
    private String name;

    public UserInfo(String name, String email, String user_id){
        this.name = name;
        this.user_id = user_id;
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
