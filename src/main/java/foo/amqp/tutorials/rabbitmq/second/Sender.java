package foo.amqp.tutorials.rabbitmq.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class Sender {

    static int i = 0;

    @Autowired
    private BurstPublisher burstPublisher;

    @Autowired
    private Queue burstyQueue;

    @Scheduled(fixedDelayString = "${tutorial.sender.msg.interval}", initialDelay = 500)
    public void send() {
        String message = "message_" + ++i;
        burstPublisher.submitTenFold(message);
    }


}
