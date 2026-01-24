package br.edu.ufvjm.barbershop.model;

import br.edu.ufvjm.barbershop.model.enums.AppointmentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {

    private Long id;
    private Client client;
    private Employee employee;
    private Service service;
    private LocalDateTime dateTime;
    private BigDecimal amount;
    private String description;
    private AppointmentStatus status;

    //CONSTRUTOR PRIVADO (BUILDER)
    private Appointment(Builder builder) {
        this.client = builder.client;
        this.employee = builder.employee;
        this.service = builder.service;
        this.dateTime = builder.dateTime;
        this.amount = builder.amount;
        this.description = builder.description;
        this.status = builder.status != null ? builder.status : AppointmentStatus.PRE_AGENDADO;
    }

    //PADRÃO DE PROJETO BUILDER
    public static class Builder {

        private Client client;
        private Employee employee;
        private Service service;
        private LocalDateTime dateTime;
        private BigDecimal amount;
        private String description;
        private AppointmentStatus status;

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder service(Service service) {
            this.service = service;
            return this;
        }

        public Builder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder status(AppointmentStatus status) {
            this.status = status;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }

    //REGRAS DE NEGÓCIO
    public void confirm() {
        validateChange();
        this.status = AppointmentStatus.CONFIRMADO;
    }

    public void complete() {
        if (status != AppointmentStatus.CONFIRMADO) {
            throw new IllegalArgumentException("Only confirmed appointments can be completed.");
        }
        this.status = AppointmentStatus.CONCLUIDO;
    }

    public void cancel() {
        validateChange();
        this.status = AppointmentStatus.CANCELADO;
    }

    private void validateChange() {
        if (status == AppointmentStatus.CANCELADO || status == AppointmentStatus.CONCLUIDO) {
            throw new IllegalStateException("Appointment can no longe be modified.");
        }
    }

    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getDateTime(LocalDateTime dateTime) {
        return dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    //HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + '{'
                + "id="
                + getId()
                + ", client='"
                + (getClient() != null ? getClient().getName() : "N/A")
                + '\''
                + ", employee='"
                + (getEmployee() != null ? getEmployee().getName() : "N/A")
                + '\''
                + ", service='"
                + (getService() != null ? getService().getType() : "N/A")
                + '\''
                + ", dateTime="
                + dateTime
                + ", amount="
                + getAmount()
                + ", status="
                + getStatus()
                + '}';
    }
}