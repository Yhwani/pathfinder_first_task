package first_task.first_task.service;

import first_task.first_task.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class BaseService<EN>{
    private final BaseRepository<EN> baseRepository;
    @Autowired
    public BaseService(BaseRepository<EN> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public void create(EN en) {
        baseRepository.save(en);
    }

    @Transactional(readOnly = true)
    public List<EN> read() {
        return baseRepository.findAll();
    }

    public void delete(EN en) {
        baseRepository.delete(en);
    }
}
