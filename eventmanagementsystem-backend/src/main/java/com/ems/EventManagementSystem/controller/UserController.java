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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.abc.onlinevegetablestore.dto.LoginResponseDTO;
import com.ems.EventManagementSystem.exception.ResourceNotFoundException;
import com.ems.EventManagementSystem.entity.User;
//import com.ems.EventManagementSystem.model.LoginResponse;
import com.ems.EventManagementSystem.repository.UserRepository;
//import com.abc.onlinevegetablestore.repository.LoginRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/v1")
	public class UserController {
		//@Autowired
		//private LoginRepository loginRepository;
			
		

		@Autowired
		private UserRepository userRepository;
		
		// get all employees
		@GetMapping("/users")
		public List<User> getAllUsers(){
			return userRepository.findAll();
		}		
		
		// create employee rest api
		@PostMapping("/users")
		public User createUser(@RequestBody User user) {
			return userRepository.save(user);
		}
		
		// get employee by id rest api
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable Long id) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			return ResponseEntity.ok(user);
		}
		
		// update employee rest api
		
		@PutMapping("/users/{id}")
		public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setEmailId(userDetails.getEmailId());
			
			User updatedUser = userRepository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
		
		// delete employee rest api
		@DeleteMapping("/users/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			
			userRepository.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
//		@GetMapping("/login")
//		public LoginResponseDTO validateUser(@PathVariable String username, @PathVariable String password){
//			LoginResponse response = loginRepository.findByUsername(username);
//			response.getPassword();
//			LoginResponseDTO resp = new LoginResponseDTO();
//			if(password.equals(response.getPassword())){
//				resp.setStatus("true");
//			}
//		else {
//			resp.setStatus("false");
//		}	
//			return resp;
//		}
		
		
		
	}

