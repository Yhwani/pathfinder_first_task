package first_task.first_task.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createAt;
    @Column(updatable = false)
    private String createBy;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createAt = now;
    }

}
