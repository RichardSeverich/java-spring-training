package training.com.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitRestaurant {

  public static final String QUEUE = "restaurant_queue";
  public static final String ROUTING_KEY = "restaurant_routingKey";

  @Bean
  public Queue restaurantQueue() {
    return new Queue(QUEUE);
  }

  @Bean
  public Binding restaurantBinding(Queue restaurantQueue, TopicExchange exchange) {
    return BindingBuilder.bind(restaurantQueue).to(exchange).with(ROUTING_KEY);
  }

}
