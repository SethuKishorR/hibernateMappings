package com.hybernate.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private int cid;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdid")
	private CustomerDetails customerDetails;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_product",
			joinColumns = @JoinColumn(name = "cid"),
			inverseJoinColumns = @JoinColumn(name = "pid")
			)
	private List<Product> products;

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	// Constructors
	public Customer() {}

	public Customer(String fname, String lname, CustomerDetails customerDetails) {
		this.fname = fname;
		this.lname = lname;
		this.customerDetails = customerDetails;
	}

	// Getters and Setters
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", customerDetails=" + customerDetails
				+ "]";
	}
}