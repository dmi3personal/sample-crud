package com.ds.sample.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ds.sample.User;
import com.ds.sample.UserInterface;
import com.ds.sample.UserManagementException;

@Component
public class UserService implements UserInterface {

    @Autowired
    private UserDataStorage storage;

    /**
     * Creates new instance of the service.
     */
    public UserService() {
    }

    @Override
    public List<User> list() throws UserManagementException {
        storage.readAll();
        // TODO Auto-generated method stub
        return null;
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

    public void update(User user) throws UserManagementException {
        throw new UserManagementException("Not yet supported");
    }

    public void delete(int userId) throws UserManagementException {
        throw new UserManagementException("Not yet supported");
    }
}
