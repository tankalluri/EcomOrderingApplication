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
@Table(name = "order_details")
public class Order {

    @Id
    @Column(name = "order_id")
    private String order_id;

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
    
    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Item> item;

    @OneToOne
    @JoinColumn(name = "cust_id")
    private Customer cust;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

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

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
