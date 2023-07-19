package first_task.first_task.service.impl;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.OrderRepository;
import first_task.first_task.repository.querydsl.OrderQueryDslRepository;
import first_task.first_task.service.impl.BaseServiceImpl;
import first_task.first_task.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class OrderServiceImplImpl extends BaseServiceImpl<Order, Long> implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderQueryDslRepository orderQueryDslRepository;
    @Autowired
    public OrderServiceImplImpl(BaseRepository<Order, Long> baseRepository, OrderRepository orderRepository, OrderQueryDslRepository orderQueryDslRepository) {
        super(baseRepository);
        this.orderRepository = orderRepository;
        this.orderQueryDslRepository = orderQueryDslRepository;
    }
}
