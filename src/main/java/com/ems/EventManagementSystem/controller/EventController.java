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

import com.ems.EventManagementSystem.exception.ResourceNotFoundException;
import com.ems.EventManagementSystem.entity.Event;
import com.ems.EventManagementSystem.repository.EventRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EventController {
	@Autowired
	private EventRepository eventRepository;

	// get all jobs
	@GetMapping("/events")
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	// create job rest api
	@PostMapping("/add")
	public String createEvent(@RequestBody Event event) {
		eventRepository.save(event);
		return "success";

	}

	// get jobs by id rest api
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("event not exist with id :" + id));
		return ResponseEntity.ok(event);
	}

	// update employee rest api

	@PutMapping("/events/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("event not exist with id :" + id));

		event.setEventName(eventDetails.getEventName());
		event.setEventCost(eventDetails.getEventCost());
		event.setLocation(eventDetails.getLocation());
		event.setFromDateTime(eventDetails.getFromDateTime());
		event.setToDateTime(eventDetails.getToDateTime());
		// event.setStatus(eventDetails.getStatus());
		event.setQuantity(eventDetails.getQuantity());
		event.setDiscount(eventDetails.getDiscount());
		// event.setDiscountType(eventDetails.getDiscountType());

		Event updatedEvent = eventRepository.save(event);
		return ResponseEntity.ok(updatedEvent);
	}

	// delete employee rest api
	@DeleteMapping("/events/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEvent(@PathVariable Long id) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("event not exist with id :" + id));

		eventRepository.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
