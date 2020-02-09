package csl.mq.demo.demo1;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String send(){
        String content="Date:"+new Date();
        amqpTemplate.convertAndSend("cslTest1",content);
        return content;
    }
    @RequestMapping(value = "/multisend",method = RequestMethod.GET)
    public String multisend(){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("cslTest1","第"+i+"次发送的时间："+time);
            stringBuilder.append(time+"<br>");
        }
        return stringBuilder.toString();
    }
    @RequestMapping(value = "/multisend2",method = RequestMethod.GET)
    public String multisend2(){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("cslTest1","第"+i+"次发送的时间："+time);
            amqpTemplate.convertAndSend("cslTest2","第"+i+"次发送的时间："+time);
            stringBuilder.append(time+"<br>");
        }
        return stringBuilder.toString();
    }
}
