import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import tl4.Action;
import tl4.group14.tradingengine.model.OnlineOrder;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class JSONResponseFromExchange {

    public static String createOnlineOrder() throws URISyntaxException {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        URI uri = new URI("https://exchange.matraining.com/219e11f6-fd7b-47f2-b24d-2b15af1efe3d/order");
        OnlineOrder objOrder = new OnlineOrder();
        objOrder.setId(1000L);
        objOrder.setProduct("IBM");
        objOrder.setQuantity(30);
        objOrder.setPrice(1.00);
        objOrder.setSide(Action.SELL);//70d1f51f-1fa9-41db-89a9-c39f84e4410c//a16ce11e-a88d-43ad-a5d1-c6f888678a0d//78070cf0-35c9-4b57-a443-910193d34ac2//0ada7001-edd3-4013-af1d-ac57a29de874

        HttpEntity<OnlineOrder> httpEntity = new HttpEntity<>(objOrder, headers);

        RestTemplate restTemplate = new RestTemplate();
        String onlineOrderId = restTemplate.postForObject(uri, httpEntity,String.class);

        System.out.println("Id: " + onlineOrderId);
        return onlineOrderId;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        createOnlineOrder();

    }
}
