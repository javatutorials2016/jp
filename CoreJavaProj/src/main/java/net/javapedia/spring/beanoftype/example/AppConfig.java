package net.javapedia.spring.beanoftype.example;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean

	public Repository mongoRepository() {
		return new MongoRepository();
	}

	@Bean
	@Primary
	public Repository sqlRepository() {
		return new SQLRepository();
	}

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Map<String, Repository> beansList = context.getBeansOfType(Repository.class);

		for (String key : beansList.keySet()) {
			System.out.println(key + " = " + beansList.get(key));
		}
	}
}