package org.demartino.videosharefe.controller;

import java.util.List;

import org.demartino.videosharefe.manager.UserManager;
import org.demartino.videosharefe.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value="/user/", method=RequestMethod.GET)
	public ModelAndView user() 
	{
		return new ModelAndView("user", "command", new User());
	}
	
	@RequestMapping(value="/addUser/", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			ModelMap model)
			{
				model.addAttribute("username", user.getUsername());
				model.addAttribute("id", user.getId());
				model.addAttribute("email", user.getEmail());
				model.addAttribute("phoneNumber", user.getPhoneNumber());
				model.addAttribute("address", user.getAddress());
				model.addAttribute("age", user.getAge());
			
				userManager.createUser(user); //TODO add check for empty user in User Service
				return "result";
			}
	
	@RequestMapping(value="/updateUser/{username}" , method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user)
	{
		User currentUser = userManager.findUserByUsername(username);
		System.out.println("User Controller: " + currentUser);
		if(currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		User userToBeReturned = userManager.updateUser(user);
		System.out.println("User To Be Returned is: " + userToBeReturned);
		return new ResponseEntity<User>(userToBeReturned, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteUser/{username}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username)
	{
		userManager.deleteUserByUsername(username);
		return new ResponseEntity<Void>(HttpStatus.OK); //TODO implement boolean return in service layer
	}
	
	@RequestMapping(value="/getAllUsers/", method=RequestMethod.GET) 
	public ResponseEntity<List<User>> getAllUsers() 
	{
		List<User> users = userManager.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
}

