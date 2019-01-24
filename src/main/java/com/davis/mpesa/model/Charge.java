/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tbl_charges")
public class Charge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "charge_id")
    private Long id;
    
    @NotBlank
    @Column(name = "min_amount")
    private int minAmount;
    
    @NotBlank
    @Column(name = "max_amount")
    private int maxAmount;
    
    @NotBlank
    @Column(name = "withdraw_charge")
    private int withdrawCharge;
    
    @NotBlank
    @Column(name = "send_to_unregistered")
    private int sendToUnregistered;
    
    @NotBlank
    @Column(name ="send_to_registered")
    private int sendToRegistered;

    public Charge() {
    }

    public Charge(Long id, int minAmount, int maxAmount, int withdrawCharge, int sendToUnregistered, int sendToRegistered) {
        this.id = id;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.withdrawCharge = withdrawCharge;
        this.sendToUnregistered = sendToUnregistered;
        this.sendToRegistered = sendToRegistered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getWithdrawCharge() {
        return withdrawCharge;
    }

    public void setWithdrawCharge(int withdrawCharge) {
        this.withdrawCharge = withdrawCharge;
    }

    public int getSendToUnregistered() {
        return sendToUnregistered;
    }

    public void setSendToUnregistered(int sendToUnregistered) {
        this.sendToUnregistered = sendToUnregistered;
    }

    public int getSendToRegistered() {
        return sendToRegistered;
    }

    public void setSendToRegistered(int sendToRegistered) {
        this.sendToRegistered = sendToRegistered;
    }
    
    
    
}
