package org.example.casestudy.repository;

import org.example.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<User, Long>{
    List<User> getCustomersByEmail(String email);
    User getFirstByEmail(String email);
}