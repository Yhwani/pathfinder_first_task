package first_task.first_task.dto.item;

import first_task.first_task.entity.Item;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemDto {

    @NotEmpty(message = "이름을 입력하세요")
    private String name;
    @NotEmpty(message = "갯수를 입력하세요")
    private Long quantity;
    @NotEmpty(message = "가격을 입력하세요")
    private Long price;

    @Builder
    public ItemDto(String name, Long quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();
    }
}
