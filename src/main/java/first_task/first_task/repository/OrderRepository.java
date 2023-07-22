package first_task.first_task.repository;

import first_task.first_task.entity.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("order")
@Primary
public interface OrderRepository extends JpaRepository<Order, Long> {
}
