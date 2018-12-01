package foo.amqp.tutorials.rabbitmqamqptutorials;

import foo.amqp.tutorials.rabbitmqamqptutorials.tut1.Tut1Config;
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
@Import(Tut1Config.class)
public class RabbitmqAmqpTutorialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqAmqpTutorialsApplication.class, args);
    }


    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("This app uses Spring Profiles to control its behavior.\n");
                log.info("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
            }
        };
    }


    @Profile("!usage-message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }

}
