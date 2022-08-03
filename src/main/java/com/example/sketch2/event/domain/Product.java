package com.example.sketch2.event.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNo;
    private String productName;
    private LocalDateTime updateAt;

    public Product(long productNo, LocalDateTime createProductAt) {
    }
}
