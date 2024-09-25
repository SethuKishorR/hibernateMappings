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
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int pid;
	@Column(name = "product_name")
	private String pName;
	@Column(name = "price")
	private int price;
	@ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private List<Customer> customers;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_product",
			joinColumns = @JoinColumn(name = "pid"),
			inverseJoinColumns = @JoinColumn(name = "cid")
			)
	private List<Customer> customer;

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Product() {
		super();
	}

	public Product(String pName, int price) {
		super();
		this.pName = pName;
		this.price = price;
	}

	public Product(String pName, int price, List<Customer> customers) {
		super();
		this.pName = pName;
		this.price = price;
		this.customers = customers;
	}

	public Product(int pid, String pName, int price, List<Customer> customers) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.price = price;
		this.customers = customers;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", price=" + price + ", customers=" + customers + "]";
	}
}