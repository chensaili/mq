package csl.mq.demo.demo2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component("TopicReceiver1")
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver1:" + msg);
    }
}
