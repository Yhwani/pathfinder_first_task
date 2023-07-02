package first_task.first_task.service;


import first_task.first_task.entity.Product;
import first_task.first_task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Qualifier("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    @Transactional
    public void register(Product product) {
        productRepository.save(product);
    }
    @Override
    @Transactional
    public void cancel(Product product) {
        productRepository.delete(product);
    }
    @Override
    public List<Product> findProduct(String name) {
        return productRepository.findByName(name);
    }
}
