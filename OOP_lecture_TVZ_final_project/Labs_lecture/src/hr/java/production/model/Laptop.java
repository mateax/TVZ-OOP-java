package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Laptop extends Item implements Technical{

    private static final Integer GARANCIJA_U_MJESECIMA = 24;
    Integer brojPotrosenihMjeseci;

    public Laptop(Integer brojPotrosenihMjeseci, String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, Discount discountAmount) {
        super(name, category, width, height, length, productionCost, sellingPrice, discountAmount);
        this.brojPotrosenihMjeseci = brojPotrosenihMjeseci;
    }


    @Override
    public Integer garatniRok() {
        Integer brojPreostalihMjeseci = GARANCIJA_U_MJESECIMA - brojPotrosenihMjeseci;
        return brojPreostalihMjeseci;
    }

    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih parametara koje sadrže objekti klase Laptop
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(brojPotrosenihMjeseci, laptop.brojPotrosenihMjeseci);
    }


    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki pojedini objekt klase Laptop
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini objekt klase Laptop na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brojPotrosenihMjeseci);
    }
}
