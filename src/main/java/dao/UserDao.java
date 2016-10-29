package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import practise.springBoot.model.User;

@Component()
public class UserDao {

	@Autowired
	EntityManager entityManager;
	
	public List<User> selectAll(){
		List<User> users = null;
		System.out.println("before slection");
		users = (List<User>)entityManager.createQuery("Select s From "+User.class.getSimpleName()+" s").getResultList();
		System.out.println("after slection");		
		return users;
	}
}
