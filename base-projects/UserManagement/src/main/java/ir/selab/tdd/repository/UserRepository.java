package ir.selab.tdd.repository;

import ir.selab.tdd.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    private final Map<String, User> usersByUserName;
    private final Map<String, User> usersByEmail;

    public UserRepository(List<User> users) {
        this.usersByUserName = users.stream().collect(Collectors.toMap(User::getUsername, u -> u, (u1, u2) -> {
            throw new IllegalArgumentException("Two users can not have the same username");
        }));

        // TODO: implement (Some users may not have email!)
        this.usersByEmail = new HashMap<>();
    }

    public User getUserByUsername(String username) {
        return usersByUserName.get(username);
    }

    public User getUserByEmail(String email) {
        // TODO: implement
        return null;
    }

    public boolean addUser(User user) {
        if (usersByUserName.containsKey(user.getUsername())) {
            return false;
        }
        // TODO: implement check email duplication
        usersByUserName.put(user.getUsername(), user);
        return true;
    }

    public boolean removeUser(String username) {
        // TODO: implement
        return false;
    }

    public int getUserCount() {
        return usersByUserName.size();
    }
}
