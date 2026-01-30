package br.edu.ufvjm.barbershop.model;

public class Service {

    private String type;
    private Double value;

    public Service(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    // GETTERS E SETTERS
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    // SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{type='"
                + getType()
                + '\''
                + ", value="
                + getValue()
                + '}';
    }
}