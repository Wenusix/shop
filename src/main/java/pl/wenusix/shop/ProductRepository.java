package pl.wenusix.shop;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Integer id);
    List<Product> findByTag(String tag);

    void saveProduct(Product product);
    void deleteProduct(Product product);
    void deleteProduct(Integer id);

}
