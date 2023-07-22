package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity implements UserDetails {

    private String name;        // 회원이름
    private String nameId;      // 회원 id
    private String password;    // 회원 password
    private Long money;         // 회원이 가지고 있는 돈

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // 회원의 주문 목록

    private RoleType roleType;

    @Builder
    public Member(String name, String nameId, String password, Long money, RoleType roleType) {
        this.name = name;
        this.nameId = nameId;
        this.password = password;
        this.money = money;
        this.roleType = roleType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("member"));
    }

    @Override
    public String getUsername() {
        return nameId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
