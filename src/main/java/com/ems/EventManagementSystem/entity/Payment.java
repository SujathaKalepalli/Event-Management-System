package com.ems.EventManagementSystem.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	@Column(name = "Trans_Date")
	@JsonFormat(pattern = "dd/MM/yy")
	private Date transactionDate;

	@Column(name = "Amount")
	private int amount;

//			@Column(name = "Trans-Status")
//			private  long status;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

//			public long getStatus() {
//				return status;
//			}
//
//			public void setStatus(long status) {
//				this.status = status;
//			}

	/*
	 * @Override public String toString() { return "Payment [transactionId=" +
	 * transactionId + ", transactionDate=" + transactionDate + "]"; }
	 */

}
