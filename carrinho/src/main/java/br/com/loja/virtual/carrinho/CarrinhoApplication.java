package br.com.loja.virtual.carrinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CarrinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}

}
