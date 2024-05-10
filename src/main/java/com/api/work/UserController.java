package com.api.work;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;
	
	@GetMapping(path="/users")
	public List<User> getUserList() {
        List<User> questionList = this.userService.getList();
		return questionList;
	} 
	
	@PostMapping(path="/adduser")
	public User addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return user;
	}

	@PostMapping(path="/updateuser/{id}")
	public Integer updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User myuser = this.userService.getUser(id);
        if(myuser != null) {
        	this.userService.updateUser(myuser, user.getName());
        }
        return id;
	}
	
	@PostMapping(path="/deleteuser/{id}")
	public Integer deleteUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User myuser = this.userService.getUser(id);
        if(myuser != null) {
        	this.userService.deleteUser(myuser);
        }
        return id;
	}
}
