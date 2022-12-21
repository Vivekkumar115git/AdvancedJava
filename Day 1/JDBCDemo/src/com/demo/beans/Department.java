package com.demo.beans;

public class Department {
   private int deptid;
   private String dname;
   private String loc;
   
public Department() {
	super();
}

public Department(int deptid, String dname, String loc) {
	super();
	this.deptid = deptid;
	this.dname = dname;
	this.loc = loc;
}

public int getDeptid() {
	return deptid;
}

public void setDeptid(int deptid) {
	this.deptid = deptid;
}

public String getDname() {
	return dname;
}

public void setDname(String dname) {
	this.dname = dname;
}

public String getLoc() {
	return loc;
}

public void setLoc(String loc) {
	this.loc = loc;
}

@Override
public String toString() {
	return "Department [deptid=" + deptid + ", dname=" + dname + ", loc=" + loc + "]";
}
   
}
