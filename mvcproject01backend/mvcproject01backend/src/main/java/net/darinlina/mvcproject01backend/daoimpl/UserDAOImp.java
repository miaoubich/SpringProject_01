package net.darinlina.mvcproject01backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.darinlina.mvcproject01backend.dao.UserDAO;
import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImp implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImp.class);

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			logger.error("addUser: ", e);
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			logger.error("addAddress: ", e);
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			logger.error("addCart: ", e);
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class)
						.setParameter("email", email).getSingleResult();
		}catch(Exception e) {
			logger.error("getByEmail", e.getMessage());
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user", user).setParameter("billing", true)
					.getSingleResult();
		} catch (Exception e) {
			logger.error("getBillingAddress", e.getMessage());
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("shipping", true)
					.getResultList();
		} catch (Exception e) {
			logger.error("listShippingAddresses", e.getMessage());
			return null;
		}
	}

}
