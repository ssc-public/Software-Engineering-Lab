package ir.selab.tdd.service;

import ir.selab.tdd.domain.User;
import ir.selab.tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public boolean loginWithUsername(String username, String password) {
        User userByUsername = repository.getUserByUsername(username);
        if (userByUsername == null) {
            return false;
        }
        return userByUsername.getPassword().equals(password);
    }

    public boolean loginWithEmail(String username, String password) {
        // TODO: implement login with email. return true if username and password are valid.
        return false;
    }

    public boolean registerUser(String username, String password) {
        User user = new User(username, password);
        return repository.addUser(user);
    }

    public boolean registerUser(String username, String password, String email) {
        User user = new User(username, password);
        user.setEmail(email);
        return repository.addUser(user);
    }

    public boolean removeUser(String username) {
        // TODO: implement
        return false;
    }

    public List<User> getAllUsers() {
        // TODO: implement
        return null;
    }

    public boolean changeUserEmail(String username, String newEmail) {
        // TODO: implement (if user exists and user's email is valid, then change email)
        // TODO: after changing user's email, user must be able to login with new email.
        return false;
    }
}
