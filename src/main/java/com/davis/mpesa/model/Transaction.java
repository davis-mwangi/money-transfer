/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author david
 */
@Entity
@Table(name ="tbl_main_transactions")
public class Transaction {
   
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name ="transaction_id", columnDefinition = "BINARY(16)")
    private UUID id;
    
    @NotBlank
    private String requestId;
    
    @Column(name = "partya")
    private String partyA;
    
    @Column(name = "partyb")
    private String partyB;
    
    private double amount;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date transactionDate;
    
    private String status;
    
    private int charge;

    public Transaction() {
        this.transactionDate = new Date();
    }

    public Transaction(UUID id, String requestId, String partyA, String partyB, double amount, String status, int charge) {
        this.transactionDate = new Date();
        this.id = id;
        this.requestId = requestId;
        this.partyA = partyA;
        this.partyB = partyB;
        this.amount = amount;
        this.status = status;
        this.charge = charge;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    
        
}
