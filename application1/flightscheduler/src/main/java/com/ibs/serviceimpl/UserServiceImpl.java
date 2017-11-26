package com.ibs.serviceimpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.dao.UserDao;
import com.ibs.model.User;
import com.ibs.service.UserService;
import com.ibs.util.Constants;

/**
 * 
 * @author Sumya
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	UserDao userDao;

	@Transactional
	public Integer register(User user) {
		Integer id = 0;
		try {
			id = userDao.register(user);
		} catch (Exception exception) {
			logger.error(Constants.ERROR, exception);
		}
		return id;
	}

}
