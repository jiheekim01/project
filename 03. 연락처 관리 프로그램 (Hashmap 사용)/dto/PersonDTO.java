package contactMVC.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNumber;
	private String address;
	private String relationship;

	public PersonDTO(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PersonDTO(String name, String address, String relationship) {
		this.name = name;
		this.address = address;
		this.relationship = relationship;
	}

	public PersonDTO(String name, String phoneNumber, String address, String relationship) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.relationship = relationship;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "(이름 = " + getName() + ", 전화번호 : " + getPhoneNumber() + ", 주소 : " + getAddress() + ", 관계 : "
				+ getRelationship() + ')' + '\n';
	}
}
