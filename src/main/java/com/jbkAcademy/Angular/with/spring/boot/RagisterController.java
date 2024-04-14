package com.jbkAcademy.Angular.with.spring.boot;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class RagisterController {

	@Autowired
	SessionFactory sf;
	
	@PostMapping("savedata")
	public void savedata(@RequestBody User user) {
		System.out.println(user);
    Session session=sf.openSession();
    Transaction tr=session.beginTransaction();
    session.persist(user);
    tr.commit();	
	}
	
	 @GetMapping("getUser/{username}")
	    public User getUser(@PathVariable String username) {
	    	Session s1=sf.openSession();
	    	Transaction tr=s1.beginTransaction();
	    	
	    	User uu=s1.get(User.class, username);
	    	tr.commit();
	    	System.out.println(uu);

	    	return uu;
	    	}
	 
	 @DeleteMapping("deleteUser/{username}") 
	 public  ResponseEntity<Boolean> deleteUser(@PathVariable String username) {
		try {
			 Session s2=sf.openSession();
			 Transaction tr=s2.beginTransaction();
			 User user=s2.get(User.class, username);
			 s2.delete(user);
			 tr.commit();
			 System.out.println(user);
			 ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true,HttpStatus.OK);
			 return responseEntity;
		}catch(Exception e) {
			
			 ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			 return responseEntity;

		}
	 }
	 
	 @GetMapping("getAllUsers")
	 
	 public List<User> getAllUsers() {
		 
		 Session s3=sf.openSession();
		 
	return s3.createQuery("from User").list();	
	
	 }
}
















