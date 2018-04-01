package org.demo;

import java.util.List;
import java.util.logging.Logger;

import org.demo.entity.User;
import org.demo.service.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private UserBusinessService businessService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	Logger logger = Logger.getLogger(LoginController.class.getName());
    
    
    @RequestMapping("/userList")
    public List<User> getStudents(){
    	return businessService.getUsers();
    	
    }
    
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        businessService.insertUser(user);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return "success";
    }
}
