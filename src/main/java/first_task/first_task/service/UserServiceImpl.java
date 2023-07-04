package first_task.first_task.service;

import first_task.first_task.entity.User;
import first_task.first_task.repository.BaseRepository;
import first_task.first_task.repository.UserRepository;

public class UserServiceImpl extends CRUDServiceImpl<UserRepository,User> implements UserService{
    public UserServiceImpl(BaseRepository<User> baseRepository) {
        super(baseRepository);
    }

}
