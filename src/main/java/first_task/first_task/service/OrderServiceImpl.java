package first_task.first_task.service;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends CRUDServiceImpl<OrderRepository,Order> implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(BaseRepository<Order> baseRepository, OrderRepository orderRepository) {
        super(baseRepository);
        this.orderRepository = orderRepository;
    }



}
