package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Employee;
import br.edu.ufvjm.barbershop.model.enums.EmployeePosition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Long id, String name, EmployeePosition position,
                            String login, String password, BigDecimal salary) {

        Employee employee = new Employee(id, name, null, null,
                position, login, password, salary);

        employees.add(employee);
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public void remove(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}