package first_task.first_task.service.interfaces;

import java.util.List;

public interface BaseService<ENTITY> {
    void create(ENTITY en);

    List<ENTITY> read(ENTITY en);

    void delete(ENTITY en);

}
