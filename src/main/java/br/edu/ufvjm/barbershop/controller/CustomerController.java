package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Customer;
import br.edu.ufvjm.barbershop.model.ServiceOrder;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    private final List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
    }

    public void addServiceOrder(Customer customer, ServiceOrder order) {
        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null.");

        customer.addOrder(order);
    }

    public void add(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null.");

        if (findById(customer.getId()) != null)
            throw new IllegalArgumentException("Customer already exists.");

        customers.add(customer);
    }

    public Customer findById(Long id) {
        if (id == null)
            return null;

        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void update(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null.");

        Customer existing = findById(customer.getId());
        if (existing == null)
            throw new IllegalArgumentException("Customer not found.");

        existing.setName(customer.getName());
        existing.setPhone(customer.getPhone());
        existing.setAddress(customer.getAddress());
        existing.setEmail(customer.getEmail());
    }

    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer == null)
            throw new IllegalArgumentException("Customer not found.");

        customers.remove(customer);
    }

    public List<Customer> findAll() {
        return List.copyOf(customers);
    }
}