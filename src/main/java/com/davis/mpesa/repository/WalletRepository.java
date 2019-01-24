/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.repository;

import com.davis.mpesa.model.Wallet;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID>{
    Optional<Wallet> findByPhone(String phoneNo);   
    Boolean existsByPhone(String phone);     
    Boolean existsByPhoneAndPin(String phone,int pin);
    
}
