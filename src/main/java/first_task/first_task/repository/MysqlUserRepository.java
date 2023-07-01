package first_task.first_task.repository;

import first_task.first_task.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MysqlUserRepository implements UserRepository{

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
    public List<User> findByName(String name) {
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name",name)
                .getResultList();
    }
}