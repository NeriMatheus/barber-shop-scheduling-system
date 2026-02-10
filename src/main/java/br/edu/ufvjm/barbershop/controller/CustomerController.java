package br.edu.ufvjm.barbearia.controller;

import br.edu.ufvjm.barbershop.model.Customer;
import br.edu.ufvjm.barbershop.service.BarbershopSystem;

import java.util.List;

public class CustomerController {

    private final SystemService system;

    public CustomerController(SystemService system) {
        this.system = system;
    }

    public void register(Customer customer) {
        system.addCustomer(
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getCpf()
        );
    }

    public Customer findById(String id) {
        return system.findCustomerById(id);
    }

    public List<Customer> listAll() {
        return system.getCustomers();
    }

    public void update(Customer customer) {
        system.updateCustomer(
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getCpf()
        );
    }

    public void remove(String id) {
        system.removeCustomer(id);
    }
}
