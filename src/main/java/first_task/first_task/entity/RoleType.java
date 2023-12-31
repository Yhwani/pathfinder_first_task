package first_task.first_task.entity;

import lombok.Getter;

@Getter
public enum RoleType {
    Member("ROLE_MEMBER"), ADMIN("ROLE_ADMIN");
    private String value;

    RoleType(String value) {
        this.value = value;
    }
}
