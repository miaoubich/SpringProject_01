package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Product;

public interface ProductDAO {

	Product get(int productId);

	List<Product> List();

	boolean add(Product category);

	boolean update(Product category);

	boolean delete(Product category);

	// business methods
	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLatestActiveProducts(int count);
}
