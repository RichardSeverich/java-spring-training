package training.com.models;

import lombok.Data;

/*
* @Data
* add getters.
* add setters.
* add @Override equals.
* add @Override hashCode.
* add @Override toString.
*/
@Data
public class Order {
  public String id;
  public String footName;
  public String deliveryAddress;
  public String quantity;
  public Double price;
}
