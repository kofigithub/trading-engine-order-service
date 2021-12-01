package tl4.group14.tradingengine.service.impl;

import org.springframework.stereotype.Service;
import tl4.group14.tradingengine.exception.ResourceNotFoundException;
import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.model.Order;
import tl4.group14.tradingengine.repository.OrderRepository;
import tl4.group14.tradingengine.service.OrderService;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private OrderRepository OrderRepository;


    //@Autowire
    public OrderServiceImpl(OrderRepository OrderRepository) {
        super();
        this.OrderRepository = OrderRepository;
    }



    @Override
    public Order saveOrder(Order Order) {
        return OrderRepository.save(Order);
    }



    @Override
    public List<Order> getAllOrders() {
        return  OrderRepository.findAll();
    }



    @Override
    public Order getOrderById(long id) {
//		Optional<Order> Order = OrderRepository.findById(id);
//		if(Order.isPresent()) {
//		return Order.get();
//
//		}
//		else {
//			throw new ResourceNotFoundException("Order","Id", id);
        //}

        return OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));


    }



    @Override
    public Order updateOrder(Order Order, long id) {
        // we need to check whether Order with given id exists in DB or not
        Order existingOrder = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
        /*existingOrder.setFirstName(Order.getFirstName());
        existingOrder.setLastName(Order.getLastName());
        existingOrder.setEmail(Order.getEmail());*/
        // save existing Order to DB
        OrderRepository.save(existingOrder);
        return existingOrder;




    }



    @Override
    public void deleteOrder(long id) {
        // check whether Order with given id exists in DB or not
        OrderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
        OrderRepository.deleteById(id);

    }

    @Override
    public boolean openOrder(long id) {
        return false;
    }

    @Override
    public boolean cancelOrder(long id) {
        return false;
    }



    @Override
    public Order placeOrder(long id, Contract contract, Order order) {
        return null;
    }


}
