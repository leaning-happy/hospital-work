package users;

public class Patient {

	private String name;
	private Long phoneNumber;
	private String sex;
	private String acount;
	public Patient() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return acount;
	}

	public void setType(String type) {
		this.acount = type;
	}
	
}
