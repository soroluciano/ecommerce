package com.concurrent.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity implements Comparable<OrderEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate creationDate;

    private LocalDate lastUpdateDate;

    @OneToMany
    private List<ProductEntity> productEntityList;


    @Override
    public int compareTo(OrderEntity o) {
        return this.id.compareTo(o.id);
    }
}
