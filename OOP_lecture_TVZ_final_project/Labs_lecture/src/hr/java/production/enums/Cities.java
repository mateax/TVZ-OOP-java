package hr.java.production.enums;

public enum Cities {

    DUBROVNIK("Dubrovnik", "20000"),
    SPLIT("Split", "21000"),
    ZAGREB("Zagreb", "10000");

    private String nameCity;
    private String postalCode;

    //konstruktor
    Cities(String nameCity, String postalCode) {
        this.nameCity = nameCity;
        this.postalCode = postalCode;
    }

    //getteri i seteri
    public String getNameCity() {
        return nameCity;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
