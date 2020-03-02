package pl.pk.persistancelab.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pk.persistancelab.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
