package csl.mq.demo.demo1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component("Receiver2")
@RabbitListener(queues = "cslTest2")
public class Receiver2 {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("cslTest2 recever2:"+msg);
    }
}
