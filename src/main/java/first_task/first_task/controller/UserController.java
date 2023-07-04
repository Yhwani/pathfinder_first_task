package first_task.first_task.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@RequestMapping("/default")
public interface UserController {
    @GetMapping("/join")
    String joinForm(Model model);

    @PostMapping("/join")
    String join(@Valid Member member, BindingResult result);

}
