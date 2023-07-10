package first_task.first_task.controller;

import first_task.first_task.SessionBox;
import first_task.first_task.dto.LoginForm;
import first_task.first_task.entity.Member;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.service.CRUDService;
import first_task.first_task.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberControllerImpl extends BaseControllerImpl implements MemberController {

    private final CRUDService<MemberRepository, Member> crudService;
    private final MemberService memberService;

    @Autowired
    public MemberControllerImpl(CRUDService<MemberRepository, Member> crudService, MemberService memberService) {
        this.crudService = crudService;
        this.memberService = memberService;
    }

    @Override
    @GetMapping("/join")
    public String joinForm(@ModelAttribute Member member) {
        return "members/createMemberForm";
    }


    @Override
    @PostMapping("/join")
    public String join(@Valid LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        crudService.create(new Member());
        return "redirect:/";
    }

    @Override
    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "members/loginForm";
    }

    @Override
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "members/loginForm";
        }
        Member loginMember = memberService.loginCheck(loginForm.getNameId(), loginForm.getPassword());
        if (loginMember == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "members/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionBox.LOGIN_MEMBER,loginMember);
        return "redirect:/";
    }
}
