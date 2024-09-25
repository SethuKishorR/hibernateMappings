package com.hybernate.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderTable")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid")
	private int oid;
	@Column(name="itemName")
	private String itemName;
	@Column(name="price")
	private int price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private Customer customer;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public OrderDetails(String itemName, int price, Customer customer) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetails [oid=" + oid + ", itemName=" + itemName + ", price=" + price + "]";
	}
}
