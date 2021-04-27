package training.com.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitDelivery {

  public static final String QUEUE = "delivery_queue";
  public static final String ROUTING_KEY = "delivery_routingKey";

  @Bean
  public Queue deliveryQueue() {
    return new Queue(QUEUE);
  }

  @Bean
  public Binding deliveryBinding(Queue deliveryQueue, TopicExchange exchange) {
    return BindingBuilder.bind(deliveryQueue).to(exchange).with(ROUTING_KEY);
  }

}
