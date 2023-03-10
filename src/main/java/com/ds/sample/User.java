package com.ds.sample;

/**
 * DTO that represents User stored in the system. This DTO is used in service APIs , not used for data persistence.
 */
public class User {

    private Integer id;
    private String name;
    private String email;

    /**
     * Creates empty object.
     */
    public User() {
    }

    /**
     * Created pre-filled instance.
     * @param newName User name.
     * @param newEmail User e-mail address.
     */
    public User(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

    /**
     * Created pre-filled instance.
     * @param newId User identifier.
     * @param newName User name.
     * @param newEmail User e-mail address.
     */
    public User(Integer newId, String newName, String newEmail) {
        this.id = newId;
        this.name = newName;
        this.email = newEmail;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setId(int newValue) {
        this.id = newValue;
    }

    public void setName(String newValue) {
        this.name = newValue;
    }

    public void setEmail(String newValue) {
        this.email = newValue;
    }
}
