package users;

public class Doctor {
	
	private String name;
    private String deptname;
    private String sex;
    private Integer id;
    private String acount;    
	public Doctor() {
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return acount;
	}
	public void setType(String type) {
		this.acount = type;
	}	
}
