package first_task.first_task.controller;

import first_task.first_task.dto.MemberDTO;
import first_task.first_task.entity.Member;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.service.CRUDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberControllerImpl extends BaseControllerImpl implements MemberController {

    private final CRUDService<MemberRepository, Member> crudService;

    @Autowired
    public MemberControllerImpl(CRUDService<MemberRepository, Member> crudService) {
        this.crudService = crudService;
    }

    @Override
    @GetMapping("/join")
    public String joinForm(Model model) {
        return null;
    }

    @Override
    @PostMapping("/join")
    public String join(@Valid MemberDTO memberDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "/createMemberForm";
        }

        MemberDTO

        crudService.create(memberA);
        return "redirect:/";    }
}
