package core.domain;

public class DVDMeta {
	private String title;
	private String year;
	private String actors;
	private int imdbRating;
	private String format;

	private Inventory inventory;

	public DVDMeta(String title, String year, String actors, int imdbRating, String format) {
		this.title = title;
		this.year = year;
		this.actors = actors;
		this.imdbRating = imdbRating;
		this.format = format;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getActors() {
		return actors;
	}

	public int getImdbRating() {
		return imdbRating;
	}

	public String getFormat() {
		return format;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
