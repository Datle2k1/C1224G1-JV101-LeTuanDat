package org.example.templatespirng_data_jpagradle.service;

import org.example.templatespirng_data_jpagradle.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
