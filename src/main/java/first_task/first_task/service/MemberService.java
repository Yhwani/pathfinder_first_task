package first_task.first_task.service;

import first_task.first_task.entity.Member;

public interface MemberService {
    public Member loginCheck(String nameId, String password);
}
