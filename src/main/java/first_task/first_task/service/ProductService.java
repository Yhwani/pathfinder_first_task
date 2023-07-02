package first_task.first_task.service;


import first_task.first_task.entity.Product;

import java.util.List;

public interface ProductService {
    void register(Product product);
    void cancel(Product product);
    List<Product> findProduct(String name);
}
