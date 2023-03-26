package br.com.loja.virtual.times;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesApplication.class, args);
	}

}
