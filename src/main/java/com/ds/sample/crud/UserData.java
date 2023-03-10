package com.ds.sample.crud;

/**
 * DTO used in persistence model, not intended to send data over network.
 */
public class UserData {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;

    /**
     * Creates object filled with data.
     * @param userId User identifier for the new instance.
     * @param userFirstName User's first name.
     * @param userLastName User's last name.
     * @param userEmail E-mail for the new instance.
     */
    public UserData(int userId, String userFirstName, String userLastName, String userEmail) {
        this.id = userId;
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.email = userEmail;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
