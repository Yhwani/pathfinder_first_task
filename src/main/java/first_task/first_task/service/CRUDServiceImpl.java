package first_task.first_task.service;

import first_task.first_task.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CRUDServiceImpl<T1,T2> implements CRUDService<T1,T2>{

    private final BaseRepository<T2> baseRepository;
    @Autowired
    public CRUDServiceImpl(BaseRepository<T2> baseRepository) {
        this.baseRepository = baseRepository;
    }
    @Override
    public void create(T2 t2) {
        baseRepository.save(t2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T2> read() {
        return baseRepository.findAll();
    }

    @Override
    public void delete(T2 t2) {
        baseRepository.delete(t2);
    }
}
