package com.ems.EventManagementSystem.controller;


	
	

	import java.util.ArrayList;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.ems.EventManagementSystem.entity.Payment;
	import com.ems.EventManagementSystem.service.PaymentService;


	//@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/payment")
	public class PaymentController {
		@Autowired
		private PaymentService paymentService;
		
		public PaymentService getPaymentService() {
		return paymentService;
		}

		public void setPaymentService(PaymentService paymentService) {
			this.paymentService = paymentService;
		}
		
		
		@GetMapping("/payments")
		public ArrayList<Payment> getAllTransactions(){
			return (ArrayList<Payment>) paymentService.getAllTransactions();
		}	
		
		@GetMapping("/payments/id/{transactionId}")
		public Payment gettransactionById(@PathVariable int transactionId) {
			return paymentService.getTransactionById(transactionId);
		}
		
		@GetMapping("/payments/date/{transactionDate}")
		public Payment gettransactionByDate(@PathVariable int transactionDate) {
			return paymentService.getTransactionById(transactionDate);
		}
		 
		@PostMapping("/add")
		public ResponseEntity<String> addPayment(@RequestBody Payment payment) {
		 paymentService.saveTransaction(payment);
			return new ResponseEntity<String>("Payment Added successfully with Id:"+payment.getTransactionId(),HttpStatus.OK);		
			
		}
		
		@DeleteMapping("/payment/delete/{transactionId}")
		public ResponseEntity<String> deletetransactionById(@PathVariable int transactionId) {	
			paymentService.deleteTransactionById(transactionId);
			return new ResponseEntity<String>("Payment Removed successfully with Id:"+transactionId, HttpStatus.OK);
		}
		
		@PutMapping("/payment/update/{transactionId}")
		public ResponseEntity<String> updatetransaction(@PathVariable int transactionId,
				@RequestBody Payment updatedTransaction) {
			paymentService.UpdateTransaction(transactionId, updatedTransaction);
			return new ResponseEntity<String>("Payment updated successfully with Id:"+transactionId, HttpStatus.OK);
			
		}	
	}

