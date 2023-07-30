package first_task.first_task.controller.interfaces;

import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.dto.request.RequestLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public interface LoginController extends BaseController {
    @GetMapping("/join")
    String joinInfo();

    @PostMapping("/join")
    String requestJoin(RequestJoin requestJoin);

    @GetMapping("/login")
    String loginInfo();

    @PostMapping("/login")
    String requestLogin(RequestLogin requestLogin, HttpServletRequest request);


}
