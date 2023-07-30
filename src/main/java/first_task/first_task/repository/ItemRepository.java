package first_task.first_task.repository;

import first_task.first_task.entity.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("item")
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByName(String name);

    List<Item> findAllByPrice(Long price);

    List<Item> findAllByQuantity(Long quantity);

}
