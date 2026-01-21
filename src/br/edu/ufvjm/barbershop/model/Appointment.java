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
    }

}