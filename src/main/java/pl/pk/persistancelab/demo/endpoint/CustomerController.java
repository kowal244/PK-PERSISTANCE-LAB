package pl.pk.persistancelab.demo.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pk.persistancelab.demo.entity.Customer;
import pl.pk.persistancelab.demo.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @RequestMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity create(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping
    @RequestMapping("/find/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customers = customerService.findById(id);
        if (!customers.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customers.get());
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        if (!customerService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        customerService.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
