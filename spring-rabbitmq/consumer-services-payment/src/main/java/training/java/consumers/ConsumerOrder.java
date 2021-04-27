package training.java.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOrder {

  @RabbitListener(queues = "payment_queue")
  public void consume(Double orderPrice) {
    System.out.println("Message recieved from queue is");
    System.out.println("Order price: " + orderPrice);
  }
}
