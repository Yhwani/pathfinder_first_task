package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseRepository<T> extends JpaRepository<T,Long> {
    List<T> findByName(String name);
}
