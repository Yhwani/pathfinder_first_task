package first_task.first_task.service;

import first_task.first_task.entity.Member;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends CRUDServiceImpl<MemberRepository, Member> implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(BaseRepository<Member> baseRepository, MemberRepository memberRepository) {
        super(baseRepository);
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean loginCheck(Member member) {
        if (memberRepository.findByNameId(member.getNameId()).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
