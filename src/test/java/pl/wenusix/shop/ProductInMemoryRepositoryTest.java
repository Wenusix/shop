package pl.wenusix.shop;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductInMemoryRepositoryTest {

    @Test
    void should_return_all_products_when_saved_them() {
        //given
        ProductRepository productRepository = new ProductInMemoryRepository();
        Product product = new Product(1, "Butter", 10, List.of("food", "dairy"));
        Product product2 = new Product(2, "Orange", 2, List.of("food", "fruit"));
        //when
        productRepository.saveProduct(product);
        productRepository.saveProduct(product2);
        //then
        assertEquals(2, productRepository.findAll().size());
        assertTrue(productRepository.findAll().contains(product));
        assertTrue(productRepository.findAll().contains(product2));
    }

    @Test
    void should_return_one_product_when_saved_two_products_with_the_same_id(){
        //given
        ProductRepository productRepository = new ProductInMemoryRepository();
        Product product = new Product(1, "Butter", 10, List.of("food", "dairy"));
        Product product2 = new Product(1, "Orange", 2, List.of("food", "fruit"));
        //when
        productRepository.saveProduct(product);
        productRepository.saveProduct(product2);
        //then
        assertEquals(1, productRepository.findAll().size());
    }

    @Test
    void should_return_products_with_food_tag() {
        //given
        String food = "food";
        ProductRepository productRepository = new ProductInMemoryRepository();
        Product product = new Product(1, "Butter", 10, List.of(food, "dairy"));
        Product product2 = new Product(2, "Orange", 2, List.of(food, "fruit"));
        Product product3 = new Product(3, "Car", 10000, List.of("machine"));
        //when
        productRepository.saveProduct(product);
        productRepository.saveProduct(product2);
        productRepository.saveProduct(product3);
        List<Product> foodList = productRepository.findByTag(food);
        //then
        assertTrue(foodList.contains(product));
        assertTrue(foodList.contains(product2));
        assertFalse(foodList.contains(product3));
    }
}