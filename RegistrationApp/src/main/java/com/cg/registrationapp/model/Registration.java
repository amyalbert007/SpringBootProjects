package com.cg.registrationapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="RegistrationInfo")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regId;
	
	@Column
	private String name;
	private Integer age;
	private Long mobileNo;
	private String city;
	private String state;
	private Integer pin;
	private String country;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(Integer regId, String name, Integer age, Long mobileNo, String city, String state, Integer pin,
			String country) {
		super();
		this.regId = regId;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Registration [regId=" + regId + ", name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", city="
				+ city + ", state=" + state + ", pin=" + pin + ", country=" + country + "]";
	}
	

}
