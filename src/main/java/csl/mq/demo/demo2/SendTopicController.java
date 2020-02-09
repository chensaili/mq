package csl.mq.demo.demo2;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendTopicController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/topicSend1")
    public String  topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        //发送消息的routing_key为topic.msg1，和两个队列的路由规则都一样，所以放入两个队列中
        this.amqpTemplate.convertAndSend("exchange", "topic.msg1", context);
        return context;
    }
    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        //发送消息的routing_key为topic.messages，和topic.messages队列的路由规则一样，所以放入topic.messages队列中
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return  context;
    }
}
