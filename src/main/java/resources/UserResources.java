package resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/api/users")
public class UserResources {

	@RequestMapping(method = RequestMethod.GET, value="/test")
	public String testService(){
		return "test successfully";
	}
}
