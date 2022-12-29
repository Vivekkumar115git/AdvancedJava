package com.demo.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="User77")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String fname;
	private String lname;
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="useraddr77", joinColumns= {@JoinColumn(name="uid")},
	inverseJoinColumns= {@JoinColumn(name="aid")})
	private Set<Address> addrset = new HashSet<>();
	public User() {
		super();
	}
	public User(String fname, String lname, Set<Address> addrset) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.addrset = addrset;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Set<Address> getAddrset() {
		return addrset;
	}
	public void setAddrset(Set<Address> addrset) {
		this.addrset = addrset;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", addrset=" + addrset + "]";
	}
	

}
