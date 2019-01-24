/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davis.mpesa.controller;

import com.davis.mpesa.exception.BadRequestException;
import com.davis.mpesa.model.Transaction;
import com.davis.mpesa.model.Wallet;
import com.davis.mpesa.payload.ApiResponse;
import com.davis.mpesa.payload.TransactionRequest;
import com.davis.mpesa.repository.AccountRepository;
import com.davis.mpesa.repository.ChargeRepository;
import com.davis.mpesa.repository.CustomerRepository;
import com.davis.mpesa.repository.SubTransactionRepository;
import com.davis.mpesa.repository.TransactionRepository;
import com.davis.mpesa.repository.WalletRepository;
import com.davis.mpesa.service.TransactionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    
    @Autowired
    private TransactionService  transactionService;
    
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
    
    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest request) {
        
        if(!walletRepository.existsByPhone(request.getFromNumber())){
            return new ResponseEntity(new ApiResponse(false, request.getFromNumber() + "does not exist"),
                    HttpStatus.BAD_REQUEST);
        }
        
        if(!walletRepository.existsByPhoneAndPin(request.getFromNumber(), request.getPin())){
            return new ResponseEntity(new ApiResponse(false, "Transaction Failed! Please provide a valid pin"),
                    HttpStatus.BAD_REQUEST);
        }
       
                  
        if(!customerRepository.existsByPhone(request.getToNumber()) && !walletRepository.existsByPhone(request.getToNumber())){
            return new ResponseEntity(new ApiResponse(false, "The number " + request.getToNumber() +" you sending money to does not exist"),
                    HttpStatus.BAD_REQUEST);
        }
        
        if(request.getAmountSend() > 70000){
            return new ResponseEntity(new ApiResponse(false, "Maximum transaction amount exceeded"),
                    HttpStatus.BAD_REQUEST);
        }
        
        Wallet wallet = walletRepository.findByPhone(request.getFromNumber())
                .orElseThrow(() -> new BadRequestException( "Number not found"));
        if(wallet.getAccountBalance() < request.getAmountSend()){
           return new ResponseEntity(new ApiResponse(false, "Transaction failed due to insufficient funds! Current balance is " + wallet.getAccountBalance() ),
                    HttpStatus.BAD_REQUEST);
        } else {
            transactionService.deductWalletAmount(request);
        }
        
        
        Transaction transaction = transactionService.createTransaction(request);
       

        return ResponseEntity.ok(new ApiResponse(true, "Transaction successfull"));
              
    }

    
}
