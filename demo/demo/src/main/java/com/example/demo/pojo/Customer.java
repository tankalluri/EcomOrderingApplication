package com.example.demo.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id", unique = true, nullable = false, updatable = false)
    private long cust_id;
	
	@Column(name = "name")
    private String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "add_id")
    private Address address;
	
	@OneToMany(mappedBy="cust")
    private Set<Order> order;
	
	@OneToMany(mappedBy="cust")
    private Set<Payment> payments;

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}
