package first_task.first_task.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;
import first_task.first_task.entity.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberQueryDslRepositoryImpl<ATT> implements MemberQueryDslRepository {

    private final JPAQueryFactory queryFactory;
    private final QMember qMember = QMember.member;

    @Override
    public List<Member> findMember(JoinDto joinDto) {
        return queryFactory.selectFrom(qMember)
                .where(
                        qMember.name.eq(joinDto.getName()),
                        qMember.nameId.eq(joinDto.getNameId()),
                        qMember.password.eq(joinDto.getPassword()))
                .fetch();
    }

    private BooleanExpression nameEq(String nameCond) {
        return nameCond != null ? qMember.name.eq(nameCond) : null;
    }

    private BooleanExpression nameIdEq(String nameIdCond) {
        return nameIdCond != null ? qMember.nameId.eq(nameIdCond) : null;
    }

}
