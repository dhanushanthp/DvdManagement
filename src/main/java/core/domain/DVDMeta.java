package core.domain;

import java.util.List;

public class DVDMeta {
	private String title;
	private int year;
	private List<Actor> actors;
	private int imdbRating;
	private FORMAT format;

	private Inventory inventory;

	public DVDMeta(String title, int year, List<Actor> actors, int imdbRating, FORMAT format) {
		this.title = title;
		this.year = year;
		this.actors = actors;
		this.imdbRating = imdbRating;
		this.format = format;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public int getImdbRating() {
		return imdbRating;
	}

	public FORMAT getFormat() {
		return format;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
