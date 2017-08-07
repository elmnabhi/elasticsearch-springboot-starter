package rs2i.starter.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "rs2i.starter.elasticsearch")
@PropertySource(value = {"classpath:application.properties"})
public class App extends SpringBootServletInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
        LOGGER.debug("Hello ElasticSearch...");
    }

}
