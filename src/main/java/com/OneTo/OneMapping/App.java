package com.OneTo.OneMapping;

import Service.CustomerService;

public class App {
	public static void main(String[] args) {

		CustomerService service = new CustomerService();
		service.saveCustomers("Chinnu", "Kodadal", "bhiyaram", "670101");

		service.getAllcustomers();

		service.getCustomer(5);

		service.updateCustomer(5, "Anu", "Kashmir", "Sr Nagar", "5071094");

		service.deleteCustomer(7);
		
		service.isCustomerNameExists("Abniav");
	}
}
