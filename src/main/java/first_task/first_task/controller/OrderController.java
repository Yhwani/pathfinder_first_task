package first_task.first_task.controller;


import first_task.first_task.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@InterfaceTransmissionDOC
@RequestMapping("/default")
public interface OrderController {
    @GetMapping("/order")
    String OrderForm(@ModelAttribute Order order);

    @PostMapping("/order")
    String order();

}
