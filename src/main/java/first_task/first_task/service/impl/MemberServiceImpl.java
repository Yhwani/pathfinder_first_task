package first_task.first_task.service.impl;

import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.dto.request.RequestLogin;
import first_task.first_task.entity.Member;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import first_task.first_task.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService{

    private final MemberRepository memberRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;

    @Autowired
    public MemberServiceImpl(
            @Qualifier("member") JpaRepository<Member, Long> jpaRepository,
            MemberRepository memberRepository,
            MemberQueryDslRepository memberQueryDslRepository) {
        super(jpaRepository);
        this.memberRepository = memberRepository;
        this.memberQueryDslRepository = memberQueryDslRepository;
    }

    @Override
    public Member loginCheck(RequestLogin requestLogin) {
        return memberRepository.findByNameId(requestLogin.getNameId()).
                filter(m -> m.getPassword().equals(requestLogin.getPassword()))
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public Long join(RequestJoin requestJoin) {
        if (!memberQueryDslRepository.findMember(requestJoin).isEmpty()) {
            throw new IllegalArgumentException("이미 있는 회원입니다");
        }
        return memberRepository.save(requestJoin.toEntity()).getId();
    }
    @Override
    public Member getLoginId(String loginId) throws UsernameNotFoundException {
        return memberRepository.findByNameId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException(loginId + "의 회원이 존재하지 않습니다."));
    }

}
