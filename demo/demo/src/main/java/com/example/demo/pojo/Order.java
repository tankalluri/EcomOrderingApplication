package com.example.demo.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false, updatable = false)
    private long order_id;

	@Column(name = "status")
    private String status;

    @Column(name = "total")
    private int total;

    @Column(name = "subtotal")
    private int subtotal;

    @Column(name = "tax")
    private int tax;
    
    @Column(name = "shipping_charges")
    private int shipping_charges;
    
    @OneToMany(mappedBy="order")
    private Set<Item> item;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer cust;
    
    public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public long getOrder_id() {
		return order_id;
	}

//	public void setOrder_id(long order_id) {
//		this.order_id = order_id;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getShipping_charges() {
		return shipping_charges;
	}

	public void setShipping_charges(int shipping_charges) {
		this.shipping_charges = shipping_charges;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
