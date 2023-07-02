package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String name;
    private Long price;

    @OneToOne(mappedBy = "order_product")
    private OrderProduct orderProduct;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User createBy;

}
