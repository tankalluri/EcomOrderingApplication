package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class Payment {

	@Id
	@Column(name = "payment_id")
    private String payment_id;
	
	@Column(name = "date")
    private int date;
	
	@Column(name = "transaction_amount")
    private int transaction_amount;
	
	@ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer cust;

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
