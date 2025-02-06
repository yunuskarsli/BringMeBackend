package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Transaction;

public class TransactionsMapper {
    public static Transaction mapToTransactions(TransactionDto transactionDto){
        Transaction transaction=new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setPayment_method(transactionDto.getPayment_method());
        return transaction;
    }
    public static TransactionDto mapToTransactionsDto(Transaction transaction){
        TransactionDto transactionDto=new TransactionDto();
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setPayment_method(transaction.getPayment_method());
        transactionDto.setId(transaction.getId());
        return transactionDto;
    }
}
