package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully";
    }
    @GetMapping("/{id}")
    public Map<String, Object> getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @GetMapping("/allproduct")
	public List<Map<String, Object>> getAllProduct() {
	return productService.getAllProduct();
	}
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.update(id, product);
        return "Product updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "Product deleted successfully";
    }
   
   
}
