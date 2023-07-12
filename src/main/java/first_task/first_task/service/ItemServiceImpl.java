package first_task.first_task.service;

import first_task.first_task.entity.Item;
import first_task.first_task.repository.BaseRepository;


public class ItemServiceImpl extends BaseService<Item> implements ItemService {
    public ItemServiceImpl(BaseRepository<Item> baseRepository) {
        super(baseRepository);
    }
}
