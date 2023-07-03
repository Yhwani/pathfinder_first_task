package first_task.first_task.service;

import first_task.first_task.entity.Order;
import first_task.first_task.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements CRUDService<OrderRepository, Order>{

    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(Order order) {
    }

    @Override
    public List<Order> read() {
        return null;
    }

    @Override
    public void delete(Order order) {

    }
}
