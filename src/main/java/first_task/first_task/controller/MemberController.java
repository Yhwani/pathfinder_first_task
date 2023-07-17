package first_task.first_task.controller;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.dto.Member.LoginDto;
import first_task.first_task.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface MemberController extends BaseController{
    @GetMapping("/join")
    String joinDto(@ModelAttribute JoinDto joinDto);

    @PostMapping("/join")
    String join(@Valid JoinDto joinDto, BindingResult result);

    @GetMapping("/login")
    String loginDto(@ModelAttribute LoginDto loginDto);

    @PostMapping("/login")
    String login(@Valid @ModelAttribute LoginDto loginDto, BindingResult result, HttpServletRequest request);


}
