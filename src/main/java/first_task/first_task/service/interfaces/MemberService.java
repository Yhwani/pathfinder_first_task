package first_task.first_task.service.interfaces;

import first_task.first_task.dto.member.JoinDto;
import first_task.first_task.dto.member.LoginDto;
import first_task.first_task.entity.Member;

public interface MemberService {
    public Member loginCheck(LoginDto loginDto);
    public Long join(JoinDto joinDto);
}
