package foo.amqp.tutorials.rabbitmq;

import foo.amqp.tutorials.rabbitmq.second.SecondConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
@Import(SecondConfig.class)
public class RabbitmqAmqpTutorialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqAmqpTutorialsApplication.class, args);
    }

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            log.info("This app uses Spring Profiles to control its behavior.\n");
            log.info("\n\n\nSAMPLE USAGE:\t java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender\n\n");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }

}
