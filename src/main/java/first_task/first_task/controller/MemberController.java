package first_task.first_task.controller;

import first_task.first_task.dto.LoginForm;
import first_task.first_task.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@InterfaceTransmissionDOC
@RequestMapping("/default")
public interface MemberController extends BaseController{
    @GetMapping("/join")
    String joinForm(@ModelAttribute Member member);

    @PostMapping("/join")
    String join(@Valid LoginForm loginForm, BindingResult result);

    @GetMapping("/login")
    String loginForm(@ModelAttribute LoginForm loginForm);

    @PostMapping("/login")
    String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, HttpServletRequest request);


}
