package first_task.first_task.service.impl;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.OrderRepository;
import first_task.first_task.repository.querydsl.OrderQueryDslRepository;
import first_task.first_task.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderQueryDslRepository orderQueryDslRepository;
    @Autowired
    public OrderServiceImpl(@Qualifier("order")JpaRepository<Order, Long> jpaRepository, OrderRepository orderRepository, OrderQueryDslRepository orderQueryDslRepository) {
        super(jpaRepository);
        this.orderRepository = orderRepository;
        this.orderQueryDslRepository = orderQueryDslRepository;
    }
}
