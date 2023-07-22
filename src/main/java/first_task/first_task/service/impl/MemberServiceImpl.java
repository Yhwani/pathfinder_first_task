package first_task.first_task.service.impl;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;
import first_task.first_task.exception.ErrorCode;
import first_task.first_task.exception.JoinException;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import first_task.first_task.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseServiceImpl<Member,Long> implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;
    @Autowired
    public MemberServiceImpl(
            @Qualifier("member")JpaRepository<Member, Long> jpaRepository,
            MemberRepository memberRepository,
            MemberQueryDslRepository memberQueryDslRepository) {
        super(jpaRepository);
        this.memberRepository = memberRepository;
        this.memberQueryDslRepository = memberQueryDslRepository;
    }

    @Override
    public Member loginCheck(String nameId, String password) {
        return memberRepository.findByNameId(nameId).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
    @Override
    @Transactional(readOnly = false)
    public void join(JoinDto joinDto) {
        memberRepository.findByNameId(joinDto.getNameId())
                .ifPresent( joinDto1 -> {
                    throw new JoinException(ErrorCode.DUPLICATED_USER_NAME, String.format("NameId : %s", joinDto1.getNameId()));
                });
        memberRepository.save(joinDto.toEntity());
    }


}
