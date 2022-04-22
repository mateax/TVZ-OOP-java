package hr.java.production.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Store extends NamedEntity {

    private String webAddress;
    private Set<Item> items;

    //konstruktor

    public Store(String name, String webAddress, List<Item> items) {
        super(name);
        this.webAddress = webAddress;
        this.items = (Set<Item>) items;
    }


    //getteri i setteri

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih podataka za trgovinu (znaci sve parametri vezani za trgovine: web adressa i artikli )
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Store store = (Store) o;
        return Objects.equals(webAddress, store.webAddress) && Objects.equals(items, store.items);
    }


    /**
     * Generirali hashCode metodu za izracun hashCoda svakog objekta tipa Store
     * @return - vraca hashCode - jedinstvenu oznaku za svaku  trgovinu na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), webAddress, items);
    }
}
