package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService1 implements OrderService {
     private  OrderRepository OrderRepository;
    private static AtomicLong longId;
     public OrderService1(OrderRepository orderRepository){
         this.OrderRepository = orderRepository;
         this.longId = new AtomicLong(1);
     }
    @Override
    public Order placeOrder(String pizzaType, String pizzaSize, String clientName, String clientAdres) {
        Order order = new Order();
        order.setPizzaType(pizzaType);
        order.setPizzaSize(pizzaSize);
        order.setClientName(clientName);
        order.setClientAddress(clientAdres);
        order.setOrderId(longId);
      return  order;

    }
}
