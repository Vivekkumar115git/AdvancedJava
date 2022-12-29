package com.demo.beans;

import java.util.HashSet;
import java.util.Set;
import com.demo.beans.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Address77")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	private String street;
	private String city;
	private String state;
	@ManyToMany(mappedBy="addrset", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> userset = new HashSet<>();
	public Address() {
		super();
	}
	public Address(String street, String city, String state, Set<User> userset) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.userset = userset;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public Set<User> getUserset() {
		return userset;
	}
	public void setUserset(Set<User> userset) {
		this.userset = userset;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
