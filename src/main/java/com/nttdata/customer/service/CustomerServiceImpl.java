package com.nttdata.customer.service;

import com.nttdata.customer.dto.CustomerDto;
import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import com.nttdata.customer.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<CustomerDto> save(Mono<CustomerDto> customerDto) {
        return customerDto.map(Utils::dtoToEntity)
                .flatMap(customerRepository::insert)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<CustomerDto> update(Mono<CustomerDto> customerDto, String id) {
        return customerRepository.findById(id)
                .flatMap(c -> customerDto.map(Utils::dtoToEntity))
                .doOnNext(e -> e.setId(id))
                .flatMap(customerRepository::save)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }
}
