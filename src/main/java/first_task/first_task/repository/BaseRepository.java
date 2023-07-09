package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T> extends JpaRepository<T,Long> {
    T findByName(String name);
}
