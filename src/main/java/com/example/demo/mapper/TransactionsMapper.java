package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Transactions;

public class TransactionsMapper {
    public static Transactions mapToTransactions(TransactionDto transactionDto){
        Transactions transaction=new Transactions();
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setPaymentMethod(transactionDto.getPayment_method());
        return transaction;
    }
    public static TransactionDto mapToTransactionsDto(Transactions transaction){
        TransactionDto transactionDto=new TransactionDto();
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setPayment_method(transaction.getPaymentMethod());
        transactionDto.setId(transaction.getId());
        return transactionDto;
    }
}
