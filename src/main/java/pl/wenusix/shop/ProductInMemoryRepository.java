package pl.wenusix.shop;

import java.util.*;

public class ProductInMemoryRepository implements ProductRepository{

    private final Map<Integer, Product> mapProducts = new HashMap<>();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(mapProducts.values());
    }

    @Override
    public Product findById(Integer id) {
        return mapProducts.get(id);
    }

    @Override
    public List<Product> findByTag(String tag) {
        return mapProducts.values().stream().filter(v -> v.tags().contains(tag)).toList();
    }

    @Override
    public void saveProduct(Product product) {
        mapProducts.put(product.id(), product);
    }

    @Override
    public void deleteProduct(Product product) {
        deleteProduct(product.id());
    }

    @Override
    public void deleteProduct(Integer id) {
        mapProducts.remove(id);
    }
}
