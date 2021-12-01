package tl4.group14.tradingengine.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tl4.group14.tradingengine.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long>  {


}

