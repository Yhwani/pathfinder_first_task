package first_task.first_task.service.impl;

import first_task.first_task.dto.item.ItemDto;
import first_task.first_task.dto.item.SearchDto;
import first_task.first_task.entity.Item;
import first_task.first_task.repository.ItemRepository;
import first_task.first_task.repository.querydsl.ItemQueryDslRepository;
import first_task.first_task.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ItemServiceImpl extends BaseServiceImpl<Item, Long> implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemQueryDslRepository itemQueryDslRepository;

    @Autowired
    public ItemServiceImpl(@Qualifier("item") JpaRepository<Item, Long> jpaRepository,
                           ItemRepository itemRepository,
                           ItemQueryDslRepository itemQueryDslRepository) {
        super(jpaRepository);
        this.itemRepository = itemRepository;
        this.itemQueryDslRepository = itemQueryDslRepository;
    }

    @Override
    public Item sell(ItemDto itemDto) {
        return itemRepository.save(itemDto.toEntity());
    }

    @Override
    public List<Item> searchItem(SearchDto searchDto) {
        if (searchDto.getContext() == null || searchDto.getAttribute() == null) {
            throw new NullPointerException("값을 제대로 입력해주세요");
        }
        return itemQueryDslRepository.searchAttribute(searchDto);
    }

    @Override
    public List<Item> totalItem(Pageable pageable) {
        return null;
    }
}
