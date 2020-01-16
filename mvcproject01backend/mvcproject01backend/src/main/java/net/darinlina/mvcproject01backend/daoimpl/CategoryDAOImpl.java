package net.darinlina.mvcproject01backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.darinlina.mvcproject01backend.dao.CategoryDAO;
import net.darinline.mvcproject01backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		category.setId(1);
		category.setName("Food");
		category.setDescription("Bio hrana !");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		Category category1 = new Category();

		category1.setId(2);
		category1.setName("Drinks");
		category1.setDescription("Bio drinks !");
		category1.setImageURL("CAT_2.png");

		categories.add(category1);

		Category category2 = new Category();

		category2.setId(3);
		category2.setName("Beverage");
		category2.setDescription("Bio other Beverages !");
		category2.setImageURL("CAT_3.png");

		categories.add(category2);
	}

	@Override
	public List<Category> List() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories) {
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
