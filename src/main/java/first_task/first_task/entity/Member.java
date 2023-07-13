package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    private String name;        // 회원이름
    private String nameId;      // 회원 id
    private String password;    // 회원 password
    private Long money;         // 회원이 가지고 있는 돈

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // 회원의 주문 목록

    @Builder
    public Member(String name, String nameId, String password, Long money) {
        this.name = name;
        this.nameId = nameId;
        this.password = password;
        this.money = money;
    }
}
