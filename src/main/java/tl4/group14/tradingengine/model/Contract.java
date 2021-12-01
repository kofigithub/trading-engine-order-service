package tl4.group14.tradingengine.model;

import lombok.Data;
import tl4.Exchange;
import tl4.OrderType;
import tl4.TimeInForce;

import javax.persistence.*;


@Data
@Entity
@Table(name="contract")

public class Contract {

    @Id
    @Column(name="conid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long conid;
    private Exchange exchange;
    private OrderType orderType;
    private String ticker;
    private double minimumPrice;
    private Long multiplier;
    private String marketName;
    private TimeInForce timeInForce;
}
