package com.payitchi1.paginationinappmar24.controllers;

import com.payitchi1.paginationinappmar24.Entities.Product;
import com.payitchi1.paginationinappmar24.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/generate")
public boolean generatedata(){
    return  productService.generateProduct();
}
@GetMapping("/products/{pageSize}/{pageNumber}")
public ResponseEntity getProducts(@PathVariable("pageSize") int pageSize,
                                 @PathVariable("pageNumber") int PageNumber){
Page<Product> productpage = productService.getproducts(pageSize,PageNumber,null);
        return ResponseEntity.ok(productpage.getContent());
}
    @GetMapping("/productsByPrice/{pageSize}/{pageNumber}")
    public ResponseEntity getProductsByPageSortedPrice(@PathVariable("pageSize") int pageSize,
                                      @PathVariable("pageNumber") int PageNumber){
        Page<Product> productpage = productService.getproducts(pageSize,PageNumber,"price");
        return ResponseEntity.ok(productpage.getContent());
    }
}
