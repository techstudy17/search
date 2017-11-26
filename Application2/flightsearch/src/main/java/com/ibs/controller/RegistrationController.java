package com.ibs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibs.model.User;
import com.ibs.service.UserService;
import com.ibs.util.Constants;
import com.ibs.util.URLNamingConstants;

/**
 * 
 * @author Sumya
 *
 */
@Controller
public class RegistrationController {

	private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

	@Autowired
	public UserService userService;


	/**
	 * Returns ModelAndView to view registration.jsp. It will show registration
	 * page.
	 *
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = URLNamingConstants.REGISTER_USER, method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndViewForRegister = null;
		try {

			modelAndViewForRegister = new ModelAndView("register");
			modelAndViewForRegister.addObject("userRegistrationObject", new User());

		} catch (Exception exception) {
			logger.error(Constants.ERROR, exception);
		}
		return modelAndViewForRegister;
	}

	/**
	 * Returns ModelAndView to view login.jsp. It will show success registration
	 * on login page.
	 *
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = URLNamingConstants.REGISTER_PROCESS, method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userRegistrationObject") User user) {

		ModelAndView modelAndViewForRegistration = null;
		try {

			if (user != null) {

				userService.register(user);

				modelAndViewForRegistration = new ModelAndView("login");
				modelAndViewForRegistration.addObject("message", "Registered Successfully! Please login.");
				return modelAndViewForRegistration;
			}
			return modelAndViewForRegistration;
		} catch (Exception exception) {
			logger.error(Constants.ERROR, exception);
			modelAndViewForRegistration = new ModelAndView("register");
			modelAndViewForRegistration.addObject("message",
					"User name already exist! Please try with different username");
			return modelAndViewForRegistration;
		}

	}
}
