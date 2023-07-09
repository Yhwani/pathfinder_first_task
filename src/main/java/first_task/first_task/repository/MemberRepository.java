package first_task.first_task.repository;

import first_task.first_task.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends BaseRepository<Member> {
    Optional<Member> findByNameId(String nameId);
}
