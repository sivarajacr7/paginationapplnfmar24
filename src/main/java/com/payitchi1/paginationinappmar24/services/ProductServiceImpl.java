package com.payitchi1.paginationinappmar24.services;

import com.payitchi1.paginationinappmar24.Entities.Product;
import com.payitchi1.paginationinappmar24.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    private static final String[] PRODUCT_NAMES = {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earbuds", "Projector", "Desk"
    };
    @Override
    public boolean generateProduct() {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
            int productPrice = random.nextInt(10000) + 100; // Random price between 100 and 10000
            Product product = new Product(productName,productPrice);
            products.add(product);
        }
        productRepository.saveAll(products);
        return true;
    }
    @Override
    public Page<Product> getproducts(int pageSize,
                                     int pageNumber,String sort) {

        Pageable pageable = null;
        if(sort!=null){
            pageable = PageRequest.of(pageNumber,pageSize,Sort.Direction.ASC,sort);
        }else
        pageable = PageRequest.of(pageNumber,pageSize);
        return productRepository.findAll(pageable);
    }
}
