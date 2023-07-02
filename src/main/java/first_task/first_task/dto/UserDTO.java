package first_task.first_task.dto;

import first_task.first_task.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Setter;

@Setter
public class UserDTO {

    @NotEmpty(message = "이름이 없습니다")
    private String name;        // 회원이름
    @NotEmpty(message = "아이디가 없습니다")
    private String nameId;      // 회원 id
    @NotEmpty(message = "비밀번호가 없습니다")
    private String password;    // 회원 password
    public UserDTO(User user) {
        name = user.getName();
        nameId = user.getNameId();
        password = user.getPassword();
    }
    @Builder
    public UserDTO(String name, String nameId, String password) {
        this.name = name;
        this.nameId = nameId;
        this.password = password;
    }
    public User toEntity() {
        User user = User.builder()
                .name(name)
                .nameId(nameId)
                .password(password)
                .money(0L)
                .build();
        return user;
    }
}
