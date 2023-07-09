package first_task.first_task.controller;

import first_task.first_task.dto.MemberDTO;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@InterfaceTransmissionDOC
@RequestMapping("/default")
public interface MemberController extends BaseController{
    @GetMapping("/join")
    String joinForm(Model model);

    @PostMapping("/join")
    String join(@Valid MemberDTO memberDTO, BindingResult result);

    @GetMapping("/login")
    String loginForm(Model model);

    @PostMapping("/login")
    String login(@Valid MemberDTO memberDTO, BindingResult result);


}
