package com.ds.sample.crud.inmemory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.springframework.stereotype.Component;

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
            result.add( new UserData(key, data.name, data.eMail));
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
        InternalUserData newEntry = new InternalUserData(userData.getName(), userData.getEmail());
        storage.put(newId, newEntry);
        return new UserData(newId, newEntry.name, newEntry.eMail);
    }

    /**
     * Internal presentation of user data.
     */
    private static class InternalUserData {

        final String name;
        final String eMail;

        InternalUserData(String aName, String anEmail) {
            this.name = aName;
            this.eMail = anEmail;
        }
    }
}
