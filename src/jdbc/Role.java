package jdbc;

public class Role {
	private int role_id;
	private String name;
	private String priv;
	public Role(int role_id, String name, String priv) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.priv = priv;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + ", priv=" + priv + "]";
	}
	
	
}


