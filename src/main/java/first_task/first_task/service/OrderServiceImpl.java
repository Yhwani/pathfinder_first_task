package first_task.first_task.service;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.OrderRepository;


public class OrderServiceImpl extends CRUDServiceImpl<OrderRepository,Order> implements OrderService{
    public OrderServiceImpl(BaseRepository<Order> baseRepository) {
        super(baseRepository);
    }
}
