package tl4.group14.tradingengine.model;

import lombok.Data;
import tl4.Action;

import javax.persistence.*;


@Data
@Entity
@Table(name="onlineorder")
public class OnlineOrder {



    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product", nullable = true)
    private String product;
    @Column(name = "quantity", nullable = true)
    private long quantity;
    @Column(name = "price", nullable = true)
    private double price;
    @Column(name = "side", nullable = true)
    private Action side;
}
