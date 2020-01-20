package net.darinlina.mvcproject01backend;

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

	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("FOOD");
		category.setDescription("This is what call it deleciouse");
		category.setImageURL("CAT_1.png");

		Assert.assertTrue(categoryDAO.add(category));
	}
}
