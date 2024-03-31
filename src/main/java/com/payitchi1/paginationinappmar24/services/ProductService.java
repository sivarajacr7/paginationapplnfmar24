package com.payitchi1.paginationinappmar24.services;

import com.payitchi1.paginationinappmar24.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    boolean generateProduct();
    Page<Product> getproducts(int pageSize,int pageNumber,String sort);
}
