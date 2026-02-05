package br.edu.ufvjm.barbershop.util;

import br.edu.ufvjm.barbershop.model.Customer;
import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer a, Customer b) {

        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        String name1 = a.getName();
        String name2 = b.getName();

        if (name1 == null && name2 == null) return 0;
        if (name1 == null) return -1;
        if (name2 == null) return 1;

        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();

        int minLength = Math.min(name1.length(), name2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = name1.charAt(i);
            char c2 = name2.charAt(i);

            if (c1 < c2) return -1;
            if (c1 > c2) return 1;
        }

        if (name1.length() < name2.length()) return -1;
        if (name1.length() > name2.length()) return 1;

        return 0;
    }
}