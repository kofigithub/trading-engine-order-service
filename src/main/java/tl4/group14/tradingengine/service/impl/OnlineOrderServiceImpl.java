package tl4.group14.tradingengine.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tl4.Action;
import tl4.group14.tradingengine.exception.ResourceNotFoundException;
import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.model.OnlineOrder;
import tl4.group14.tradingengine.repository.OnlineOrderRepository;
import tl4.group14.tradingengine.service.OnlineOrderService;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class OnlineOrderServiceImpl implements OnlineOrderService {


    private  OnlineOrderRepository OnlineOrderRepository;


    //@Autowire
    public OnlineOrderServiceImpl(OnlineOrderRepository OnlineOrderRepository) {
        super();
        this.OnlineOrderRepository = OnlineOrderRepository;
    }



    @Override
    public OnlineOrder saveOnlineOrder(OnlineOrder onlineOrder) {
        return OnlineOrderRepository.save(onlineOrder);
    }



    @Override
    public List<OnlineOrder> getAllOnlineOrders() {
        return  OnlineOrderRepository.findAll();
    }



    @Override
    public OnlineOrder getOnlineOrderById(long id) {
//		Optional<OnlineOrder> OnlineOrder = OnlineOrderRepository.findById(id);
//		if(OnlineOrder.isPresent()) {
//		return OnlineOrder.get();
//
//		}
//		else {
//			throw new ResourceNotFoundException("OnlineOrder","Id", id);
        //}

        return OnlineOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OnlineOrder", "Id", id));


    }



    @Override
    public OnlineOrder updateOnlineOrder(OnlineOrder OnlineOrder, long id) {
        // we need to check whether OnlineOrder with given id exists in DB or not
        OnlineOrder existingOnlineOrder = OnlineOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OnlineOrder", "Id", id));
        /*existingOnlineOrder.setFirstName(OnlineOrder.getFirstName());
        existingOnlineOrder.setLastName(OnlineOrder.getLastName());
        existingOnlineOrder.setEmail(OnlineOrder.getEmail());*/
        // save existing OnlineOrder to DB
        OnlineOrderRepository.save(existingOnlineOrder);
        return existingOnlineOrder;




    }



    @Override
    public void deleteOnlineOrder(long id) {
        // check whether OnlineOrder with given id exists in DB or not
        OnlineOrderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("OnlineOrder", "Id", id));
        OnlineOrderRepository.deleteById(id);

    }

    @Override
    public boolean openOnlineOrder(long id) {
        return false;
    }

    @Override
    public boolean cancelOnlineOrder(long id) {
        return false;
    }

    @Override
    public OnlineOrder placeOnlineOrder(long id, Contract contract, OnlineOrder OnlineOrder) {
        return null;
    }


    @Override
    public String createOnlineOrder() throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        URI uri = new URI("https://exchange.matraining.com/219e11f6-fd7b-47f2-b24d-2b15af1efe3d/order");
        OnlineOrder objOrder = new OnlineOrder();
        objOrder.setId(1000L);
        objOrder.setProduct("IBM");
        objOrder.setQuantity(30);
        objOrder.setPrice(1.00);
        objOrder.setSide(Action.SELL);//70d1f51f-1fa9-41db-89a9-c39f84e4410c//a16ce11e-a88d-43ad-a5d1-c6f888678a0d//78070cf0-35c9-4b57-a443-910193d34ac2

        HttpEntity<OnlineOrder> httpEntity = new HttpEntity<>(objOrder, headers);

        RestTemplate restTemplate = new RestTemplate();
        String onlineOrderId = restTemplate.postForObject(uri, httpEntity,String.class);

        System.out.println("Id: " + onlineOrderId);
        return onlineOrderId;
    }


}
