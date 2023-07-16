package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<ENTITY,ID> extends JpaRepository<ENTITY,ID> {
}
