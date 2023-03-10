package crud;

/**
 * DTO used in persistence model, not intended to send data over network.
 */
public class UserData {

	private final int id;
	private final String name;
	private final String email;

	/**
	 * Creates object filled with data.
	 * @param newId User identifier for the new instance.
	 * @param newName User name for the new instance.
	 * @param newEmail E-mail for the new instance.
	 */
	public UserData(int newId, String newName, String newEmail) {
		this.id = newId;
		this.name = newName;
		this.email = newEmail;
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
