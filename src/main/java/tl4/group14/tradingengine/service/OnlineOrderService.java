package tl4.group14.tradingengine.service;

import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.model.OnlineOrder;
import java.net.URISyntaxException;
import java.util.List;

public interface OnlineOrderService {
    OnlineOrder saveOnlineOrder(OnlineOrder onlineOrder);
    List<OnlineOrder> getAllOnlineOrders();
    OnlineOrder getOnlineOrderById(long id);
    OnlineOrder updateOnlineOrder(OnlineOrder onlineOrder, long id);
    void deleteOnlineOrder(long id);
    boolean openOnlineOrder(long id);
    boolean cancelOnlineOrder(long id);
    OnlineOrder placeOnlineOrder(long id, Contract contract, OnlineOrder onlineOrder);
    String createOnlineOrder() throws URISyntaxException;
}



