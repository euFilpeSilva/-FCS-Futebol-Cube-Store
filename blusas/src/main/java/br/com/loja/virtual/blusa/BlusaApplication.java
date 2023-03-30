package br.com.loja.virtual.blusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlusaApplication {

//	@Configuration
//	public class WebClientConfig {

//		@Bean
//		public WebClient.Builder loadBalancedWebClientBuilder() {
//			return WebClient.builder();
//		}
//
//		@Bean(name = "webClientTimes")
//		public WebClient webClientTimes(WebClient.Builder builder) {
//			return builder
//					.baseUrl("http://localhost:8081")
//					.build();
//		}
//	}
	public static void main(String[] args) {
		SpringApplication.run(BlusaApplication.class, args);
	}
}
