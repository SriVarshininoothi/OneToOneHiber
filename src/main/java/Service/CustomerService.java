package Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.OneTo.OneMapping.Address;
import com.OneTo.OneMapping.Customer;

import Utility.HibernateUtil;

public class CustomerService {

	public boolean isCustomerNameExists(String name) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Long count = session.createQuery(
	        "select count(c) from Customer c where c.cname = :name", Long.class)
	        .setParameter("name", name)
	        .uniqueResult();
	    session.close();
	    return count > 0;
	}
	//create
	public void saveCustomers(String name, String street, String city, String zipCode) {
	    if (isCustomerNameExists(name)) {
	        System.out.println("Customer with name '" + name + "' already exists. Skipping insert.");
	        return;
	    }

	    Address a = new Address();
	    a.setAstreet(street);
	    a.setAcity(city);
	    a.setAzipCode(zipCode);

	    Customer c = new Customer();
	    c.setCname(name);
	    c.setAddress(a);

	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    session.persist(c);
	    tx.commit();
	    session.close();
	}
	
	// read all
	
	public void getAllcustomers() {
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer",Customer.class).list();
		
		for(Customer c:customers) {
			System.out.println("Customer: "+c.getCname());
			
			Address a = c.getAddress();
			if(a!=null) {
				System.out.println("Address : " + a.getAcity()+","+a.getAstreet()+"["+a.getAzipCode()+"]");
			}	
		}
		tx.commit();	
		session.close();
	}
	
	//ready by id
	
	public Customer getCustomer(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.find(Customer.class, id);
		
		if(c!=null) {
			System.out.println(c.getCname());
			Address a = c.getAddress();
			if(a!=null) {
				System.out.println(a.getAcity()+","+a.getAstreet()+","+a.getAzipCode());
			}
		}else {
			System.out.println("customer not found");
		}
		tx.commit();
		session.close();
		
		
		return c;
	}
	
	public void updateCustomer(int id,String newName,String newStreet,String newCity,String newzipcode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.find(Customer.class, id);
		if(c!=null) {
			c.setCname(newName);
			
			Address a = c.getAddress();
			if(a!=null) {
				a.setAcity(newCity);
				a.setAstreet(newStreet);
				a.setAzipCode(newzipcode);
				
				
			}else {
				System.out.println("Not found");
			}
			session.merge(c);
			tx.commit();
			session.close();
		}
		
	}
	
	//delete
	
	public void deleteCustomer(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.find(Customer.class, id);
		if(c!=null) {
			session.remove(c);
			System.out.println("Removed successfully");
			
		}else {
			System.out.print("Not found");
		}
		tx.commit();
		session.close();
	}
	
	
}
