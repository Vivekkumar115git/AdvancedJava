package com.demo.service;

import java.util.List;

import com.demo.beans.Department;

public interface DeptService {

	void closeMyConnction();

	void addnewDeparment();

	List<Department> getAll();

	Department getById(int id);

	boolean deletebyId(int id);

	boolean modifybyId(int id, String nm, String loc);

}
