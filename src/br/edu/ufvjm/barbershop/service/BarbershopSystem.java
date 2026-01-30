package br.edu.ufvjm.barbershop.service;

import br.edu.ufvjm.barbershop.model.Appointment;
import br.edu.ufvjm.barbershop.model.Employee;
import br.edu.ufvjm.barbershop.model.Station;

import java.util.ArrayDeque;
import java.util.Queue;

public class BarbershopSystem {

    private static final Station[] STATIONS = new Station[3];

    static {
        STATIONS[0] = new Station(1, "Wash and dryer");
        STATIONS[1] = new Station(2, "Regular activities 1");
        STATIONS[2] = new Station(3, "Regular activities 2");
    }

    private final Queue<Appointment> secondaryQueue = new ArrayDeque<>();

    // ESTAÇÕES
    public static Station[] getStations() {
        return STATIONS.clone();
    }

    public boolean hasFreeStation() {
        for (Station station : STATIONS) {
            if (!station.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    public Station allocateFreeStation(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException("Employee is required to allocate a station.");

        for (Station station : STATIONS) {
            if (!station.isOccupied()) {
                station.occupy(employee); // regra de negócio respeitada
                return station;
            }
        }
        return null;
    }

    public void releaseStation(Station station) {
        if (station != null && station.isOccupied()) {
            station.release(); // regra de negócio respeitada
        }
    }

    // FILA SECUNDÁRIA
    public void addSecondaryAppointment(Appointment appointment) {
        if (appointment == null)
            throw new IllegalArgumentException("Appointment cannot be null.");

        secondaryQueue.offer(appointment);
    }

    public Appointment getNextSecondaryAppointment() {
        return secondaryQueue.poll();
    }

    public int getSecondaryQueueSize() {
        return secondaryQueue.size();
    }

    // SAÍDA DOS DADOS PREENCHIDOS
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{stations="
                + STATIONS.length
                + ", secondaryQueueSize="
                + secondaryQueue.size()
                + '}';
    }
}
