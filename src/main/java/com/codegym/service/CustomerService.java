package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "badat", "hung yen", "lebadta1996@gmail.com"));
        customerMap.put(2, new Customer(2, "tranA", "thai binh", "A@gmail.com"));
        customerMap.put(3, new Customer(3, "NguyenB", "hai duong", "B@gmail.com"));
        customerMap.put(4, new Customer(4, "DaoC", "thanh hoa", "C@gmail.com"));
        customerMap.put(5, new Customer(5, "LeE", "nghe an", "E@gmail.com"));

    }

    @Override
    public List<Customer> finAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void Save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void delete(int id) {
        customerMap.remove(id);
    }
}
