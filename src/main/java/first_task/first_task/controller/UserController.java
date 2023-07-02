package first_task.first_task.controller;

import first_task.first_task.dto.UserDTO;
import first_task.first_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users/join")
//    public String joinForm(Model model) {
//        model.addAttribute("userForm", new UserDTO());
//        return "users/joinUserForm";
//    }
}
