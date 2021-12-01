package tl4.group14.tradingengine.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tl4.group14.tradingengine.model.OnlineOrder;


public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Long>  {


}

