package first_task.first_task.service.impl;

import first_task.first_task.repository.BaseRepository;
import first_task.first_task.service.interfaces.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseServiceImpl<ENTITY,ID>  implements BaseService<ENTITY> {

    private final BaseRepository<ENTITY,ID> baseRepository;
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