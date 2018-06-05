package net.javapedia.spring.annotation.primary;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
public class AppConfig {

    @Bean(autowire = Autowire.BY_TYPE)
    public RepoService repoService() {
        return new RepoService();
    }


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
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        RepoService repoService = context.getBean(RepoService.class);
        repoService.invokeRepo();

    }
}