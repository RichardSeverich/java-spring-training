package training.com.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import training.com.configs.ConfigRabbit;
import training.com.configs.ConfigRabbitRestaurant;

@Component
public class PublisherRestaurant {

  @Autowired
  private RabbitTemplate template;

  public void publish(String orderFootName) {
    template.convertAndSend(ConfigRabbit.EXCHANGE, ConfigRabbitRestaurant.ROUTING_KEY, orderFootName);
  }
}
