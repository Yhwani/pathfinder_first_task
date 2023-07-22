package first_task.first_task.service.interfaces;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;

public interface MemberService {
    public Member loginCheck(String nameId, String password);
    public Long join(JoinDto joinDto);
}
