package first_task.first_task.repository.querydsl;

import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.entity.Member;

import java.util.List;

public interface MemberQueryDslRepository {
    List<Member> findMember(RequestJoin requestJoin);

}
