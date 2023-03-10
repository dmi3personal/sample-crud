package com.ds.sample;

/**
 * DTO that represents User stored in the system. This DTO is used in service APIs , not used for data persistence.
 */
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Creates empty object.
     */
    public User() {
    }

    /**
     * Created pre-filled instance.
     * @param newFirstName User's first name.
     * @param newLastName User's last name.
     * @param newEmail User's e-mail
     */
    public User(String newFirstName, String newLastName, String newEmail) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.email = newEmail;
    }

    /**
     * Created pre-filled instance.
     * @param newId User identifier.
     * @param newFirstName User's first name.
     * @param newLastName User's last name.
     * @param newEmail User e-mail address.
     */
    public User(Integer newId, String newFirstName, String newLastName, String newEmail) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.email = newEmail;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int newValue) {
        this.id = newValue;
    }

    public void setEmail(String newValue) {
        this.email = newValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
