package com.hybernate.DAO;

import java.util.List;

import com.hybernate.Entity.Customer;
import com.hybernate.Entity.CustomerDetails;
import com.hybernate.Entity.OrderDetails;

public interface CustomerDAO {

    // Create new customer with details
    void saveCustomer(Customer customer);
    void saveCustomer(CustomerDetails customerDetails);

    // Retrieve customer by ID
    Customer getCustomerById(int cid);
    CustomerDetails getCustomerByCustomerDetailsId(int cdid);

    // Update customer
    void updateCustomer(Customer customer);

    // Delete customer
    void deleteCustomer(int cid);

    // Get all customers
    List<Customer> getAllCustomers();

    void saveOrder(OrderDetails od);
}