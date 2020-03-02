package pl.pk.persistancelab.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartId;
    private Long customerId;
    private Long productId;

    @OneToMany
    private List<Product> products;
}
