/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.payload;

/**
 *
 * @author david
 */
public class TransactionRequest {
    
    private String fromNumber;
    
    private String toNumber;
    
    private double amountSend;
    
    private  int pin;
    
    private String transactionType;

    public TransactionRequest() {
    }

    public TransactionRequest(String fromNumber, String toNumber, double amountSend, int pin, String transactionType) {
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
        this.amountSend = amountSend;
        this.pin = pin;
        this.transactionType = transactionType;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public double getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(double amountSend) {
        this.amountSend = amountSend;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    
}
