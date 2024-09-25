package com.hybernate.Launch;

import java.util.ArrayList;
import java.util.Scanner;

import com.hybernate.DAO.CustomerDAO;
import com.hybernate.DAOImpl.CustomerDAOImpl;
import com.hybernate.Entity.Customer;
import com.hybernate.Entity.CustomerDetails;
import com.hybernate.Entity.OrderDetails;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAOImpl();

		//        *** Type 1 of adding the orders
		//        CustomerDetails customerDetails = new CustomerDetails("sethukishor@gmail.com","9944750880","DGL");
		//        Customer customer = new Customer("sethu","kishor",customerDetails);
		//        
		//        OrderDetails o1 = new OrderDetails("apple",150,customer);
		//        OrderDetails o2 = new OrderDetails("grape",80,customer);
		//        OrderDetails o3 = new OrderDetails("watermelon",40,customer);
		//        
		//        ArrayList<OrderDetails> al = new ArrayList<OrderDetails>();
		//        al.add(o1);
		//        al.add(o2);
		//        al.add(o3);
		//        
		//        customer.setOrderDetails(al);
		//        customerDAO.saveCustomer(customer);

		//        *** Type 2 of adding the orders
		//        customer.setCustomerDetails(customerDetails);

		//        o1.setCustomer(customer);
		//        o2.setCustomer(customer);
		//        o3.setCustomer(customer);
		//        
		//        customerDAO.saveOrder(o1);
		//        customerDAO.saveOrder(o2);
		//        customerDAO.saveOrder(o3);

		//        System.out.println("********************\nDone");

		//        *** 2 Ways to get and show the details
		//        CustomerDetails cd =  customerDAO.getCustomerByCustomerDetailsId(1);
		//        System.out.println(cd.getCdid()+"  "+cd.getCustomer().getFname()+"  "+cd.getCustomer().getLname()+"  "+cd.getEmail()+"  "+cd.getPhoneNumber()+"  "+cd.getAddress()+cd.getCustomer().getOrderDetails());

		//        Customer c = customerDAO.getCustomerById(2);
		//        System.out.println(c.getCid()+"  "+c.getFname()+"  "+c.getLname()+"  "+c.getCustomerDetails().getEmail()+"  "+c.getCustomerDetails().getPhoneNumber()+"  "+c.getCustomerDetails().getAddress());

		
//          *** for many to many
//		 	CustomerDetails customerDetails1 = new CustomerDetails("sethukishor@gmail.com", "9944750880", "DGL");
//	        Customer customer1 = new Customer("Sethu", "Kishor", customerDetails1);
//
//	        CustomerDetails customerDetails2 = new CustomerDetails("ramasamy@gmail.com", "8925638843", "DGL");
//	        Customer customer2 = new Customer("Ramasamy", "K", customerDetails2);
//
//	        CustomerDetails customerDetails3 = new CustomerDetails("shanthi@gmail.com", "9789110849", "DGL");
//	        Customer customer3 = new Customer("Shanthi", "R", customerDetails3);
//
//	        // Creating OrderDetails for customer1
//	        OrderDetails o1 = new OrderDetails("Apple", 150, customer1);
//	        OrderDetails o2 = new OrderDetails("Grape", 80, customer1);
//	        OrderDetails o3 = new OrderDetails("Watermelon", 40, customer1);
//
//	        ArrayList<OrderDetails> orderList1 = new ArrayList<>();
//	        orderList1.add(o1);
//	        orderList1.add(o2);
//	        orderList1.add(o3);
//	        
//	        customer1.setOrderDetails(orderList1);
//	        customerDAO.saveCustomer(customer1); // Save customer1 with its orders
//
//	        // Creating Products
//	        Product p1 = new Product("Shirt", 300);
//	        Product p2 = new Product("Pant", 400);
//	        Product p3 = new Product("T-Shirt", 200);
//
//	        // Associating customers with products
//	        ArrayList<Customer> customerList1 = new ArrayList<>();
//	        customerList1.add(customer1);
//	        customerList1.add(customer2);
//
//	        ArrayList<Customer> customerList2 = new ArrayList<>();
//	        customerList2.add(customer1);
//	        customerList2.add(customer2);
//	        customerList2.add(customer3);
//
//	        ArrayList<Product> productList1 = new ArrayList<>();
//	        productList1.add(p1);
//	        productList1.add(p2);
//	        productList1.add(p3);
//
//	        ArrayList<Product> productList2 = new ArrayList<>();
//	        productList2.add(p1);
//	        productList2.add(p2);
//	        productList2.add(p3);
//
//	        // Setting products for customers
//	        customer1.setProducts(productList1);
//	        customer2.setProducts(productList2);
//
//	        // Setting customers for products
//	        p1.setCustomers(customerList1);
//	        p2.setCustomers(customerList2);
//	        
//	        // Saving customers and their associations
//	        customerDAO.saveCustomer(customer1);
//	        customerDAO.saveCustomer(customer2);
//	        customerDAO.saveCustomer(customer3);
//	        
//	        // Saving products (if needed)
//	        // customerDAO.saveProduct(p1);
//	        // customerDAO.saveProduct(p2);
//	        // customerDAO.saveProduct(p3);
//
//	        System.out.println("Done...");
		
		
		 Scanner scanner = new Scanner(System.in);
	        
	        // Input for a single customer
	        System.out.print("Enter email for Customer: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter phone for Customer: ");
	        String phone = scanner.nextLine();
	        System.out.print("Enter location for Customer: ");
	        String location = scanner.nextLine();
	        System.out.print("Enter first name for Customer: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Enter last name for Customer: ");
	        String lastName = scanner.nextLine();

	        CustomerDetails customerDetails = new CustomerDetails(email, phone, location);
	        Customer customer = new Customer(firstName, lastName, customerDetails);

	        // Input Orders for the Customer
	        ArrayList<OrderDetails> orderList = new ArrayList<>();
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Enter product name for Order " + (i + 1) + ": ");
	            String productName = scanner.nextLine();
	            System.out.print("Enter price for Order " + (i + 1) + ": ");
	            int price = scanner.nextInt();
	            scanner.nextLine(); // consume the newline
	            OrderDetails order = new OrderDetails(productName, price, customer);
	            orderList.add(order);
	        }

	        customer.setOrderDetails(orderList);
	        customerDAO.saveCustomer(customer); // Save customer with its orders

	        System.out.println("Done...");

	        scanner.close();
	}
}