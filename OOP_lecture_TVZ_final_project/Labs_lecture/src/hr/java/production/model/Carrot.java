package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Carrot extends Item implements Edible {

    private static final int  BR_KCAL_KG = 250;
    BigDecimal weight; // tezina namirnica u kilogramima
    String naziv;

    public Carrot(BigDecimal weight, String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, Discount discountAmount) {
        super(name, category, width, height, length, productionCost, sellingPrice, discountAmount); //samo pozivamo podatke iz klase Item, zbog toga tu ništa ne dodavamo, ako želimo dodati nešto dodati onda to radimo pomoću ključne riječi this
        this.weight = weight;
    }

    //opis radnji pod "ugovorom"
    @Override
    public int calculateKilocalories() {
        BigDecimal izracunKalorija = weight.multiply(BigDecimal.valueOf(BR_KCAL_KG));
        return izracunKalorija.intValue();
    }


    @Override
    public BigDecimal calculatePrice() {
        BigDecimal izracunCijene = getProdajnaCijenaSpopustom().multiply(weight); //sa getSellingPrice dohvacamo objekt klase Item
        return izracunCijene;
    }

    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih parametara koje sadrže objekti klase Carrot
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Carrot carrot = (Carrot) o;
        return Objects.equals(weight, carrot.weight) && Objects.equals(naziv, carrot.naziv);
    }


    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki pojedini objekt klase tipa Carrot
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini objekt klase tipa Carrot  na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, naziv);
    }
}
