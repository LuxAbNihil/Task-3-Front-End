package org.demartino.videosharefe.manager;

import java.util.List;

import org.demartino.videosharefe.view.User;

public interface UserManager {
	User createUser(User user);
	boolean deleteUserByUsername(String username);
	User updateUser(User user);
	User findUserByUsername(String username);
	List<User> getAllUsers();
}
