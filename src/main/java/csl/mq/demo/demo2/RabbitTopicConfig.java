package csl.mq.demo.demo2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    //只接收一个topic
    final static String message="topic.message";//队列名topic.message
    //接收多个topic
    final static String messages="topic.messages";//队列名topic.messages
    //定义了队列topic.message
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitTopicConfig.message);
    }
    //定义了队列topic.messages
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitTopicConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //定义了队列topic.message的路由规则，匹配路由规则是topic.msg1，当发送的消息的routing_key和路由规则匹配时，就会将消息存到topic.message中
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.msg1");
    }
    //定义了队列topic.messages的路由规则，匹配路由规则是topic.#，当发送的消息的routing_key和路由规则匹配时，就会将消息存到topic.messages中
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
