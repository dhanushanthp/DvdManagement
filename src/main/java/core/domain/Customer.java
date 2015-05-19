package core.domain;

import java.util.List;

public class Customer {
	private int id;
	private List<DVDMeta> reserved;
	private List<DVDMeta> collected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<DVDMeta> getReserved() {
		return reserved;
	}

	public void setReserved(List<DVDMeta> reserved) {
		this.reserved = reserved;
	}

	public List<DVDMeta> getCollected() {
		return collected;
	}

	public void setCollected(List<DVDMeta> collected) {
		this.collected = collected;
	}
}
