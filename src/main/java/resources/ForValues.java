package resources;

public class ForValues {
	
	String name;
	String rating;
	String duration;
	public ForValues(String name, String rating, String duration) {
		super();
		this.name = name;
		this.rating = rating;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
