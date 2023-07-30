package first_task.first_task.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.entity.Member;
import first_task.first_task.entity.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Primary
public class MemberQueryDslRepositoryImpl implements MemberQueryDslRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<Member> findMember(RequestJoin requestJoin) {
        QMember qMember = QMember.member;
        return queryFactory.selectFrom(qMember)
                .where(
                        qMember.name.eq(requestJoin.getName()),
                        qMember.nameId.eq(requestJoin.getNameId()),
                        qMember.password.eq(requestJoin.getPassword()))

                .fetch();
    }
}
