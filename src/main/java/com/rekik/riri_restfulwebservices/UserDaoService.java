package com.rekik.riri_restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int  usersCount = 3;
	
	static {
		users.add(new User(1, "Rekik", new Date()));
		users.add(new User(2, "Vikasita", new Date()));
		users.add(new User(3, "Vikram", new Date()));
	}
	
	public List<User> findAll(){
		return users;
		
	}

	public User save(User user) {
		if(user.getIdInteger()==null)
			user.setIdInteger(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getIdInteger() == id){
				return user;
			}

		}
		
		return null;
		
	}

	public User deleteById(int id){
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()){
			User user = iterator.next();
			if(user.getIdInteger() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}



}
