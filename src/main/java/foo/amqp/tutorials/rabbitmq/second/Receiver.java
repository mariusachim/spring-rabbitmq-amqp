package foo.amqp.tutorials.rabbitmq.second;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "bursty")
public class Receiver {

    @RabbitHandler
    public void receive(String in) {
        //System.out.println(" [x] Received '" + in + "'");
    }

}
