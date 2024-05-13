package com.tpe.HandlerExceptionResolver;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public Product getProductById(long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Ürün bulunamadı: " + id);
        }
        return product;
    }

    public void deleteProduct(long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Silinecek ürün bulunamadı: " + id);
        }
        productRepository.delete(product);
    }
}