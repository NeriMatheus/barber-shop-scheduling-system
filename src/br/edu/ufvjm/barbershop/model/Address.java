package br.edu.ufvjm.barbershop.model;

public record Address(String street, String number, String neighborhood, String city, String zipCode) {

    public Address {
        if (street == null || street.isBlank() ||
                number == null || number.isBlank() ||
                neighborhood == null || neighborhood.isBlank() ||
                city == null || city.isBlank() ||
                zipCode == null || zipCode.isBlank()) {

            throw new IllegalArgumentException("No field can be null or empty.");
        }

        // REMOVE TUDO QUE NÃO SEJA NÚMERO
        zipCode = zipCode.replaceAll("\\D", "");

        if (zipCode.length() != 8) {
            throw new IllegalArgumentException("ZIP code must contain exactly 8 digits.");
        }
    }

    public String getFormattedZipCode() {
        return zipCode.substring(0, 5) + "-" + zipCode.substring(5);
    }


    // ENDEREÇO PREENCHIDO
    public String getFullAddress() {
        return street + ", " +
                number + " - " +
                neighborhood + " - " +
                city + " - ZIP: " +
                getFormattedZipCode();
    }

    // SAÍDA DO CAMPO ENDEREÇO PREENCHIDO
    @Override
    public String toString() {
        return getFullAddress();
    }
}