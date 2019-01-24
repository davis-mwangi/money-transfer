/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.model;

import com.davis.mpesa.model.audit.DateAudit;
import static java.lang.Long.max;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tbl_business_accounts")
public class Account extends DateAudit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name ="account_id", columnDefinition = "BINARY(16)")
    private UUID id;
    
    @NotBlank
    @Size(max=6)
    private int accountNumber;
    
    @NotBlank
    private String accountName;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private int accountBalance;
    
    @NotBlank
    private String lastActivity;
    
    public Account() {
    }

    public Account(UUID id, int accountNumber, String accountName, String status, int accountBalance, String lastActivity) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.status = status;
        this.accountBalance = accountBalance;
        this.lastActivity = lastActivity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity;
    }

    
    
}
