package first_task.first_task.controller.interfaces;

import first_task.first_task.dto.member.JoinDto;
import first_task.first_task.dto.member.LoginDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public interface LoginController extends BaseController {
    @GetMapping("/join")
    String joinMessage();

    @PostMapping("/join")
    String join(JoinDto joinDto);

    @GetMapping("/login")
    String loginMessage();

    @PostMapping("/login")
    String login(LoginDto loginDto, HttpServletRequest request);


}
