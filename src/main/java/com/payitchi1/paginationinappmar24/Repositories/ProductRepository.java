package com.payitchi1.paginationinappmar24.Repositories;

import com.payitchi1.paginationinappmar24.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
