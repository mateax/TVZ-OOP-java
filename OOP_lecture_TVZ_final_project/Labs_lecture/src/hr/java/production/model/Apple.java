package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Apple extends Item implements Edible {

    private static final int BR_KCAL_APPLE = 350;

    BigDecimal weight;

    public Apple(BigDecimal weight, String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, Discount discountAmount) {
        super(name, category, width, height, length, productionCost, sellingPrice, discountAmount);
        this.weight = weight;
    }


    @Override
    public int calculateKilocalories() {
        BigDecimal izracunKalorijaJabuka = weight.multiply(BigDecimal.valueOf(BR_KCAL_APPLE));
        return izracunKalorijaJabuka.intValue();
    }

    //ako je trebala cijena bez popusta tu samo promijeni u getSellingPrice
    @Override
    public BigDecimal calculatePrice() {
        BigDecimal izracunCijeneJabuka = weight.multiply(getProdajnaCijenaSpopustom());
        return izracunCijeneJabuka;
    }

    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih parametara koje sadrže objekti klase Apple
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(weight, apple.weight);
    }

    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki pojedini objekt klase Apple
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini objekt klase Apple na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
