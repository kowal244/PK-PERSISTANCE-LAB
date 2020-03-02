package pl.pk.persistancelab.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity

@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @OneToOne
    private Cart cart;
}
