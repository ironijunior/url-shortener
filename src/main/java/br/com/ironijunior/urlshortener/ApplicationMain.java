package br.com.ironijunior.urlshortener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApplicationMain extends SpringBootServletInitializer {

	/**
	 * Start via Spring Boot
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ApplicationMain().configure(new SpringApplicationBuilder(ApplicationMain.class))
				.run(args);
	}

}