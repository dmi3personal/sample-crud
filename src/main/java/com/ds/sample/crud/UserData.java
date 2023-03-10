package com.ds.sample.crud;

/**
 * DTO used in persistence model, not intended to send data over network.
 */
public class UserData {

	private final int id;
	private final String name;
	private final String email;

	/**
	 * Creates object filled with data.
	 * @param userId User identifier for the new instance.
	 * @param userName User name for the new instance.
	 * @param userEmail E-mail for the new instance.
	 */
	public UserData(int userId, String userName, String userEmail) {
		this.id = userId;
		this.name = userName;
		this.email = userEmail;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
}
