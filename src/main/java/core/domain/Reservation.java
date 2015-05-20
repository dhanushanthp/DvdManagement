package core.domain;

public class Reservation {
	private int userId;
	private String title;
	private boolean reserved;
	private boolean delivered;

	public Reservation(int userId, String title, boolean reserved) {
		this.userId = userId;
		this.title = title;
		this.reserved = reserved;
		this.delivered = false;
	}

	public int getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public boolean isReserved() {
		return reserved;
	}

	public boolean isDelivered() {
		return delivered;
	}
}
