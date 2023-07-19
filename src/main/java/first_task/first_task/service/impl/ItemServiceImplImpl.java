package first_task.first_task.service.impl;

import first_task.first_task.entity.Item;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.ItemRepository;
import first_task.first_task.repository.querydsl.ItemQueryDslRepository;
import first_task.first_task.service.impl.BaseServiceImpl;
import first_task.first_task.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ItemServiceImplImpl extends BaseServiceImpl<Item, Long> implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemQueryDslRepository itemQueryDslRepository;
    @Autowired
    public ItemServiceImplImpl(BaseRepository<Item, Long> baseRepository, ItemRepository itemRepository, ItemQueryDslRepository itemQueryDslRepository) {
        super(baseRepository);
        this.itemRepository = itemRepository;
        this.itemQueryDslRepository = itemQueryDslRepository;
    }
}
