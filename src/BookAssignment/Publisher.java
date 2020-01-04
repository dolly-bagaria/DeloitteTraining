package BookAssignment;

public class Publisher {
	private int publisher_id;
	private String name;
	private String city;
	public Publisher(int publisher_id, String name, String city) {
		super();
		this.publisher_id = publisher_id;
		this.name = name;
		this.city = city;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
