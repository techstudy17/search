package com.ibs.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibs.dao.UserDao;
import com.ibs.model.User;
import com.ibs.model.UserRole;
import com.ibs.util.Constants;
/**
 * 
 * @author Sumya
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class.getName());
		
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Integer register(User user){
		Integer id = 0;
		try {
		Session session = this.sessionFactory.getCurrentSession();
		 id = (Integer) session.save(user);
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUsername(user.getUsername());
		session.save(userRole);
		} catch (Exception exception) {
			logger.error(Constants.ERROR, exception);
		}
		return id;
	}
}