package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;
import java.util.List;
import java.util.Map;    

    @Service
    public class ProductService {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public void addProduct(Product product) {
            String sql = "INSERT INTO Product (ProductId,ProductDescription, ProductCategory, ManufacturerName, ManufacturerLocation) VALUES (?,?, ?, ?, ?)";
            jdbcTemplate.update(sql,product.getProductId(), product.getProductDescription(), product.getProductCategory(), product.getManufacturerName(), product.getManufacturerLocation());
        }

        public List<Map<String, Object>> getAllProduct() {
            String sql = "SELECT * FROM Product";
            return jdbcTemplate.queryForList(sql);
        }
        public Map<String, Object> findById(int id) {
            String sql = "SELECT * FROM Product WHERE ProductId = ?";
            return jdbcTemplate.queryForMap(sql, id);
        }

        public void update(int id, Product product) {
            String sql = "UPDATE Product SET ProductDescription = ?, ProductCategory = ?, ManufacturerName = ?, ManufacturerLocation = ? WHERE ProductId = ?";
            jdbcTemplate.update(sql, product.getProductDescription(), product.getProductCategory(), product.getManufacturerName(), product.getManufacturerLocation(), id);
        }

        public void delete(int id) {
            String sql = "DELETE FROM Product WHERE ProductId = ?";
            jdbcTemplate.update(sql, id);
        }

		
		}

		
    

    

