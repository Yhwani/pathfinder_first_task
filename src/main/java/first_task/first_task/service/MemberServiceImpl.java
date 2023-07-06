package first_task.first_task.service;

import first_task.first_task.entity.Member;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.MemberRepository;

public class MemberServiceImpl extends CRUDServiceImpl<MemberRepository, Member> implements MemberService {
    public MemberServiceImpl(BaseRepository<Member> baseRepository) {
        super(baseRepository);
    }

}
