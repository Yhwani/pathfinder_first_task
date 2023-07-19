package first_task.first_task.service;

import first_task.first_task.repository.BaseRepository;
import first_task.first_task.service.interfaces.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BaseServiceImpl<ENTITY,ID> implements BaseService<ENTITY> {
    private final BaseRepository<ENTITY,ID> baseRepository;
    @Autowired(required = false)
    public BaseServiceImpl(BaseRepository<ENTITY, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
    @Override
    public void create(ENTITY en) {
        baseRepository.save(en);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ENTITY> read(ENTITY en) {
        return baseRepository.findAll();
    }
    @Override
    public void delete(ENTITY en) {
        baseRepository.delete(en);
    }
}