package com.nttdata.customer.controller;

import com.nttdata.customer.dto.CustomerDto;
import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Flux<Customer>> getAllCustomers() {
        return new ResponseEntity<Flux<Customer>>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Customer>> getCustomer(@PathVariable String id) {
        log.info("Fetching Customer with id {}", id);
        return new ResponseEntity<Mono<Customer>>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<CustomerDto>> createCustomer(@RequestBody Mono<CustomerDto> customerDto) {
        return new ResponseEntity<Mono<CustomerDto>>(customerService.save(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<CustomerDto>> updateCustomer(@RequestBody Mono<CustomerDto> customerDto, @PathVariable String id) {
        return new ResponseEntity<Mono<CustomerDto>>(customerService.update(customerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteCustomer(@PathVariable String id){
        return new ResponseEntity<Mono<Void>>(customerService.delete(id), HttpStatus.OK);
    }
}
