package org.example.casestudy.service.customer;

import org.example.casestudy.model.Media;
import org.example.casestudy.model.User;
import org.example.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null) ;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getFirstByEmail(email);
    }

    @Override
    public void handleMediaFavorite(User user, Media media) {
        Set<Media> favourite = user.getFavoriteMedia();
        if (favourite.contains(media)) favourite.remove(media);
        else favourite.add(media);

        user.setFavoriteMedia(favourite);
        userRepository.save(user);
    }
}