package crud;

import com.ds.sample.User;
import com.ds.sample.UserInterface;
import com.ds.sample.UserManagementException;

public class UserService implements UserInterface {

    /**
     * Creates new instance of the service.
     */
    public UserService() {
    }

    public User create(User user) throws UserManagementException {
        throw new UserManagementException("Not yet supported");
    }

    public void update(User user) throws UserManagementException {
        throw new UserManagementException("Not yet supported");
    }

    public void delete(int userId) throws UserManagementException {
        throw new UserManagementException("Not yet supported");
    }
}
