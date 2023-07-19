package first_task.first_task.service.interfaces;

import first_task.first_task.dto.Member.JoinDto;
import first_task.first_task.entity.Member;

public interface MemberService<ENTITY> extends BaseService<ENTITY> {
    public Member loginCheck(String nameId, String password);
    public boolean joinCheck(JoinDto joinDto);
}
