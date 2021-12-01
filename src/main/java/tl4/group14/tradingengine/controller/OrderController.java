package tl4.group14.tradingengine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tl4.group14.tradingengine.model.Order;
import tl4.group14.tradingengine.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private  OrderService OrderService;

    public OrderController(OrderService OrderService) {
        super();
        this.OrderService = OrderService;
    }

    // build create Order REST API
    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(OrderService.saveOrder(order),HttpStatus.CREATED);

    }

    //build get all Orders REST API
    @GetMapping
    public List<Order> getAllOrders(){

        return OrderService.getAllOrders();


    }

    // build get Order by id REST API
    // http://localhost:8080/api/order/1
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long Orderid){
        return new ResponseEntity<Order>(OrderService.getOrderById(Orderid),HttpStatus.OK);

    }

    // build update Order REST API
    // http://localhost:8080/api/order/1
    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id
            , @RequestBody Order Order){

        return new ResponseEntity<Order>(OrderService.updateOrder(Order,id),HttpStatus.OK);
    }

    //build delete Order  REST API
    // http://localhost:8080/api/order/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        //delete Order from DB
        OrderService.deleteOrder(id);
        return new ResponseEntity<String>("Order deleted successfully!",HttpStatus.OK);

    }

}

