package net.darinlina.mvcproject01backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.darinlina.mvcproject01backend.dao.CartLineDAO;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpli implements CartLineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(CartLineDAOImpli.class);

	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception e) {
			logger.error("Add Cart failed ! ", e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception e) {
			logger.error("Update Cart failed ! ", e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		} catch (Exception e) {
			logger.error("Delete Cart failed ! ", e.getMessage());
			return false;
		}
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
				.createQuery(query, CartLine.class)
					.setParameter("cartId", cartId)
						.getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
				.createQuery(query, CartLine.class)
					.setParameter("cartId", cartId)
					.setParameter("available", true)
						.getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		try {
			String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
			return sessionFactory.getCurrentSession()
					.createQuery(query, CartLine.class)
						.setParameter("cartId", cartId)
						.setParameter("productId", productId)
							.getSingleResult();
		} catch (Exception e) {
			logger.error("Product is not in the cart ! ", e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			logger.error("addCart or update it: ", e);
			return false;
		}
	}

}
