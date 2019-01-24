/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.repository;

import com.davis.mpesa.model.Customer;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer>findByPhone(String phone);
    Boolean existsByPhone(String phone);
}
