package com.example.demo.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {

	@Id
	@Column(name = "cust_id")
    private String cust_id;
	
	@Column(name = "name")
    private String name;
	
	@OneToOne
    @JoinColumn(name = "add_id")
    private Address add_id;
	
	@OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> order;
	
	@OneToMany
    @JoinColumn(name = "payment_id")
    private List<Payment> payment;

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Address add_id) {
		this.add_id = add_id;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
}
