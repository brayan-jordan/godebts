package br.com.godebts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GodebtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodebtsApplication.class, args);
	}
 
}
