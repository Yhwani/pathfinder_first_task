package first_task.first_task.service;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends BaseService<OrderRepository,Order> implements OrderService{
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(BaseRepository<Order> baseRepository, OrderRepository orderRepository) {
        super(baseRepository);
        this.orderRepository = orderRepository;
    }



}
