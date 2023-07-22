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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService, UserDetailsService {

    private final MemberRepository memberRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(
            @Qualifier("member") JpaRepository<Member, Long> jpaRepository,
            MemberRepository memberRepository,
            MemberQueryDslRepository memberQueryDslRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(jpaRepository);
        this.memberRepository = memberRepository;
        this.memberQueryDslRepository = memberQueryDslRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Member loginCheck(String nameId, String password) {
        return memberRepository.findByNameId(nameId).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public Long join(JoinDto joinDto) {
        return memberRepository.save(joinDto.toEntity()).getId();
    }

    @Override
    public Member loadUserByUsername(String nameId) throws UsernameNotFoundException {
        return memberRepository.findByNameId(nameId)
                .orElseThrow(() -> new IllegalArgumentException(nameId));
    }


}
