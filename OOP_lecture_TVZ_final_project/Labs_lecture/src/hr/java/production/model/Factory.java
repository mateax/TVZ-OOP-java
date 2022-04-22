package hr.java.production.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Factory extends NamedEntity {
    private Address address;
    private Set<Item> items;

    //konstruktor

    public Factory(String name, Address address, List<Item> items) {
        super(name);
        this.address = address;
        this.items = (Set<Item>) items;
    }


    //getteri i setteri


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }


    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu adresa tvornica i usporedbu artikala koji se nalaze u tvornici
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Factory factory = (Factory) o;
        return address.equals(factory.address) && items.equals(factory.items);
    }

    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki pojedini objekt tipa Factory
     * @return - vraca hashCode - jedinstvenu oznaku za svaku pojedinu tvornicu na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, items);
    }

    }
