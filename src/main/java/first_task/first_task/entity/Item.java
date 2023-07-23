package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {

    private String name;
    private Long quantity;
    private Long price;

    @Builder
    public Item(String name, Long quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

}
