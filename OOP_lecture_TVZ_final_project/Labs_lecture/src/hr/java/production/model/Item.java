package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item extends NamedEntity{
    private Category category;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal length;
    private BigDecimal productionCost;
    private BigDecimal sellingPrice;
    private BigDecimal volume;
    private Double poreznaStopa;
    private BigDecimal prodajnaCijenaSporezom;
    private Discount popust; //OBJEKT -  iznos popusta
    private BigDecimal prodajnaCijenaSpopustom;


    //konstruktor

    public Item(String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, Discount popust) {
        super(name); //ovdje samo dodavamo nešto iz nadklase
        this.category = category;
        this.width = width;
        this.height = height;
        this.length = length;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
        this.volume = width.multiply(height.multiply(length));
        this.popust = popust; //ovako kad napišemo znači kao da očekujemo da će nam netko poslati kolika je vrijednost
        //this.prodajnaCijenaSpopustom =(sellingPrice.subtract(sellingPrice.multiply(popust.discountAmount()))).divide(BigDecimal.valueOf(10)); //tu racunamo kolika je cijena s popustom
        this.prodajnaCijenaSpopustom = sellingPrice.subtract(sellingPrice.multiply(popust.discountAmount())).divide(BigDecimal.valueOf(-10));
        //nad objektom popust iz klase Item trazim koliki je to inos
        //.
    }


    //getteri i setteri


    public BigDecimal getProdajnaCijenaSporezom() {
        return prodajnaCijenaSporezom;
    }

    public void setProdajnaCijenaSporezom(BigDecimal prodajnaCijenaSporezom) {
        this.prodajnaCijenaSporezom = prodajnaCijenaSporezom;
    }

    public Double getPoreznaStopa() {
        return poreznaStopa;
    }

    public void setPoreznaStopa(Double poreznaStopa) {
        this.poreznaStopa = poreznaStopa;
        BigDecimal povecanje = sellingPrice.multiply(BigDecimal.valueOf(poreznaStopa/100));
         prodajnaCijenaSporezom = povecanje.add(sellingPrice);

    }

//getteri i settteri
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(BigDecimal productionCost) {
        this.productionCost = productionCost;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    //getter i setter za volumen
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }


    //getter i setter za popust
    public Discount getPopust() {
        return popust;
    }

    public void setPopust(Discount popust) {
        this.popust = popust;
    }

    //getter i setter za cijenu s popustom

    public BigDecimal getProdajnaCijenaSpopustom() {
        return prodajnaCijenaSpopustom;
    }

    public void setProdajnaCijenaSpopustom(BigDecimal prodajnaCijenaSpopustom) {
        this.prodajnaCijenaSpopustom = prodajnaCijenaSpopustom;
    }


    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih podataka koji su vezani za svaki pojedini artikl
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return category.equals(item.category) && width.equals(item.width) && height.equals(item.height) && length.equals(item.length) && productionCost.equals(item.productionCost) && sellingPrice.equals(item.sellingPrice) && volume.equals(item.volume) && poreznaStopa.equals(item.poreznaStopa) && prodajnaCijenaSporezom.equals(item.prodajnaCijenaSporezom) && popust.equals(item.popust) && prodajnaCijenaSpopustom.equals(item.prodajnaCijenaSpopustom);
    }

    /**
     * Generirali hashCode metodu za izracun hashCoda za svaki objekt tipa Item
     * @return - vraca hashCode - jedinstvenu oznaku za svaki pojedini artikl na temelju unesenih vrijednosti
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, width, height, length, productionCost, sellingPrice, volume, poreznaStopa, prodajnaCijenaSporezom, popust, prodajnaCijenaSpopustom);
    }
}
