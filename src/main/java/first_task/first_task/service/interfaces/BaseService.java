package first_task.first_task.service.interfaces;
import java.util.List;

public interface BaseService<ENTITY> {
    public void create(ENTITY en);
    public List<ENTITY> read(ENTITY en);
    public void delete(ENTITY en);
}
