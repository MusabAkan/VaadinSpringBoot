package com.musakan.core.dataAccess.concretes;

import com.musakan.core.dataAccess.abstracts.CustomerDao;
import com.musakan.core.entities.concretes.Customer;

import java.util.List;

public class HibernateCustomerDao  implements CustomerDao {
    @Override
    public void add(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
