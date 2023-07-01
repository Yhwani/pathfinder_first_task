package first_task.first_task.repository;

import first_task.first_task.entity.User;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository {
    void save(User user);
    User findById(Long userId);
    List<User> findAll();
}
