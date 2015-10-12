package cn.com.zzn.common.models;

/**
 * Created by cmwin on 10/10/15.
 */
public class Account implements java.io.Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
