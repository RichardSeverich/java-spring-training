package training.com.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import training.com.configs.ConfigRabbit;
import training.com.configs.ConfigRabbitPayment;

@Component
public class PublisherPayment {

  @Autowired
  private RabbitTemplate template;

  public void publish(Double orderPrice) {
    template.convertAndSend(ConfigRabbit.EXCHANGE, ConfigRabbitPayment.ROUTING_KEY, orderPrice);
  }
}
