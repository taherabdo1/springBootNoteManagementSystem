package practise.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import practise.springBoot.model.User;
import dao.UserDao;
import resources.RestConfig;

@Configuration
@Import({ RestConfig.class, UserDao.class, User.class })
@SpringBootApplication

//this is the default, spring boot will scan all the sub-packages to find
//entities and beans, otherwise use this annotatioon to address the
//basepackages you need to scan
@ComponentScan(basePackages = "practise.springBoot.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
