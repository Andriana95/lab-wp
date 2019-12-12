package mk.finki.ukim.mk.lab.model;

import java.util.concurrent.atomic.AtomicLong;

public class Order {
    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(){}
    public Order(String pizzaType,String pizzaSize,String clientName,String clientAddress){
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setOrderId(AtomicLong orderId) {
    }
}
