package first_task.first_task.service.impl;

import first_task.first_task.entity.Item;
import first_task.first_task.repository.ItemRepository;
import first_task.first_task.repository.querydsl.ItemQueryDslRepository;
import first_task.first_task.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ItemServiceImpl extends BaseServiceImpl<Item, Long> implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemQueryDslRepository itemQueryDslRepository;
    @Autowired
    public ItemServiceImpl(@Qualifier("item")JpaRepository<Item, Long> jpaRepository, ItemRepository itemRepository, ItemQueryDslRepository itemQueryDslRepository) {
        super(jpaRepository);
        this.itemRepository = itemRepository;
        this.itemQueryDslRepository = itemQueryDslRepository;
    }
}
