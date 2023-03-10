package com.ds.sample;

import java.util.List;

/**
 * Simple user-management interface. 
 */
public interface UserInterface {

    /**
     * Lists all known users.
     * @return Non-null list of users.
     */
    public List<User> list();

    /**
     * Creates a record for a new user. This method shall ignore user's identifier given as the input. 
     * @param user New user to be created in the system. Identifier shall be ignored if given.
     * @return User DTO as created, with generated user identifier.
     * @throws UserManagementException if a user cannot be created.
     */
    public User create(User user) throws UserManagementException;

    /**
     * Updates identified user with new data.
     * @param id Identifier of the user.
     * @param user The user information to be updated.
     * @throws UserManagementException if a user cannot be updated.
     */
    public void update(int id, User user) throws UserManagementException;

    /**
     * Deletes user by it's identifier.
     * @param userId The user to be deleted.
     * @throws UserManagementException if the user could not be deleted.
     */
    public void delete(int userId) throws UserManagementException;
}
