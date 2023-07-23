package first_task.first_task.service.impl;

import first_task.first_task.dto.member.JoinDto;
import first_task.first_task.dto.member.LoginDto;
import first_task.first_task.entity.Member;
import first_task.first_task.repository.MemberRepository;
import first_task.first_task.repository.querydsl.MemberQueryDslRepository;
import first_task.first_task.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService, UserDetailsService {

    private final MemberRepository memberRepository;
    private final MemberQueryDslRepository memberQueryDslRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImpl(
            @Qualifier("member") JpaRepository<Member, Long> jpaRepository,
            MemberRepository memberRepository,
            MemberQueryDslRepository memberQueryDslRepository, PasswordEncoder passwordEncoder) {
        super(jpaRepository);
        this.memberRepository = memberRepository;
        this.memberQueryDslRepository = memberQueryDslRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Member loginCheck(LoginDto loginDto) {
        return memberRepository.findByNameId(loginDto.getNameId()).
                filter(m -> m.getPassword().equals(loginDto.getPassword()))
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public Long join(JoinDto joinDto) {
        if (!memberQueryDslRepository.findMember(joinDto).isEmpty()) {
            throw new IllegalArgumentException("이미 있는 회원입니다");
        }
        return memberRepository.save(joinDto.toEntity()).getId();
    }

    @Override
    public Member loadUserByUsername(String nameId) throws UsernameNotFoundException {
        return memberRepository.findByNameId(nameId)
                .orElseThrow(() -> new IllegalArgumentException(nameId));
    }


}
