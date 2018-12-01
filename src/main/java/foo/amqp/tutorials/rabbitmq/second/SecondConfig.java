package foo.amqp.tutorials.rabbitmq.second;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"bursty"})
@Configuration
public class SecondConfig {

    @Bean
    public Queue burstyQueue() {
        return new Queue("bursty", false);
    }

    @Profile("receiver")
    @Bean
    public Receiver burstyReceiver() {
        return new Receiver();
    }

    @Profile("sender")
    @Bean
    public Sender burstySender() {
        return new Sender();
    }

    @Bean
    public BurstPublisher burstPublisher() {
        return new BurstPublisher();
    }

}