package pl.wenusix.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Product(Integer id, String name, int price, List<String> tags) {

    public Product(Integer id, String name, int price) {
        this(id, name, price, new ArrayList<>());
    }

    @Override
    public List<String> tags() {
        return Collections.unmodifiableList(tags);
    }

    public Product withNewPrice(int price){
        return new Product(id, name, price, tags);
    }
}