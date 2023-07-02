package first_task.first_task.repository;

import first_task.first_task.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{
    private EntityManager em;
    @Override
    public void register(Product product) {
        em.persist(product);
    }
    @Override
    public void delete(Product product) {
        Product finderProduct = em.find(Product.class, product.getId());
        em.remove(finderProduct);
    }
    @Override
    public List<Product> findProduct(String name) {
        return em.createQuery("select p from Product p where p.name = :name", Product.class)
                .setParameter("name", name)
                .getResultList();
    }
}
