package pl.pk.persistancelab.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.pk.persistancelab.demo.entity.Customer;
import pl.pk.persistancelab.demo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component

@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public void deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long customerId){
        return customerRepository.findById(customerId);
    }
}
