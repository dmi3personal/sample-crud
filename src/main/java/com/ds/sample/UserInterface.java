package com.ds.sample;

/**
 * Simple user-management interface. 
 */
public interface UserInterface {

    /**
     * Creates a record for a new user. This method shall ignore user's identifier given as the input. 
     * @param user New user to be created in the system. Identifier shall be ignored if given.
     * @return User DTO as created, with generated user identifier.
     * @throws UserManagementException if cannot create a new user.
     */
    public User create(User user) throws UserManagementException;

    /**
     * Updates identified user with new data.
     * @param user The user information to be updated.
     * @throws UserManagementException if cannot update a user, i.e. user is unknown.
     */
    public void update(User user) throws UserManagementException;

    /**
     * Deletes user by it's identifier.
     * @param userId The user to be deleted.
     * @throws UserManagementException if cannot delete a user.
     */
    public void delete(int userId) throws UserManagementException;
}
