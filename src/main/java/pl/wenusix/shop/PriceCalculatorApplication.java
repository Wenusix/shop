package pl.wenusix.shop;

import java.util.List;

public class PriceCalculatorApplication {
    public static void main(String[] args) {

        final ProductRepository productRepository = new ProductInMemoryRepository();

        productRepository.saveProduct(new Product(1, "butter", 6, List.of("food", "dairy")));

        final Product foundProductById = productRepository.findById(1);

        productRepository.saveProduct(foundProductById.withNewPrice(5));

        System.out.println(productRepository.findAll());
    }
}
