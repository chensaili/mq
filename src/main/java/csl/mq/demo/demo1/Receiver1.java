package csl.mq.demo.demo1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component("Receiver1")
@RabbitListener(queues = "cslTest1")
public class Receiver1 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("cslTest1 receiver1:"+msg);
    }
}
