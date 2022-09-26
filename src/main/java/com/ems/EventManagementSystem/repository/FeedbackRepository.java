package com.ems.EventManagementSystem.repository;

	


	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.ems.EventManagementSystem.entity.Feedback;

	@Repository
	public interface FeedbackRepository extends JpaRepository<Feedback, Long > {

		//List<Feedback> getAllFeedback();

		//List<Feedback> findByid();

		

	}



