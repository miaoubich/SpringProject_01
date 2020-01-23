package net.darinlina.mvcproject01backend;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.darinlina.mvcproject01backend.dao.CategoryDAO;
import net.darinline.mvcproject01backend.dto.Category;

public class CategoryTest {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.darinlina.mvcproject01backend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

//	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("DESSERT");
		category.setDescription("Pudding od vanilja!");
		category.setImageURL("CAT_4.png");

		Assert.assertTrue(categoryDAO.add(category));
	}

//	@Test
	public void testgetCategory() {

		category = categoryDAO.get(2);
		System.out.println("category.getName(): " + category.getName());
		assertEquals("Beverages", category.getName());
	}

//	@Test
	public void testEditCategory() {

		category = categoryDAO.get(2);
		category.setName("DRINKS");
		Assert.assertTrue(categoryDAO.update(category));
	}

//	@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(2);
		Assert.assertTrue(categoryDAO.delete(category));
	}

	@Test
	public void testGetList() {
		System.out.println("categoryDAO.List(): " + categoryDAO.List().size());
		assertEquals(categoryDAO.List().size(), 2);
	}

}
