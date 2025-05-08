package com.musakan.core.business.concretes;

import com.musakan.core.business.abstracts.CustomerService;
import com.musakan.core.dataAccess.abstracts.CustomerDao;
import com.musakan.core.entities.concretes.Customer;

import java.util.List;

public class CustomerManager  implements CustomerService {

    private CustomerDao customerDao;

    public CustomerManager(CustomerDao customerDao) {
        super();
        this.customerDao = customerDao;
    }

    @Override
    public void add(Customer customer) {
         this.customerDao.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
