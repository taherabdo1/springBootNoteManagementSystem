package practise.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import practise.springBoot.entities.User;
import resources.RestConfig;

@Configuration
@Import({ RestConfig.class, User.class })
@SpringBootApplication

//this is the default, spring boot will scan all the sub-packages to find
//entities and beans, otherwise use this annotatioon to address the
//basepackages you need to scan
@ComponentScan(basePackages = "")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
