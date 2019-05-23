package org.demartino.videosharefe.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.demartino.videosharefe.manager.LoginManager;
import org.demartino.videosharefe.view.Login;
import org.demartino.videosharefe.view.UserAndVideoListContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private LoginManager loginManager;
	
	@RequestMapping(value="/loginSubmit/", method=RequestMethod.POST)
	public ResponseEntity<UserAndVideoListContainer> login(@RequestBody Login login, HttpServletRequest httpServletRequest)
	{
		UserAndVideoListContainer userAndVideoListContainer = loginManager.login(login);
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("username", login.getUsername());
		return new ResponseEntity<UserAndVideoListContainer>(userAndVideoListContainer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login/", method=RequestMethod.GET)
	public ModelAndView login() 
	{
		return new ModelAndView("login", "command", new Login());
	}
}