package first_task.first_task.service;

import first_task.first_task.entity.User;

import java.util.List;

public interface UserService {
    void join(User user);
    User findUser(Long UserId);
    List<User> findAll();
}
