package first_task.first_task.service;

import first_task.first_task.entity.Product;
import first_task.first_task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements CRUDService<ProductRepository, Product> {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
