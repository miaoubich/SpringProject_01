package net.darinlina.mvcproject01backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.darinlina.mvcproject01backend.dao.ProductDAO;
import net.darinline.mvcproject01backend.dto.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public java.util.List<Product> List() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
