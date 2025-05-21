package org.example.casestudy.service.customer;

import org.example.casestudy.model.Media;
import org.example.casestudy.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    User getUserByEmail(String email);
    void handleMediaFavorite(User user, Media media);
}
