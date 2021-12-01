package tl4.group14.tradingengine.service;



import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order Order);
    List <Order> getAllOrders();
    Order getOrderById(long id);
    Order updateOrder(Order Order, long id);
    void deleteOrder(long id);
    boolean openOrder(long id);
    boolean cancelOrder(long id);
    Order placeOrder(long id, Contract contract, Order order);

}
