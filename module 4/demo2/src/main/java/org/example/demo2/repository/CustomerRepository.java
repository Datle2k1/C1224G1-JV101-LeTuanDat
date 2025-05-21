package org.example.templatespirng_data_jpagradle.repository;

import org.example.templatespirng_data_jpagradle.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
