package br.edu.ufvjm.barbershop.model;

import br.edu.ufvjm.barbershop.model.enums.Position;

import java.math.BigDecimal;
import java.util.Objects;

public class Administrator extends Employee {

    public Administrator(Long id, String name, Phone phone, Address address, Position position, String login, String passwordHash, BigDecimal salary) {
        super(id, name, phone, address, position, login, passwordHash, salary);
    }

    public boolean changePassword(String currentPassword, String newPassword) {

        if (!Objects.equals(getPassword(), currentPassword)) {
            return false;
        }

        super.changePassword(newPassword);
        return true;
    }

    // SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getId() + ": " + getName();
    }
}
