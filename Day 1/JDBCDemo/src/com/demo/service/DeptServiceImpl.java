package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.dao.DeptDao;
import com.demo.dao.DeptDaoImpl;

public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao;

	public DeptServiceImpl() {
		super();
		this.deptDao = new DeptDaoImpl();
	}

	@Override
	public void closeMyConnction() {
		deptDao.closeMyConnction();
		
	}

	@Override
	public void addnewDeparment() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter department id");
		int id=sc.nextInt();
		System.out.println("enter department name");
		String nm=sc.next();
		System.out.println("enter department location");
		String loc=sc.next();
		Department d=new Department(id,nm,loc);
		deptDao.insertNewDepartment(d);
		
	}

	@Override
	public List<Department> getAll() {
		return deptDao.findAll();
	}

	@Override
	public Department getById(int id) {
		return deptDao.findById(id);
	}

	@Override
	public boolean deletebyId(int id) {
		return deptDao.removebyId(id);
	}

	@Override
	public boolean modifybyId(int id, String nm, String loc) {
		return deptDao.updatebyId(id,nm,loc);
	}
	

}
