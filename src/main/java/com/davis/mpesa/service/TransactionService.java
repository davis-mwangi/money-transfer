/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.service;

import com.davis.mpesa.exception.BadRequestException;
import com.davis.mpesa.exception.ResourceNotFoundException;
import com.davis.mpesa.model.Customer;
import com.davis.mpesa.model.SubTransaction;
import com.davis.mpesa.model.Transaction;
import com.davis.mpesa.model.Wallet;
import com.davis.mpesa.payload.TransactionRequest;
import com.davis.mpesa.repository.AccountRepository;
import com.davis.mpesa.repository.ChargeRepository;
import com.davis.mpesa.repository.CustomerRepository;
import com.davis.mpesa.repository.SubTransactionRepository;
import com.davis.mpesa.repository.TransactionRepository;
import com.davis.mpesa.repository.WalletRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class TransactionService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private WalletRepository walletRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private SubTransactionRepository subTransactionRepository;
    
    @Autowired 
    private ChargeRepository chargeRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
   
    
    public Transaction createTransaction(TransactionRequest request){
        
        Date now =new Date();   
        
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmountSend());
        transaction.setPartyA(request.getFromNumber());
        transaction.setPartyB(request.getToNumber());
        
        
        transaction.setCharge(checkWithdrawCharge(request.getAmountSend()));
        transaction.setStatus("confirmed");
       
        transaction.setTransactionDate(now);
        
        String receipt = createSalt();
        transaction.setRequestId(receipt);
        
        SubTransaction subTransaction =  new SubTransaction();
        subTransaction.setTransactionType(request.getTransactionType());
        subTransaction.setPhone(request.getFromNumber());
        subTransaction.setReceipt(createSalt());
        subTransaction.setAmountType("charge");
        subTransaction.setRequestId(receipt);
        subTransactionRepository.save(subTransaction);
        
        
        return transactionRepository.save(transaction); 
    }
     
    
    public String createSalt() {
        String s = "";
        double d;
        for (int i = 1; i <= 16; i++) {
            d = Math.random() * 10;
            s = s + ((int)d);
            if (i % 4 == 0 && i != 16) {
                s = s + "-";
            }
        }
        return s;
   }
    
    
    public void deductWalletAmount(TransactionRequest request) {
        Date now =new Date();
        Wallet wallet;
        wallet = walletRepository.findByPhone(request.getFromNumber())
                .orElseThrow(() -> new BadRequestException( "Number not found"));
        
        wallet.setAccountBalance(wallet.getAccountBalance() - (request.getAmountSend() + checkTransferCharge(request.getAmountSend(), request.getToNumber())));
        wallet.setRegDate(now);
        walletRepository.save(wallet);
        
        wallet = walletRepository.findByPhone(request.getToNumber())
               .orElseThrow(() -> new BadRequestException( "Number not found"));
        wallet.setAccountBalance(wallet.getAccountBalance() + request.getAmountSend());
        walletRepository.save(wallet);
        
    }
    
    
    public double deductAmount(double  currentAmount, double amountSent){
        double balance = 0;
        balance = currentAmount - (amountSent + checkWithdrawCharge(amountSent));
        return balance;   
    }
    
    
    public int checkWithdrawCharge(double amount) {
        
         int chargeAmount = 0; 
         if( amount > 0 && amount < 1000) {
              chargeAmount = 0;
         }else if(amount >= 1001 && amount <= 10000){
              chargeAmount = 112;
         }else if(amount >= 10001 && amount <= 30000) {
               chargeAmount = 180;
         }else if(amount >= 30001 && amount <= 50000){
               chargeAmount = 270;
         }else if(amount >= 50001 && amount <= 70000){
               chargeAmount = 300;
         }
        return chargeAmount;
    }
    
    //Check sending charge
    public int checkTransferCharge(double amount, String recipientNo){
        
      int chargeAmount = 0;
      
      if(walletRepository.existsByPhone(recipientNo)){
        
         if( amount > 0 && amount < 1000) {
              chargeAmount = 0;
         }else if(amount >= 1001 && amount <= 10000){
              chargeAmount = 87;
         }else if(amount >= 10001 && amount <= 30000) {
               chargeAmount = 102;
         }else if(amount >= 30001 && amount <= 50000){
               chargeAmount = 105;
         }else if(amount >= 50001 && amount <= 70000){
               chargeAmount = 105;
         }
         
      } else if(customerRepository.existsByPhone(recipientNo) && !walletRepository.existsByPhone(recipientNo)){
         
          if( amount > 0 && amount < 1000) {
              chargeAmount = 0;
         }else if(amount >= 1001 && amount <= 10000){
              chargeAmount = 205;
         }else if(amount >= 10001 && amount <= 30000) {
               chargeAmount = 288;
         }
      
      }
    return chargeAmount;
    
    }
    
}
