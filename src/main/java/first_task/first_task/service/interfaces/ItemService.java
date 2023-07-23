package first_task.first_task.service.interfaces;

import first_task.first_task.dto.item.ItemDto;
import first_task.first_task.dto.item.SearchDto;
import first_task.first_task.entity.Item;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService<ATT> {
    Item sell(ItemDto itemDto);
    List<Item> searchItem(SearchDto searchDto);

    List<Item> totalItem(Pageable pageable);
}
