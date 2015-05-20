package core.domain;

public class Users {
	private int id;
	private UserType type;

	public Users(int id, UserType type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public UserType getType() {
		return type;
	}
}
