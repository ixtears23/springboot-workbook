package com.ibdata.mvc.negotiation.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

// @XmlRootElement : Jaxb2Marshaller가 Java 객체를 XML 요소에 매핑하는 데 필요합니다.
@XmlRootElement
public class Student {
	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
