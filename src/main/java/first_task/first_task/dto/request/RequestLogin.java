package first_task.first_task.dto.request;

import first_task.first_task.entity.Member;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
@Getter
public class RequestLogin {

    @NotEmpty(message = "아이디가 없습니다")
    private String nameId;      // 회원 id
    @NotEmpty(message = "비밀번호가 없습니다")
    private String password;    // 회원 password
    public RequestLogin(Member member) {
        nameId = member.getNameId();
        password = member.getPassword();
    }
    @Builder
    public RequestLogin(String nameId, String password) {
        this.nameId = nameId;
        this.password = password;
    }
}
