package br.edu.ufvjm.barbershop.util;

import br.edu.ufvjm.barbershop.model.Appointment;

import java.util.ArrayDeque;
import java.util.Deque;

public class AppointmentStack {

    private final Deque<Appointment> stack = new ArrayDeque<>();

    public void push(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        stack.push(appointment);
    }

    public Appointment pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
