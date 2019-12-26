package Assignment;

public class Department {
	String name;
	protected String location;

	public Department(String name, String location) {
		super();
		this.name=name;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + "]";
	}

}
