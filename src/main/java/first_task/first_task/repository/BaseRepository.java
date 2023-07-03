package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T> extends JpaRepository<T,Long> {
    List<T> findByName(String name);
}
