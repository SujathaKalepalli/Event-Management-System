package com.ems.EventManagementSystem.entity;


	
	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="feedback")
	public class Feedback {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long feedbackId;
		private String comment;
		
		
		public Feedback() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Feedback(Long feedbackId, String comment) {
			super();
			this.feedbackId = feedbackId;
			this.comment = comment;
		}
		public Long getFeedbackId() {
			return feedbackId;
		}
		public void setFeedbackId(Long feedbackId) {
			this.feedbackId = feedbackId;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		

	}



