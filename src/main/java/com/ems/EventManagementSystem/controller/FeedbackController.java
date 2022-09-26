package com.ems.EventManagementSystem.controller;


	
	



	import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.ems.EventManagementSystem.entity.Feedback;
import com.ems.EventManagementSystem.entity.User;
import com.ems.EventManagementSystem.exception.ResourceNotFoundException;
import com.ems.EventManagementSystem.repository.FeedbackRepository;
	//import com.ems.EventManagementSystem.service.FeedbackService;

    @CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/Feedback")
	public class FeedbackController {
		@Autowired
	public	FeedbackRepository feedbackRepository;
		@GetMapping("/view")
		public List <Feedback> getAllFeedback(){
			
			return feedbackRepository.findAll();
		}   
		
		
		
			
			
			
		@PostMapping("/add")
		public Feedback insertFeedback(@RequestBody Feedback feedback) {
			
			return feedbackRepository.save(feedback);
			
		}
		
		// get jobs by id rest api
	    // @GetMapping("/view/{id}")
	    // public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
	       //  Feedback feedback = feedbackService.findById(Long id);
	                /* .orElseThrow(() -> new ResourceNotFoundException("event not exist with id :" + id));*/
	      //   return ResponseEntity.ok(feedback);
	    // }


		@DeleteMapping("/feedback/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
			Feedback feedback = feedbackRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			
			feedbackRepository.delete(feedback);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		

	}



