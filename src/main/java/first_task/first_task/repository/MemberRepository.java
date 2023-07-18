package first_task.first_task.repository;

import first_task.first_task.entity.Member;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends BaseRepository<Member,Long>, MemberQueryDslRepository {
    Optional<Member> findByNameId(String nameId);

}
