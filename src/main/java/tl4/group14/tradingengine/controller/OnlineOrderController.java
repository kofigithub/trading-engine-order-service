package tl4.group14.tradingengine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tl4.group14.tradingengine.model.OnlineOrder;
import tl4.group14.tradingengine.service.OnlineOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/onlineorder")

public class OnlineOrderController {
    private OnlineOrderService OnlineOrderService;

    public OnlineOrderController(OnlineOrderService OnlineOrderService) {
        super();
        this.OnlineOrderService = OnlineOrderService;
    }

    // build create OnlineOrder REST API
    @PostMapping
    public ResponseEntity<OnlineOrder> saveOnlineOrder(@RequestBody OnlineOrder onlineOrder){
        return new ResponseEntity<OnlineOrder>(OnlineOrderService.saveOnlineOrder(onlineOrder),HttpStatus.CREATED);

    }

    //build get all OnlineOrder REST API
    @GetMapping
    public List<OnlineOrder> getAllOnlineOrders(){

        return OnlineOrderService.getAllOnlineOrders();


    }

    // build get OnlineOrder by id REST API
    // http://localhost:8080/api/OnlineOrder/1
    @GetMapping("{conid}")
    public ResponseEntity<OnlineOrder> getOnlineOrderById(@PathVariable("conid") long conid){
        return new ResponseEntity<OnlineOrder>(OnlineOrderService.getOnlineOrderById(conid),HttpStatus.OK);

    }

    // build update OnlineOrder REST API
    // http://localhost:8080/api/OnlineOrder/1
    @PutMapping("{conid}")
    public ResponseEntity<OnlineOrder> updateOnlineOrder(@PathVariable("conid") long conid
            ,@RequestBody OnlineOrder OnlineOrder){

        return new ResponseEntity<OnlineOrder>(OnlineOrderService.updateOnlineOrder(OnlineOrder,conid),HttpStatus.OK);
    }

    //build delete OnlineOrder  REST API
    // http://localhost:8080/api/OnlineOrder/1
    @DeleteMapping("{conid}")
    public ResponseEntity<String> deleteOnlineOrder(@PathVariable("conid") long conid) {
        //delete OnlineOrder from DB
        OnlineOrderService.deleteOnlineOrder(conid);
        return new ResponseEntity<String>("OnlineOrder deleted successfully!",HttpStatus.OK);

    }


}
