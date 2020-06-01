package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> finAll();

    void Save(Customer customer);

    Customer findCustomerById(int id);

    void update(int id, Customer customer);

    void delete(int id);
}
