package hr.java.production.model;

import java.util.Objects;

public abstract class NamedEntity {

    protected String name;

    //konstruktor
    public NamedEntity(String name) {
        this.name = name;
    }


    //geteri i setteri
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih podataka za adresu (znaci sve parametre: street, houseNumber, city, postalCode)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NamedEntity that = (NamedEntity) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki pojedini objekt klase NamedEntity
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini objekt klase NamedEntity na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

