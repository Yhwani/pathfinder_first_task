package first_task.first_task.service;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.BaseRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends BaseService<Order> implements OrderService{
    public OrderServiceImpl(BaseRepository<Order> baseRepository) {
        super(baseRepository);
    }
}
