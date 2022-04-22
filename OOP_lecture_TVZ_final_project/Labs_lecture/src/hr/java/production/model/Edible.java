package hr.java.production.model;

import java.math.BigDecimal;

public interface Edible {

    int calculateKilocalories(); //prazne zagrade su jer funkcija ne prima ništa

    BigDecimal calculatePrice();

    //ove dvije funkcije moram imati u klasama koje je implementiraju
}
