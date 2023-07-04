package first_task.first_task.controller;

import first_task.first_task.dto.UserDTO;
import first_task.first_task.entity.User;
import first_task.first_task.repository.UserRepository;
import first_task.first_task.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import java.lang.reflect.Member;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

    private final CRUDService<UserRepository, User> crudService;

    @Autowired
    public UserControllerImpl(CRUDService<UserRepository,User> crudService) {
        this.crudService = crudService;
    }

    @Override
    public String joinForm(Model model) {
        return null;
    }

    @Override
    public String join(Member member, BindingResult result) {
        return null;
    }
}
