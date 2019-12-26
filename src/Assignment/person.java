package Assignment;

public class person {

	protected String name;
	protected Address addr;
	
	public person(String name, Address addr) {
		super();
		this.name = name;
		this.addr = addr;
	}
	public person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", addr=" + addr + "]";
	}
	
	

}
