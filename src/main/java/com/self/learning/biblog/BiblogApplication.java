package com.self.learning.biblog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.self.learning.biblog.models.User;
import com.self.learning.biblog.repositories.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
public class BiblogApplication {

	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BiblogApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepo) {
//		String password = passwordEncoder().encode("123456");
//		return args -> userRepo.save(new User("Nguyen Viet Nguyen", "nguyenvietnguyen.muaxuan@gmail.com", "nguyennv", password, 0, ""));
//	}

}
