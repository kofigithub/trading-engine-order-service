package tl4.group14.tradingengine.model;

import lombok.Data;
import tl4.Action;
import tl4.Currency;
import tl4.OrderType;
import tl4.SecType;

import javax.persistence.*;


@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "account", nullable = true)
    private String account;
    @Column(name = "side", nullable = true)
    private Action side;
    @Column(name = "secType", nullable = true)
    private SecType secType;
    @Column(name = "quantity", nullable = true)
    private Long quantity;
    @Column(name = "orderType", nullable = true)
    private OrderType orderType;
    @Column(name = "limitPrice", nullable = true)
    private double limitPrice;
    @Column(name = "bidPrice", nullable = true)
    private double bidPrice;
    @Column(name = "askPrice", nullable = true)
    private double askPrice;
    @Column(name = "auxPrice", nullable = true)
    private double auxPrice;
    @Column(name = "currency", nullable = true)
    private Currency currency;
    @Column(name = "timeInForce", nullable = true)
    private String timeInForce;
    @Column(name = "orderStatus", nullable = true)
    private String orderStatus;
    @Column(name = "tickerId", nullable = true)
    private String tickerId;



}

