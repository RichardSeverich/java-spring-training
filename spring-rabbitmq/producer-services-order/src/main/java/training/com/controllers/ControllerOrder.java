package training.com.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import training.com.publishers.PublisherPayment;
import training.com.publishers.PublisherRestaurant;
import training.com.publishers.PublisherDelivery;
import training.com.models.Order;

@RestController
@RequestMapping("/order")
public class ControllerOrder {

  @Autowired
  private PublisherPayment publisherPayment;

  @Autowired
  private PublisherRestaurant publisherRestaurant;

  @Autowired
  private PublisherDelivery publisherDelivery;

  @PostMapping()
  public String bookOrder(@RequestBody Order order) {
    order.id = UUID.randomUUID().toString();
    publisherPayment.publish(order.price);
    publisherRestaurant.publish(order.footName);
    publisherDelivery.publish(order.deliveryAddress);
    return "Success ...";
  }

}
