package resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.UserDao;


@RestController
//@RequestMapping("/api/users")
public class UserResources {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(method = RequestMethod.GET, value="/test")
	public String testService(){
		
		return "test successfully, found "+userDao.selectAll().size()+" users";
	}
}
