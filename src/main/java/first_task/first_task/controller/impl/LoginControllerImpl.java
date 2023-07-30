package first_task.first_task.controller.impl;

import first_task.first_task.controller.interfaces.LoginController;
import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.dto.request.RequestLogin;
import first_task.first_task.entity.Member;
import first_task.first_task.service.interfaces.MemberService;
import first_task.first_task.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginControllerImpl extends BaseControllerImpl implements LoginController {

    private final MemberService memberService;

    @Override
    @GetMapping("/join")
    public String joinInfo() {
        return "회원가입 페이지";
    }
    @Override
    @PostMapping("/join")
    public String requestJoin(@RequestBody RequestJoin requestJoin) {
        memberService.join(requestJoin);
        return String.format("가입을 축하드립니다. %s님", requestJoin.getName());
    }
    @Override
    @GetMapping("/login")
    public String loginInfo() {
        return "로그인 페이지";
    }

    @Override
    @PostMapping("/login")
    public String requestLogin(@RequestBody RequestLogin requestLogin, HttpServletRequest request) {
        Member loginMember = memberService.loginCheck(requestLogin);
        if (loginMember == null) {
            return "아이디 또는 비밀번호를 틀렸습니다";
        }
        return JwtTokenUtil.createToken(loginMember.getNameId(), "my-secret-key-123123", 1000 * 60 * 60);
    }
}
