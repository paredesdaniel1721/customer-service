package com.nttdata.customer.utils;

import com.nttdata.customer.dto.CustomerDto;
import com.nttdata.customer.entity.Customer;
import org.springframework.beans.BeanUtils;

public class Utils {
    public static CustomerDto entityToDto(Customer product) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(product, customerDto);
        return customerDto;
    }

    public static Customer dtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
