package first_task.first_task.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CRUDService<T1,T2>{
    void create(T2 t2);
    @Transactional(readOnly = true)
    List<T2> read();
    void delete(T2 t2);
}
