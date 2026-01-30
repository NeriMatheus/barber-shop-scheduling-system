package br.edu.ufvjm.barbershop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Person {

    private String email;
    private final String cpf;
    private final List<ServiceOrder> orders = new ArrayList<>();

    public Client(Long id, String name, Phone phone, Address address, String email, String cpf) {
        super(id, name, phone, address);
        this.email = email;
        this.cpf = cpf;
    }

    // REGRAS DE NEGÓCIO
    public void addOrder(ServiceOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Service order cannot be null.");
        }
        orders.add(order);
    }

    // GETTERS E SETTERS
    public String getEmail() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public List<ServiceOrder> getOrders() {
        return List.copyOf(orders);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{id="
                + getId()
                + ", nome="
                + getName()
                + '\''
                + ", cpf="
                + getCpf()
                + '\''
                + ", email="
                + getEmail()
                + '\''
                + '}';
    }
}