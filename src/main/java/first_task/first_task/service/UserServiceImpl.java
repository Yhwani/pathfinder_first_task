package first_task.first_task.service;

import first_task.first_task.entity.User;
import first_task.first_task.repository.MysqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final MysqlUserRepository mysqlUserRepository;
    @Autowired
    public UserServiceImpl(MysqlUserRepository mysqlUserRepository) {
        this.mysqlUserRepository = mysqlUserRepository;
    }
    @Override
    public void join(User user) {
        if (!mysqlUserRepository.findByName(user.getName()).isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        mysqlUserRepository.save(user);
    }
    @Override
    public User findUser(Long userId) {
        return mysqlUserRepository.findById(userId);
    }
    @Override
    public List<User> findAll() {
        return mysqlUserRepository.findAll();
    }
}
