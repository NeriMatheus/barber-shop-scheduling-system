package br.edu.ufvjm.barbershop.util;

import br.edu.ufvjm.barbershop.model.Appointment;

import java.time.LocalDateTime;
import java.util.Comparator;

public class AppointmentDateComparator implements Comparator<Appointment> {

    @Override
    public int compare(Appointment a, Appointment b) {

        LocalDateTime d1 = a != null ? a.getDateTime() : null;
        LocalDateTime d2 = b != null ? b.getDateTime() : null;

        if (d1 == null && d2 == null) return 0;
        if (d1 == null) return -1;
        if (d2 == null) return 1;

        if (d1.getYear() != d2.getYear())
            return d1.getYear() < d2.getYear() ? -1 : 1;

        if (d1.getMonthValue() != d2.getMonthValue())
            return d1.getMonthValue() < d2.getMonthValue() ? -1 : 1;

        if (d1.getDayOfMonth() != d2.getDayOfMonth())
            return d1.getDayOfMonth() < d2.getDayOfMonth() ? -1 : 1;

        if (d1.getHour() != d2.getHour())
            return d1.getHour() < d2.getHour() ? -1 : 1;

        if (d1.getMinute() != d2.getMinute())
            return d1.getMinute() < d2.getMinute() ? -1 : 1;

        if (d1.getSecond() != d2.getSecond())
            return d1.getSecond() < d2.getSecond() ? -1 : 1;

        return 0;
    }
}
