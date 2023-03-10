package com.ds.sample.crud;

import java.util.List;

import com.ds.sample.User;

/**
 * Interface for components that actually store data.
 */
public interface UserStorage {

    /**
     * Returns all known users stored in this storage.
     * @return Non-null list of users.
     */
    public List<UserData> readAll();

    /**
     * Creates and stores new user in the storage.
     * @param userData Non-null data about new user to store.
     * @return User data as stored in this storage.
     */
    public UserData createUser(UserData userData);

    /**
     * Updates information on existing user.
     * @param id Identified of the user.
     * @param user New information about existing user.
     * @return <code>true</code> if update is successful.
     */
    public boolean updateUser(int id, User user);

    /**
     * Deletes information about existing user.
     * @param userId Identified of the user.
     * @return <code>true</code> if user is successfully deleted.
     */
    public boolean deleteUser(int userId);

    /**
     * Checks if user with specific ID exist or not.
     * @param id Identifier of the user.
     * @return <code>true</code> for existing user, <code>false</code> for unknown.
     */
    public boolean userExists(int id);
}
