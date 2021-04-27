package training.java.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOrder {

  @RabbitListener(queues = "restaurant_queue")
  public void consume(String orderFootName) {
    System.out.println("Message recieved from queue is");
    System.out.println("Order foot name" + orderFootName);
  }
}
