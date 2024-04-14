package com.jbkAcademy.Angular.with.spring.boot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	SessionFactory factory;
	
	
	@PostMapping("validate")
	public boolean validate(@RequestBody User userFromBrouser) {
		
		System.out.println("user from browser="+userFromBrouser);
		Session ss=factory.openSession();
		User userFromDatabase=ss.get(User.class,userFromBrouser.getUsername())	;
		System.out.println("user from database="+userFromDatabase);
boolean answer=	userFromBrouser.equals(userFromDatabase);
System.out.println("answer from equals() methods of object class="+answer);
return answer;
	}
	
}
