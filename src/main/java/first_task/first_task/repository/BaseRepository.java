package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<EN> extends JpaRepository<EN,Long> {
}
