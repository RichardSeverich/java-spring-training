package training.java.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOrder {

  @RabbitListener(queues = "delivery_queue")
  public void consume(String orderDeliveryAddress) {
    System.out.println("Message recieved from queue is");
    System.out.println("Order delivery address: " + orderDeliveryAddress);
  }
}
