package com.hybernate.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hybernate.DAO.CustomerDAO;
import com.hybernate.Entity.Customer;
import com.hybernate.Entity.CustomerDetails;
import com.hybernate.Entity.OrderDetails;
import com.hybernate.Entity.Product;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    // Constructor to establish Hibernate connection
    public CustomerDAOImpl() {
    	session = new Configuration()
                .configure()  // This loads hibernate.cfg.xml
                .addAnnotatedClass(Customer.class) // Add your entity classes
                .addAnnotatedClass(CustomerDetails.class)
                .addAnnotatedClass(OrderDetails.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory()
                .openSession();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.save(customer); // Saves both customer and customerDetails due to cascading
        transaction.commit();
        System.out.println("Customer and details saved successfully!");
    }

    @Override
    public void saveCustomer(CustomerDetails customerDetails) {
        Transaction transaction = session.beginTransaction();
        session.save(customerDetails); // Saves both customer and customerDetails due to cascading
        transaction.commit();
        System.out.println("Customer and details saved successfully!");
    }
    
    @Override
    public Customer getCustomerById(int cid) {
         Customer c = session.get(Customer.class, cid);
         return c;
    }
   
    @Override
    public CustomerDetails getCustomerByCustomerDetailsId(int cdid) {
    	 CustomerDetails cd = session.get(CustomerDetails.class, cdid);
         return cd;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        System.out.println("Customer updated successfully!");
    }

    @Override
    public void deleteCustomer(int cid) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, cid);
        if (customer != null) {
            session.delete(customer); // Deletes both customer and customerDetails due to cascading
        }
        transaction.commit();
        System.out.println("Customer deleted successfully!");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return session.createQuery("from Customer", Customer.class).list();
    }
    
    @Override
    public void saveOrder(OrderDetails od) {
    	Transaction transaction = session.beginTransaction();
    	session.save(od);
    	transaction.commit();
    }

    // Closing the session
    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}