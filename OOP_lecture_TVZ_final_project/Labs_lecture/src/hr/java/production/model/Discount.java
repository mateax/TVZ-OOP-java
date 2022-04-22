package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public record Discount(BigDecimal discountAmount) {

    public Discount(BigDecimal discountAmount){
       this.discountAmount = discountAmount;
    }

    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu discountAmounta
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return discountAmount.equals(discount.discountAmount);
    }

    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki objekt tipa Discount
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini popust na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(discountAmount);
    }
}



