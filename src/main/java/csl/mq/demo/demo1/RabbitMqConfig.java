package csl.mq.demo.demo1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue queue1(){
        return new Queue("cslTest1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("cslTest2");
    }
}
