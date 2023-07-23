package first_task.first_task.dto.member;

import first_task.first_task.entity.Member;
import first_task.first_task.entity.RoleType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinDto {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "이름이 없습니다")
    private String name;        // 회원이름
    @NotEmpty(message = "아이디가 없습니다")
    private String nameId;      // 회원 id
    @NotEmpty(message = "비밀번호가 없습니다")
    private String password;    // 회원 password
    @NotEmpty(message = "역할이 없습니다.")
    private RoleType roleType;  // 회원 역할
    @Builder
    public JoinDto(String name, String nameId, String password, RoleType roleType) {
        this.name = name;
        this.nameId = nameId;
        this.password = password;
        this.roleType = roleType;
    }
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nameId(nameId)
                .password(password)
                .money(0L)
                .roleType(RoleType.Member)
                .build();
    }

}
