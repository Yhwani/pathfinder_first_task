package first_task.first_task.service.impl;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import first_task.first_task.service.impl.BaseServiceImpl;
import first_task.first_task.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImplImpl extends BaseServiceImpl<Member,Long> implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;
    @Autowired
    public MemberServiceImplImpl(
            BaseRepository<Member, Long> baseRepository,
            MemberRepository memberRepository,
            MemberQueryDslRepository memberQueryDslRepository) {
        super(baseRepository);
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
    public boolean joinCheck(JoinDto joinDto) {
        return !memberQueryDslRepository.findMember(joinDto).isEmpty();
    }
}
