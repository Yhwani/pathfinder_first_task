package first_task.first_task.repository.querydsl;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;

import java.util.List;

public interface MemberQueryDslRepository {
    List<Member> findMember(JoinDto joinDto);

}
