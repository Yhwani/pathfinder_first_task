package first_task.first_task.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import first_task.first_task.dto.item.ItemDto;
import first_task.first_task.dto.item.SearchDto;
import first_task.first_task.entity.Item;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemQueryDslRepository {
    List<Item> searchAttribute(SearchDto searchDto);
    PageImpl<ItemDto> itemPage(Pageable pageable);

    BooleanBuilder judgeAttribute(SearchDto searchDto);
}
