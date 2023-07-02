package first_task.first_task.repository;

import first_task.first_task.entity.Product;
import first_task.first_task.entity.User;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface ProductRepository {
    void save(Product product);
    void delete(Product product);
    List<Product> findByName(String name);
}
