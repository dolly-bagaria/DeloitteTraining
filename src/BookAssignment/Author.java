package BookAssignment;

public class Author {
	private int author_id;
	private String name;
	private String nationality;
	
	public Author(int author_id, String name, String nationality) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.nationality = nationality;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", name=" + name + ", nationality=" + nationality + "]";
	}
	
	
}
