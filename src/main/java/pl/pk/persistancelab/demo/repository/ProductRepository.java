package pl.pk.persistancelab.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pk.persistancelab.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
