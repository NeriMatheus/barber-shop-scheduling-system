package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Service;

public class ServiceController {

    public ServiceController() {
    }

    public Service createService(String type, Double value) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Service type is required.");
        }

        if (value == null || value < 0) {
            throw new IllegalArgumentException("Service value must be zero or positive.");
        }

        return new Service(type, value);
    }
}