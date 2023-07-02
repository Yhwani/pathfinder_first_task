package first_task.first_task.repository;

import first_task.first_task.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryForm implements UserRepository{

    private final EntityManager em;
    @Override
    public void save(User user) {
        em.persist(user);
    }
    @Override
    public User findById(Long userId) {
        return em.find(User.class,userId);
    }
    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
    @Override
    public List<User> validation(User user) {
        return em.createQuery("select u from User u where u.name = :name or u.nameId = :namdId or u.password = :password", User.class)
                .setParameter("name", user.getName())
                .setParameter("nameId", user.getNameId())
                .setParameter("password", user.getPassword())
                .getResultList();
    }
}