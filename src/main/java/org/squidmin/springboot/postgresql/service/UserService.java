package org.squidmin.springboot.postgresql.service;

import org.springframework.stereotype.Service;
import org.squidmin.springboot.postgresql.exception.UserNotFoundException;
import org.squidmin.springboot.postgresql.model.User;
import org.squidmin.springboot.postgresql.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

}
