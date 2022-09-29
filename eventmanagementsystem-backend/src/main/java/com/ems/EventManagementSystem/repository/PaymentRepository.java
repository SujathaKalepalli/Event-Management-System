package com.ems.EventManagementSystem.repository;




import com.ems.EventManagementSystem.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

/*@Repository*/
public interface PaymentRepository extends JpaRepository <Payment, Integer>{

}
