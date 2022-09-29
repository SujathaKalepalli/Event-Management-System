package com.ems.EventManagementSystem.service;


	

	import java.util.List;
	import com.ems.EventManagementSystem.entity.Payment;

	public interface PaymentService {
		
		Payment getTransactionById(int transactionId);
		 Payment getTransactionByDate(int transactionDate);
		 List<Payment> getAllTransactions();
		 void saveTransaction(Payment payment);
		 void UpdateTransaction(int transactionId,Payment payment);
		 void deleteTransactionById(int transactionId);
		 void deleteTransactionByDate(int transactionDate);
		 
		 // Payment findByTransactionId(int transactionId);
//		 Payment findByTransactionDate(int transactionDate);
		 }




