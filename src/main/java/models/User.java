package models;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String profilePic;

    public User(String username, String email, String password, String bio, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePic = profilePic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
}
