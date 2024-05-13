package com.tpe.HandlerExceptionResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> productMap;

    public ProductRepository() {
        this.productMap = new HashMap<>();
        // Örnek ürünler ekleme
        productMap.put(1L, new Product(1L, "Ürün 1", 100.0));
        productMap.put(2L, new Product(2L, "Ürün 2", 200.0));
    }

    public Product findById(long id) {
        return productMap.get(id);
    }

    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(Product product) {
        productMap.remove(product.getId());
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
