package first_task.first_task.controller.impl;

import first_task.first_task.controller.interfaces.LoginController;
import first_task.first_task.dto.member.JoinDto;
import first_task.first_task.dto.member.LoginDto;
import first_task.first_task.entity.Member;
import first_task.first_task.service.interfaces.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl extends BaseControllerImpl implements LoginController {

    private final MemberService memberService;
    @Override
    @GetMapping("/join")
    public String joinMessage() {
        return "회원가입 페이지";
    }
    @Override
    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        memberService.join(joinDto);
        return String.format("가입을 축하드립니다. %s님", joinDto.getName());
    }

    @Override
    @GetMapping("/login")
    public String loginMessage() {
        return "members/loginForm";
    }

    @Override
    @PostMapping("/login")
    public String login(LoginDto loginDto, HttpServletRequest request) {
        Member loginMember = memberService.loginCheck(loginDto);
        return (loginMember != null) ?
                String.format("어서오세요. %s님", loginMember.getName()) : "로그인 실패";
    }
}
