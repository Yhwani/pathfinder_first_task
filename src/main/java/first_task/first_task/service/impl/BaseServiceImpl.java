package first_task.first_task.service.impl;

import first_task.first_task.service.interfaces.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BaseServiceImpl<ENTITY,ID>  implements BaseService<ENTITY> {

    private final JpaRepository<ENTITY,ID> jpaRepository;
    @Override
    public void create(ENTITY en) {
        jpaRepository.save(en);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ENTITY> read(ENTITY en) {
        return jpaRepository.findAll();
    }
    @Override
    public void delete(ENTITY en) {
        jpaRepository.delete(en);
    }
}