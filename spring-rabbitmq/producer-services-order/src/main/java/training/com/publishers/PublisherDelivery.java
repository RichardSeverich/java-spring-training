package training.com.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import training.com.configs.ConfigRabbit;
import training.com.configs.ConfigRabbitDelivery;

@Component
public class PublisherDelivery {

  @Autowired
  private RabbitTemplate template;

  public void publish(String orderDeliveryAddress) {
    template.convertAndSend(ConfigRabbit.EXCHANGE, ConfigRabbitDelivery.ROUTING_KEY, orderDeliveryAddress);
  }
}
