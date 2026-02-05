package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Appointment;
import br.edu.ufvjm.barbershop.service.BarbershopSystem;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentController {

    private final BarbershopSystem system;

    public AppointmentController(BarbershopSystem system) {
        this.system = system;
    }

    public Appointment createPreliminary(
            String clientId,
            String description,
            LocalDateTime dateTime
    ) {
        return system.createPreliminaryAppointment(clientId, description, dateTime);
    }

    public Appointment findById(String id) {
        return system.findAppointmentById(id);
    }

    public List<Appointment> listAll() {
        return system.listAppointments();
    }

    public void assignToBarber(
            String appointmentId,
            String barberId,
            String serviceType,
            double price
    ) {
        system.assignAppointmentToBarber(
                appointmentId,
                barberId,
                serviceType,
                price
        );
    }

    public void confirm(String id) {
        system.confirmAppointment(id);
    }

    public void cancel(String id) {
        system.cancelAppointment(id);
    }

    public void conclude(String id) {
        system.concludeService(id);
    }
}
