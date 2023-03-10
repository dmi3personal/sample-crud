package com.ds.sample.crud.inmemory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.springframework.stereotype.Component;

import com.ds.sample.User;
import com.ds.sample.crud.UserData;
import com.ds.sample.crud.UserStorage;

/**
 * Component that stores User data in memory.
 */
@Component
public class UserDataStorage implements UserStorage {

    private static Map<Integer, InternalUserData> storage = new HashMap<>();

    /**
     * Creates component instance with no data stored.
     */
    public UserDataStorage() {
    }

    /**
     * Reads all elements stored in memory.
     * @return Non-null list of elements.
     */
    public List<UserData> readAll() {
        List<UserData> result = new LinkedList<>();
        storage.keySet().stream().forEach(key -> {
            InternalUserData data = storage.get(key);
            result.add( new UserData(key, data.firstName, data.lastName, data.eMail));
        });
        return result;
    }

    /**
     * Creates new entry in local storage.
     * @param userData User data for the new entry.
     * @return New instance that reflects new data stored locally.
     */
    public UserData createUser(UserData userData) {
        Integer newId;
        OptionalInt maxValue = storage.keySet().stream().mapToInt(value -> value).max();
        if (maxValue.isPresent()) {
            newId = maxValue.getAsInt() + 1;
        } else {
            newId = 1;
        }
        InternalUserData newEntry = new InternalUserData(userData.getFirstName(), userData.getLastName(), userData.getEmail());
        storage.put(newId, newEntry);
        return new UserData(newId, newEntry.firstName, newEntry.lastName, newEntry.eMail);
    }

    /**
     * Checks if given user exists in storage or not.
     */
    @Override
    public boolean userExists(int id) {
        return storage.keySet().stream().anyMatch( key -> key.intValue() == id );
    }

    /**
     * Updates user information using user's id.
     */
    @Override
    public boolean updateUser(int id, User user) {
        InternalUserData data = storage.get(id);
        if (data != null) {
            storage.put(id,  new InternalUserData(user.getFirstName(), user.getLastName(), user.getEmail()));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes information about user specified by id.
     */
    @Override
    public boolean deleteUser(int userId) {
        InternalUserData data = storage.get(userId);
        if (data != null) {
            storage.remove(userId);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Internal presentation of user data.
     */
    private static class InternalUserData {

        final String firstName;
        final String lastName;
        final String eMail;

        InternalUserData(String name, String surname, String anEmail) {
            this.firstName = name;
            this.lastName = surname;
            this.eMail = anEmail;
        }
    }
}
