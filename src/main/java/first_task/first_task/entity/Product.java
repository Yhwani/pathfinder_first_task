package first_task.first_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User createBy; // 상품을 올린 유저

}
