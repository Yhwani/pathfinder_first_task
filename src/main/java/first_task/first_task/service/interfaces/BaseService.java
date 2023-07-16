package first_task.first_task.service.interfaces;

import first_task.first_task.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public abstract class BaseService<ENTITY,ID> {

    private final BaseRepository<ENTITY,ID> baseRepository;
    @Autowired(required = false)
    public BaseService(BaseRepository<ENTITY, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public void create(ENTITY en) {
        baseRepository.save(en);
    }

    @Transactional(readOnly = true)
    public List<ENTITY> read(ENTITY en) {
        return baseRepository.findAll();
    }

    public void delete(ENTITY en) {
        baseRepository.delete(en);
    }
}