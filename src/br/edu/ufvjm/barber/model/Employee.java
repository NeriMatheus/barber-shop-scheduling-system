package br.edu.ufvjm.barber.model;

import br.edu.ufvjm.barber.model.enums.Position;
import java.math.BigDecimal;
import java.util.Objects;

public class Employee extends Person {

    private Position position;
    private final String login;
    private String password;
    private BigDecimal salary;

    public Employee(Long id, String name, Phone phone, Address address, Position position, String login, String password, BigDecimal salary) {
        super(id, name, phone, address);

        if (position == null)
            throw new IllegalArgumentException("Position cannot be null.");

        if (login == null || login.isBlank())
            throw new IllegalArgumentException("Login cannot be empty.");

        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password hash cannot be empty.");

        if (salary == null || salary.signum() < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");

        this.position = position;
        this.login = login;
        this.password = password;
        this.salary = salary;
    }

    // GETTERS E SETTERS
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = Objects.requireNonNull(position);
    }

    public String getLogin() {
        return login;
    }

    protected String getPassword() {
        return password;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if (salary == null || salary.signum() < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");

        this.salary = salary;
    }

    // ALTERAR SENHA
    public void changePassword(String newPassword) {
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("Password hash cannot be empty.");
        }
        this.password = newPassword;
    }

    // SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getId() + ": " + getName() + "/" + getPosition();
    }
}