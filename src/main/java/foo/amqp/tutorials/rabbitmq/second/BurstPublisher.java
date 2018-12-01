package foo.amqp.tutorials.rabbitmq.second;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

@Slf4j
public class BurstPublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue burstyQueue;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void submitTenFold(final String message) {
        IntConsumer consumer = i -> {
            Future f = executorService.submit(() -> template.convertAndSend(burstyQueue.getName(), message));
            log.debug(" [x] Sent " + message);
        };

        IntStream.range(0, 10).forEach(consumer);
    }

}
