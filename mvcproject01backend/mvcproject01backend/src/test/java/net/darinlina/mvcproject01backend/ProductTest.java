package net.darinlina.mvcproject01backend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.darinlina.mvcproject01backend.dao.ProductDAO;
import net.darinline.mvcproject01backend.dto.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.darinlina.mvcproject01backend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

//	@Test
	public void CRUDProductTest() {
		product = new Product();

		product.setName("Test1");
		product.setBrand("TestBrand");
		product.setDescription("Test description!");
		product.setUnitPrice(29);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(1);

		Assert.assertTrue(productDAO.add(product));

		product = productDAO.get(8);
		product.setActive(false);
		Assert.assertTrue(productDAO.update(product));

		// Fetch the list
		Assert.assertEquals(productDAO.List().size(), 7);
		System.out.println("Liste size is: " + productDAO.List().size());

	}

//	@Test
	public void deactivateProduct() {
		product = productDAO.get(8);
		product.setActive(false);
		Assert.assertTrue(productDAO.update(product));
	}

//	@Test
	public void listOfActiveProductTest() {
		Assert.assertEquals(productDAO.listActiveProducts().size(), 5);
		System.out.println("Active product liste size has: " + productDAO.listActiveProducts().size() + " product(s)");
	}

//	@Test
	public void listActiveProductsByCategory() {
		Assert.assertEquals(productDAO.listActiveProductsByCategory(2).size(), 2);
		System.out.println("Lis of Active Products By Category: " + productDAO.listActiveProductsByCategory(2).size()
				+ " product(s)");
	}
	
	@Test
	public void listOfLsterProducts() {
		Assert.assertEquals(productDAO.getLatestActiveProducts(4).size(), 4);
	}
}
