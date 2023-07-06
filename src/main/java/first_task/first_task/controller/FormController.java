package first_task.first_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface FormController {
    @GetMapping("/")
    String CreateForm();

    @PostMapping("/save/")
    String Create();
}
