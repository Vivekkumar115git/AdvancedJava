package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DeptDao {

	void closeMyConnction();

	void insertNewDepartment(Department d);

	List<Department> findAll();

	Department findById(int id);

	boolean removebyId(int id);

	boolean updatebyId(int id, String nm, String loc);

}
