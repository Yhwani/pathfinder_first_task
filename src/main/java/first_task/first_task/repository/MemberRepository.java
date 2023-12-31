package first_task.first_task.repository;

import first_task.first_task.entity.Member;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@Qualifier("member")
public interface MemberRepository extends MemberQueryDslRepository, JpaRepository<Member, Long> {
    Optional<Member> findByNameId(String nameId);

}
