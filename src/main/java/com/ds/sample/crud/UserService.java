package com.ds.sample.crud;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ds.sample.User;
import com.ds.sample.UserInterface;
import com.ds.sample.UserManagementException;

/**
 * Implementation of UserInterface that uses in-memory storage.
 */
@Component
public class UserService implements UserInterface {

    @Autowired
    private UserStorage storage;

    /**
     * Creates new instance of the service.
     */
    public UserService() {
    }

    /**
     * Returns list of all users registered in storage.
     */
    @Override
    public List<User> list() {
        List<User> result = storage.readAll().stream()
                .map( user -> new User( user.getId(), user.getName(), user.getEmail() ) )
                .collect(Collectors.toList());
        return result;
    }

    /**
     * Creates a new user and stores it in the internal storage.
     */
    public User create(User user) throws UserManagementException {
        // a developer shall not call this method with "null" argument. Thus NPE is okay for that error case.
        if (user.getName() == null) {
            throw new UserManagementException("User name must be specified."); // e-mail is optional.
        }
        UserData newUser = storage.createUser(new UserData(0, user.getName(), user.getEmail()));
        if (newUser != null) {
            User result = new User();
            result.setId(newUser.getId());
            result.setName(newUser.getName());
            result.setEmail(newUser.getEmail());
            return result;
        } else {
            throw new UserManagementException("Cannot create user " + user.getName());
        }
    }

    /**
     * Updates information about known user.
     */
    public void update(int id, User user) throws UserManagementException {
        // a developer shall not call this method with "null" argument. Thus NPE is okay for that error case.
        if (user.getName() == null ) {
            throw new UserManagementException("User name must be specified."); // e-mail is optional.
        }
        if (!storage.updateUser(id, user)) {
            throw new UserManagementException("Unknown user " + id);
        }
    }

    /**
     * Deletes information about known user.
     */
    public void delete(int userId) throws UserManagementException {
        if (storage.userExists(userId) ) {
            storage.deleteUser(userId);
        } else {
            throw new UserManagementException("Unknown user " + userId);
        }
    }
}
