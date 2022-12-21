package com.login.Dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProduct();
	
	void saveProduct(Product product);
	
	void removeProduct(int pid);

	void modifyById(Product p);

	Product findById(int id);
}
