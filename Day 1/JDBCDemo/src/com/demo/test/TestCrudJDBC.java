package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.service.DeptService;
import com.demo.service.DeptServiceImpl;

public class TestCrudJDBC {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int choice=0;
	DeptService dService=new DeptServiceImpl();
	do {
	System.out.println("1. add new department\n 2. delete the department \n 3. modify department\n");
	System.out.println("4. display all\n 5. display by id \n 6. exit\n");
	System.out.println("choice");
	choice=sc.nextInt();
	switch(choice) {
	case 1:
		dService.addnewDeparment();
		break;
	case 2:
		System.out.println("Enter id:");
		int id=sc.nextInt();
		boolean status=dService.deletebyId(id);
		if(status)
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("Not Found");
		}
		
		break;
	case 3:
		System.out.println("Enter id");
		id=sc.nextInt();
		System.out.println("Enter new name");
		String nm=sc.next();
		System.out.println("Enter location");
		String loc=sc.next();
		status=dService.modifybyId(id,nm,loc);
		if(status)
		{
			System.out.println("Updated Successfully");
		}
		else
		{
			System.out.println("Not Found");
		}
		break;
	case 4:
		List<Department> dlist=dService.getAll();
		if(dlist!=null) {
		dlist.stream().forEach(System.out::println);
		}
		else {
			System.out.println("table is empty");
		}
		break;
	
	case 5:
		System.out.println("enter id");
		id=sc.nextInt();
		Department d=dService.getById(id);
		if(d!=null)
		{
			System.out.println(d);
		}
		else
		{
			System.out.println("Not Found");
		}
		break;
		
	case 6:
		System.out.println("Thank you for visiting ......");
		dService.closeMyConnction();
		break;
		
	}
	}while(choice!=6);
}
}
