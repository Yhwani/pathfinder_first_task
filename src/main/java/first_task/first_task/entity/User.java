package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
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
    private Long money;         // 회원이 가지고 있는 돈

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>(); // 회원의 주문 목록

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>(); // 회원이 파는 물건 목록

    @Builder
    public User(String name, String nameId, String password, Long money) {
        this.name = name;
        this.nameId = nameId;
        this.password = password;
        this.money = money;
    }
}
