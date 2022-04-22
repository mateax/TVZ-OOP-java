package hr.java.production.sort;

import hr.java.production.model.Item;

import java.util.Comparator;

public class ProductionSorter  implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        //-1    o1, o2
        //1     o2, o1
        //0     svejedno

        //o1:50,o2:500    ---compareTo(50,500) = -1
        int rezultatKomparacije = o1.getSellingPrice().compareTo(o2.getSellingPrice());    //1

        /*if(provjera == 0){
            int provjera2 = o1.getName().compareTo(o2.getName());
            return provjera2;
        }*/

        return rezultatKomparacije;    //uzlazno

        //if(o1.getSellingPrice().compareTo(o2.getSellingPrice()) > 0){
        //    return -1;
        // }


    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}
