package com.ibs.controller;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibs.model.User;
import com.ibs.util.Constants;

/**
 * 
 * @author Sumya
 *
 */
@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class.getName());

	/**
	 * Returns ModelAndView to view login.jsp. It will show user login page with
	 * "/" or login URL
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView modelAndViewLogin = null;
		try {

			modelAndViewLogin = new ModelAndView();
			modelAndViewLogin.setViewName("login");

		} catch (Exception exception) {

			logger.error(Constants.ERROR, exception);
		}
		return modelAndViewLogin;
	}

	/**
	 * Returns ModelAndView to view bookingdetails.jsp. It will show
	 * BookingDetails page after spring security checks for login authentication.
	 *
	 * @param error
	 * @param logout
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	public ModelAndView loginProcess(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView();
			System.out.println("error" + error);
			if (error != null) {
				modelAndView.setViewName("login");
				modelAndView.addObject("loginObject", new User());
				modelAndView.addObject("message", "Invalid username or password!");
				return modelAndView;
			}
			if (logout != null) {
				modelAndView.setViewName("login");
				modelAndView.addObject("loginObject", new User());
				modelAndView.addObject("message", "You've been logged out successfully.");
				return modelAndView;
			}

			UserDetails userDetail = null;
			Authentication authenticater = SecurityContextHolder.getContext().getAuthentication();
			if (authenticater instanceof AnonymousAuthenticationToken) {
				return checkUserAllowedUsingSpringSecurity();
			} else {
				userDetail = (UserDetails) authenticater.getPrincipal();
			}
				modelAndView.setViewName("flightsearch");

			return modelAndView;
		} catch (Exception exception) {

			logger.error(Constants.ERROR, exception);

			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message",
					"Error Occured While Processing Your Request. Please Try Again.");
		}

		return modelAndView;
	}

	/**
	 * Returns ModelAndView to view login.jsp.
	 */
	private ModelAndView checkUserAllowedUsingSpringSecurity() {
		ModelAndView modelAndViewobjectforbookingdetailslist = new ModelAndView();

		modelAndViewobjectforbookingdetailslist.setViewName("login");
		modelAndViewobjectforbookingdetailslist.addObject("loginObject", new User());
		modelAndViewobjectforbookingdetailslist.addObject("message", "Please login!");
		return modelAndViewobjectforbookingdetailslist;
	}
}