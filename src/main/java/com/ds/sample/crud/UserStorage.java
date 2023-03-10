package com.ds.sample.crud;

import java.util.List;

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
     * @return USer data as stored in this storage.
     */
    public UserData createUser(UserData userData);
}
