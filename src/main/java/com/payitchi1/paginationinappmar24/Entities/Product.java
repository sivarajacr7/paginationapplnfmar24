package com.payitchi1.paginationinappmar24.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PAGINATED_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int price;
    public Product(String name,int price)
    {
        this.name = name;
        this.price = price;
    }
    public Product() {

    }
}
