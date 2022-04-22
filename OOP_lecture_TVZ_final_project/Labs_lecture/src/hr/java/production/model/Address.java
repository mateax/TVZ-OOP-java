package hr.java.production.model;

import hr.java.production.enums.Cities;

import java.util.Objects;

public class Address {

    //atributi - private su da se ne moze direktno njima pristupiti, nego samo preko get/set metoda
    private String street;
    private String houseNumber;

    private Cities grad;


    //konstruktor za ove nove




    //konstruktor - konstruira objekt i vraca objekt
    /*public Address(String street, String houseNumber, Cities grad) {
        this.street = street;   //this kljucna rijec za obratiti se samome sebi - tako dodes do svoijih atributa
        this.houseNumber = houseNumber;
        this.grad = grad;
    }*/

    public Address(String street, String houseNumber, Cities grad) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.grad = grad;
    }

    public Address(String street, String houseNumber) {

    }

    //getteri i setteri

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }


    //Builder pattern for address
   /* public static final class Builder{
        private String street;
        private String houseNumber;

        public Builder(){}

        public static Builder forAddress(){
            return new Builder();
        }
        public Builder withStreet(String street){
            this.street = street;
            return this;
        }
        public Builder withHouseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }
        public Address build(){
            Address address = new Address(street, houseNumber); //stvori mi objekt adrese

        }

    }*/


    /** Generirali smo equals za usporedivanje objekata
     * @param o - objekt koji se usporeduje
     * @return - vraca usporedbu svih podataka za adresu (znaci sve parametre: street, houseNumber, city, postalCode)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber);
    }

    /**Generirali smo hashCode metodu za izracun jedinstvenog hashCoda (oznake) svakog objekta
     */
    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber);
    }
}
