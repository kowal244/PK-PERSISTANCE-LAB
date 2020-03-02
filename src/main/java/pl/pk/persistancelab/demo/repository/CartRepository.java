package pl.pk.persistancelab.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pk.persistancelab.demo.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
