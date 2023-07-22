package first_task.first_task.controller.impl;

import first_task.first_task.controller.interfaces.MemberController;
import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.dto.Member.LoginDto;
import first_task.first_task.entity.Member;
import first_task.first_task.service.interfaces.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberControllerImpl extends BaseControllerImpl implements MemberController {

    private final MemberService memberService;
    private final JpaRepository<Member,Long> jpaRepository;

    @Override
    @GetMapping("/join")
    public String joinDto(@ModelAttribute JoinDto joinDto) {
        return "members/createMemberForm";
    }

    @Override
    @PostMapping("/join")
    public String join(@Valid JoinDto joinDto, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        memberService.join(joinDto);
        return "redirect:/members/createMemberForm.html";
    }

    @Override
    @GetMapping("/login")
    public String loginDto(@ModelAttribute LoginDto loginDto) {
        return "members/loginForm";
    }

    @Override
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginDto loginDto, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "members/loginForm";
        }
        Member loginMember = memberService.loginCheck(loginDto.getNameId(), loginDto.getPassword());
        if (loginMember == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "members/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("login-member",loginMember);
        return "redirect:/";
    }
}
