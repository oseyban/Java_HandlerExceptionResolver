package com.tpe.HandlerExceptionResolver;

public class ApplicationRunner {

    public static void main(String[] args) {
        // ProductRepository ve ProductService'in oluşturulması
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);

        // Örnek ürünleri bulma
        try {
            Product product1 = productService.getProductById(1);
            System.out.println("Bulunan ürün: " + product1);
        } catch (ProductNotFoundException e) {
            System.out.println("Ürün bulunamadı: " + e.getMessage());
        }

        // Olmayan bir ürünü silme
        try {
            productService.deleteProduct(3);
            System.out.println("Ürün başarıyla silindi.");
        } catch (ProductNotFoundException e) {
            System.out.println("Silinecek ürün bulunamadı: " + e.getMessage());
        }
    }
}
