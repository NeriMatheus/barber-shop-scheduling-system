package br.edu.ufvjm.barbershop.controller;

import java.time.LocalDateTime;
import java.util.Objects;

import br.edu.ufvjm.barbershop.model.Employee;
import br.edu.ufvjm.barbershop.model.Customer;

public class EmployeeCustomer {

    private Long id;
    private Employee employee;
    private Customer customer;
    private String serviceDescription;
    private LocalDateTime appointmentDateTime;

    public EmployeeCustomer() {
    }

    public EmployeeCustomer(Long id, Employee employee, Customer customer,
                            String serviceDescription, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.employee = employee;
        this.customer = customer;
        this.serviceDescription = serviceDescription;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeCustomer)) return false;
        EmployeeCustomer that = (EmployeeCustomer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
