package first_task.first_task.repository;

import first_task.first_task.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
}
