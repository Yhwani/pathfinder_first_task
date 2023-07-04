package first_task.first_task.repository;

import first_task.first_task.entity.Product;

import java.util.List;
public interface ProductRepository extends BaseRepository<Product> {
    List<Product> findByName(String name);
}
