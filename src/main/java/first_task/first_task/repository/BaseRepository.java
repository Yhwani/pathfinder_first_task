package first_task.first_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<EN> extends JpaRepository<EN,Long> {
}
