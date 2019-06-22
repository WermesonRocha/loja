package br.com.loja.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/store/**").allowedOrigins("*").allowCredentials(true).allowedHeaders("Content-Type",
				"Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization", "X-Requested-With")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
		registry.addMapping("/api/public/**").allowedOrigins("*").allowCredentials(true).allowedHeaders("Content-Type",
				"Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization", "X-Requested-With")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
		registry.addMapping("/api/client/**").allowedOrigins("*").allowCredentials(true).allowedHeaders("Content-Type",
				"Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization", "X-Requested-With")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
		registry.addMapping("/api/salesman/**").allowedOrigins("*").allowCredentials(true)
				.allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
						"Authorization", "X-Requested-With")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}

}
