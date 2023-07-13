package first_task.first_task.repository;

import first_task.first_task.entity.Item;
import first_task.first_task.entity.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MemberRepository extends BaseRepository<Member> {
    Optional<Member> findByNameId(String nameId);
}
