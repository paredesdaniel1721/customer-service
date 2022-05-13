package com.nttdata.customer.service;

import com.nttdata.customer.dto.CustomerDto;
import com.nttdata.customer.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> findAll();

    Mono<Customer> findById(String id);

    Mono<CustomerDto> save(Mono<CustomerDto> customerDto);

    Mono<CustomerDto> update(Mono<CustomerDto> customerDto, String id);

    Mono<Void> delete(String id);
}
