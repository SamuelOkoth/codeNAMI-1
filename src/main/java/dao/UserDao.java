package dao;

import models.Challenges;
import models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User findById(int userId);
    void updateUsers(int id, String username, String email, String password, String bio, String profilePic);
}
