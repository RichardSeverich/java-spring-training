package training.com.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitPayment {

  public static final String QUEUE = "payment_queue";
  public static final String ROUTING_KEY = "payment_routingKey";

  @Bean
  public Queue paymentQueue() {
    return new Queue(QUEUE);
  }

  @Bean
  public Binding paymenBinding(Queue paymentQueue, TopicExchange exchange) {
    return BindingBuilder.bind(paymentQueue).to(exchange).with(ROUTING_KEY);
  }

}
