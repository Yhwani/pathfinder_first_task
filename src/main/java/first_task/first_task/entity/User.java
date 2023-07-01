package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;        // 회원이름
    private String nameId;      // 회원 id
    private String password;    // 회원 password

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); //회원의 주문 목록
}
