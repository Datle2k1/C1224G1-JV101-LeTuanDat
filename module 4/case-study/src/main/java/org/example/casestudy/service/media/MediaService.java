package org.example.casestudy.service.customer;

import org.example.casestudy.model.Customer;
import org.example.casestudy.model.Media;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);

    //media
    void saveMedia(Media media);
}
