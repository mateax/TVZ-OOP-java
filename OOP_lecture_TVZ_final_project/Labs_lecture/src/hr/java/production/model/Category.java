package hr.java.production.model;

import java.util.Objects;

public class Category extends NamedEntity {

    private String description;

    //konstruktor
    public Category(String name, String description) {
        super(name);  //poziv konstruktora nadklase
        this.description = description;
    }

    //getteri i setteri
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu opisa kategorija, tj usporeduje parametre koji se nalaze u klasi Category
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(description, category.description);
    }


    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki objekt tipa Category
     * @return - vraca hashCode - jedinstvenu oznaku za svaku pojedinu trgovinu na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
