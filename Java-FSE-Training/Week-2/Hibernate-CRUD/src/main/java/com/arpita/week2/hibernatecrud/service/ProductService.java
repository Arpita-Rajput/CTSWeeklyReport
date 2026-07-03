package com.arpita.week2.hibernatecrud.service;

import java.util.List;
import com.arpita.week2.hibernatecrud.dto.ProductDTO;
import com.arpita.week2.hibernatecrud.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductDTO productDTO);
    Product updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    List<Product> getProductsByCategory(Long categoryId);
}
