package first_task.first_task.service;

import first_task.first_task.entity.User;
import first_task.first_task.repository.UserRepositoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {
    private final UserRepositoryForm userRepositoryForm;
    @Autowired
    public UserServiceImpl(UserRepositoryForm userRepositoryForm) {
        this.userRepositoryForm = userRepositoryForm;
    }

    @Override
    @Transactional
    public void join(User user) {
        if (!userRepositoryForm.validation(user).isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        userRepositoryForm.save(user);
    }
    @Override
    public User findUser(Long userId) {
        return userRepositoryForm.findById(userId);
    }
    @Override
    public List<User> findAll() {
        return userRepositoryForm.findAll();
    }
}
