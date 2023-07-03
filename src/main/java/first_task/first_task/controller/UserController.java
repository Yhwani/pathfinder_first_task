package first_task.first_task.controller;

import first_task.first_task.dto.UserDTO;
import first_task.first_task.entity.User;
import first_task.first_task.repository.UserRepository;
import first_task.first_task.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final CRUDService<UserRepository, User> crudService;

    @Autowired
    public UserController(CRUDService<UserRepository,User> crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/users/join")
    public String joinForm(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "users/joinUserForm";
    }
}
