package br.com.loja.fcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FcsApplication {

	public static void main(String[] args) {

		SpringApplication.run(FcsApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
