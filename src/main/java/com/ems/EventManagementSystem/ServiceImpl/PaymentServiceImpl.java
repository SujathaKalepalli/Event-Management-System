package com.ems.EventManagementSystem.ServiceImpl;


	
	

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.ems.EventManagementSystem.exception.TransactionNotFoundException;
	import com.ems.EventManagementSystem.entity.Payment;
	import com.ems.EventManagementSystem.repository.PaymentRepository;
	import com.ems.EventManagementSystem.service.PaymentService;
	@Service
	public class PaymentServiceImpl implements PaymentService{

	//@Autowired
		private PaymentRepository paymentRepository;
		

		@Override
		public Payment getTransactionById(int transactionId) {
			Optional<Payment>opt= paymentRepository.findById(transactionId);
			if(!opt.isPresent()) {
				throw new TransactionNotFoundException();
			}
			return opt.get();
		}

		@Override
		public Payment getTransactionByDate(int transactionDate) {
			Optional<Payment>opt= paymentRepository.findById(transactionDate);
			if(!opt.isPresent()) {
				throw new TransactionNotFoundException();
			}
			return opt.get();
		}

		@Override
		public List<Payment> getAllTransactions() {
			// TODO Auto-generated method stub
			return (List<Payment>) paymentRepository.findAll();
		}

		@Override
		public void saveTransaction(Payment payment) {
			paymentRepository.save(payment);
			
		}

		@Override

		public void UpdateTransaction(int transactionId,Payment payment) {
			deleteTransactionById(transactionId);
			saveTransaction(payment);
			
		}

		@Override
		public void deleteTransactionById(int transactionId) {
			paymentRepository.findById(transactionId);
			paymentRepository.deleteById(transactionId);
			
		}
		

		@Override
		public void deleteTransactionByDate(int transactionDate) {
			paymentRepository.findById(transactionDate);
			paymentRepository.deleteById(transactionDate);
			
		}

//		@Override
//		public Payment findByTransactionId(int transactionId) {
//			paymentRepository.findByTransactionId(transactionId);
//			return null;
//		}
	//
//		@Override
//		public Payment findByTransactionDate(int transactionDate) {
//			paymentRepository.findByTransactionId(transactionDate);
//			return null;
//		}

	

}
