package first_task.first_task.service.interfaces;

import first_task.first_task.dto.request.RequestJoin;
import first_task.first_task.dto.request.RequestLogin;
import first_task.first_task.entity.Member;

public interface MemberService {
    public Member loginCheck(RequestLogin requestLogin);
    public Long join(RequestJoin requestJoin);
    public Member getLoginId(String loginId);
}
