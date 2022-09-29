package com.ems.EventManagementSystem.entity;

	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;
	
	@Column(name = "Event_name")
	private String eventName;
	
	@Column(name = "Event_cost")
	private double eventCost;
	
	@Column(name = "Location")
	private String location;
	
	
	@Column(name = "From_DateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String fromDateTime;
	

	@Column(name = "To_DateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String toDateTime;

//	@Column(name = "Status")
//	private String  status;



	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Discount")
	private long discount;
	
//	@Column(name = "Discount_type")
//	private String discountType;
	
	
	
	


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Event(long eventId, String eventName, double eventCost, String location, String fromDateTime,
			String toDateTime, String status, int quantity, long discount, String discountType) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventCost = eventCost;
		this.location = location;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		//this.status = status;
		this.quantity = quantity;
		this.discount = discount;
		//this.discountType = discountType;
	}



	public long getEventId() {
		return eventId;
	}



	public void setEventId(long eventId) {
		this.eventId = eventId;
	}



	public String getEventName() {
		return eventName;
	}



	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public double getEventCost() {
		return eventCost;
	}



	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getFromDateTime() {
		return fromDateTime;
	}



	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}



	public String getToDateTime() {
		return toDateTime;
	}



	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//
//
//	public String getStatus() {
//		return status;
//	}
//
//
//
//	public void setStatus(String status) {
//		this.status = status;
//	}



	public long getDiscount() {
		return discount;
	}



	public void setDiscount(long discount) {
		this.discount = discount;
	}


//
//	public String getDiscountType() {
//		return discountType;
//	}
//
//
//
//	public void setDiscountType(String discountType) {
//		this.discountType = discountType;
//	}




	

}

