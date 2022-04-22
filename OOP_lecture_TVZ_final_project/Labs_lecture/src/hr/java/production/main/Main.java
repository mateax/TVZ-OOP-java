//1. laboratorijska vježba _ riješen unos artikla za tvornicu i store


package hr.java.production.main;

import hr.java.production.enums.Cities;
import hr.java.production.exception.*;
import hr.java.production.model.*;
import hr.java.production.sort.ProductionSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    private static final int BROJ_KATEGORIJA = 1;
    private static final int BROJ_ARTIKALA = 1;
    private static final int BROJ_TVORNICA = 1;
    private static final int BROJ_TRGOVINA = 1;

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        /*//kljuc, vrijednost
        Map<Integer, String> mapa = new HashMap<Integer, String>();
        mapa.put(1, "aaa");
        mapa.put(13, "blabla");

        String value = mapa.get(13); //blabla
        mapa.put(1, "bbb");

        for (Integer key:mapa.keySet()) {
            System.out.println( mapa.get(key) );
        }
*/



        Map<Category,List<Item>> mapaArtikala = new HashMap<>();

        log.info("Pokrenula se aplikacija");
        //log.error(ex.getMessage());
/*
        int a = 10; //primitivni tip - double, char, float, boolean
        int b;
        Address mojaAdresa;//deklaracija objekta

        mojaAdresa = new Address("hrgovići", "75", "zagreb","10000");
        //new je kljucna rijec za stvaranje objekta
        //nakon new dolazi poziv konstruktora
        b = 123;
        //mojaAdresa. kad lupimo tocku nude nam se polja i metode iz klase address

        mojaAdresa.setStreet("ilica"); //promjena ulice objekta mojaAdresa
        String grad = mojaAdresa.getCity();
        if(grad.equals("zagreb")) {
            System.out.println("purgerica");
        }
*/


        Category[] poljeKategorija = new Category[BROJ_KATEGORIJA];

        Scanner unos = new Scanner(System.in);

        for (int i = 0; i < BROJ_KATEGORIJA; i++) {
            Category kategorija; //deklaracija objekta
            kategorija = unosKategorije(unos, poljeKategorija); //unosKategorije vra
            // ca objekt tipa Category, novu stvorenu kategoriju, spremamo ga u kategorija
            poljeKategorija[i] = kategorija; // na i-to mjesto spremi mi objekt kategoriju
            List<Item> listaArtikala = new ArrayList<>();

            

            mapaArtikala.put(kategorija, listaArtikala);
        }

        //ispis kategorija koje smo do sad unjeli
        System.out.println("Unjeli ste kategorije:");
        for (int i = 0; i < BROJ_KATEGORIJA; i++) {
            System.out.println("Kategorija br. " + (i + 1) + ".: "
                    + poljeKategorija[i].getName()); // ispiši mi polje kategorija, ali njegovo ime, počevši od i-tog mjesta
        }


        /*
        int a;
        a=12;
        12=a;
        */


        /** KREIRAM OBJEKT POLJE KOJE JE POLJE OBJEKATA
         u poljeArtikala spremam sve podatke koje korisnik unese preko funkcije unosArtikala
         moraju ti svi podaci ići u polje jer ako ostavim da se poziv funkcije sprema u varijablu vraceniArtikl, svaki put
         kad pozovm fju pregazit ce se vrijednost zapisana u vraceniArtikl
         polje koje koristim u petlji mora biti deklarirao izvan nje, jer ako je u petlji mi bi stvarali objekt poljeArtikala koliko traje petlja, zato ovo ide ispred
         moramo polje deklarirati prije, jer kompjaler čita kod od vrha prema dnu, znači prije nego što pozovemo polje u petlji
         **/
        //Item[] poljeArtikla = new Item[BROJ_ARTIKALA];
        List<Item> listaArtikala = new ArrayList<>();

        //petlja u kojoj pozivam pet puta funkciju unosArtikala jer zelim da mi korisnik unese podatke za razlicitih 5 artikala
        //zbog toga poziv funkcije ide unutar petlje
        for (int i = 0; i < BROJ_ARTIKALA; i++) {

            Item vraceniArtikl = unosArtikla(unos, poljeKategorija); //poziv fje unosArtikala, varijabla u koju spremamo mora biti istog tipa kao i funkcija,u zagrade idu svi nazivi parametri koje funkcija prima, bez tipova
            System.out.println("Unjeli ste artikl broj. " + (i + 1) + ": ");
            System.out.println(" "); //stavila da mi napravi red razmaka

            //vraceni artikl spremam u polje artikala na i- to mjesto, znači idemo s desna na lijevo kad pridruzujemo vrijednost
            //poljeArtikla[i] = vraceniArtikl;
            listaArtikala.add(vraceniArtikl);

            mapaArtikala.get(vraceniArtikl.getCategory()).add(vraceniArtikl); //provjeri ispis jel se pridjelio ovaj artikl u ovu kategoriju
        }


        listaArtikala.sort(new ProductionSorter());
        for (Item privremena : listaArtikala) {
            System.out.println("Artikli uzlazno poredani po cijeni: " + privremena.getName() + ", cijena: " + privremena.getSellingPrice());
        }
        String zadnji = listaArtikala.get(listaArtikala.size() - 1).getName();
        String prvi = listaArtikala.get(0).getName();
        System.out.println("Ako sortiramo uzlazno najjeftiniji artikl je: " + prvi);
        System.out.println("Ako sortiramo uzlazno najskuplji artikl je: " + zadnji);


        //obrnuto sortiranje
        listaArtikala.sort(new ProductionSorter().reversed());
        //lista je sad sortirana silazno, max je na mjestu 0
        Item indexZadnjega = listaArtikala.get(listaArtikala.size() - 1);
        //min je na zadnjem mjestu:
        for (Item privremena : listaArtikala) {
            System.out.println("Artikli poredani silazno po cijeni : " + privremena.getName() + ", cijena: " + privremena.getSellingPrice());
        }
        System.out.println("Ako sortiramo silazno," +
                " najskuplji je: " + listaArtikala.get(0).getName() + "," +
                " najjeftiniji je: " + listaArtikala.get(listaArtikala.size() - 1).getName());
//najjeftiniji krivo

        Factory[] poljeTvornica = new Factory[BROJ_TVORNICA];
        for (int i = 0; i < BROJ_TVORNICA; i++) {

            Factory vracenaTvornica = unosTvornica(unos, listaArtikala);
            System.out.println("Unjeli ste tvornicu imena: " + vracenaTvornica.getName());

            poljeTvornica[i] = vracenaTvornica;

        }


        Store[] poljeTrgovina = new Store[BROJ_TRGOVINA];
        for (int i = 0; i < BROJ_TRGOVINA; i++) {

            Store vracenaTrgovina = unosTrgovina(unos, listaArtikala);
            System.out.println("Unjeli ste ducan imena: " + vracenaTrgovina.getName());
            poljeTrgovina[i] = vracenaTrgovina;
        }


       /* BigDecimal[] poljeVolumena = new BigDecimal[poljeArtikla.length];
        for (int i = 0; i < poljeArtikla.length; i++) {
            BigDecimal vraceniVolumen = izracunVolumena();
            poljeVolumena[i] = vraceniVolumen;
        }*/


//ispitivanje najveci broj kilokalorija
        Item najveci = null;
        for (Item artikl : listaArtikala) {
            if (artikl != null) //ovo možda zakomentiraj
            {
                if (artikl instanceof Carrot || artikl instanceof Apple) {        //budući da moramo ispisati koja namirnica ima najveći broj kilokalorija, zovemo pomoću instance of one namirnice za koje smo definirali izracunavanje kilokalorija
                    //ući ću u vitičaste zagrade samo ako je ispunjen uvjet da je artikl tipa Carrot ili Apple

                    //za prvog, kad je najveci jos uvijek null
                    if (najveci == null) { //ovo stavi !=
                        najveci = artikl;
                    }

                    int trenutniArtiklKcal = ((Edible) artikl).calculateKilocalories();//castamo item u Edible
                    int najveciArtiklKcal = ((Edible) najveci).calculateKilocalories();

                    if (trenutniArtiklKcal > najveciArtiklKcal) {
                        najveci = artikl;
                    }

                }
            }
        }

        if (najveci != null) {
            System.out.println("Najvise kilokalorija ima: " + najveci.getName());
            System.out.println("Taj broj kalorija iznosi: " + ((Edible) najveci).calculateKilocalories());
        }


        //tražimo najskuplju namirnicu
        Item najskuplji = null;
        for (Item artikl : listaArtikala) {
            if (artikl != null) {
                if (artikl instanceof Carrot || artikl instanceof Apple) {


                    if (najskuplji == null) {//samo za prvi krug petlje
                        najskuplji = artikl;
                    }

                    BigDecimal trenutniArtiklCijena = artikl.getProdajnaCijenaSpopustom();
                    BigDecimal najVeciArtiklCijena = artikl.getProdajnaCijenaSpopustom();
                    int rezultatKomparacije = trenutniArtiklCijena.compareTo(najVeciArtiklCijena);
                    if (rezultatKomparacije == 1) {
                        najskuplji = artikl;
                    }
                }
            }

        }
        if (najskuplji != null) {
            System.out.println("Najskuplja namirnica je: " + najskuplji.getName());
            System.out.println("Njena cijena iznosi: " + najskuplji.getProdajnaCijenaSpopustom());
        }


    } //kraj Main-a



    /*private static BigDecimal izracunVolumena(Item[] poljeSvihArtikala){

        for (int i = 0; i < poljeSvihArtikala.length; i++) {
            BigDecimal volumen = poljeSvihArtikala[i].getVolume();
            BigDecimal noviVolumen = new BigDecimal();
        }


    }*/


    //u zagrade mi ide ono što mi u funkciji treba izvana

    /**
     * Metoda za unos podataka za trgovine
     *
     * @param unos          - varijabla za unos podataka za trgovinu
     * @param listaArtikala - odabiremo artikl koji zelimo staviti u trgovinu
     * @return
     */

    private static Store unosTrgovina(Scanner unos, List<Item> listaArtikala) {
        System.out.print("Unesite ime trgovine: ");
        String name = unos.nextLine();

        System.out.print("Unesite webAdressu tvornice: ");
        String webAddress = unos.nextLine();

        System.out.print("Unesite ukupnu kolicinu artikala za trgovinu: ");
        Integer brojOdabranihArtikalaPoDucanu = unos.nextInt();
        unos.nextLine();
        //Item[] poljeTrgovinskihArtikala = new Item[brojOdabranihArtikalaPoDucanu];
        List<Item> listaTrgovinskihArtikala = new ArrayList<>();


        Boolean provjeraUnosa = true;
        int odabraniArtiklIzTvornice = 0;


        System.out.println("Odaberite redni broj artikla koji želite unjeti u trgovinu:");

        for (int i = 0; i < listaTrgovinskihArtikala.size(); i++) {
            do {
                for (int j = 0; j < listaArtikala.size(); j++) {
                    System.out.println("Ime artikla br " + (j + 1) + ". : " + listaArtikala.get(j).getName());
                }

                Boolean odabirArtikla = false;
                do {
                    try {
                        odabraniArtiklIzTvornice = unos.nextInt();
                        unos.nextLine();
                        // poljeTrgovinskihArtikala[i] = poljeSvihArtikala[odabraniArtiklIzTvornice - 1];
                        odabirArtikla = true;
                    } catch (InputMismatchException exception) {
                        unos.nextLine();
                        System.out.print("GREŠKA!!! Niste unjeli brojčanu vrijednost, unesite broj pored artikla: ");
                        odabirArtikla = false;
                        log.error(exception.getMessage());
                    }

                } while (odabirArtikla == false);

                try {
                    otkrivanjeDuplikata(listaTrgovinskihArtikala, listaArtikala.get(odabraniArtiklIzTvornice - 1));
                    provjeraUnosa = true;
                } catch (SameItemException e) {
                    System.out.println(e.getMessage());
                    provjeraUnosa = false;
                    log.error(e.getMessage());
                }

            } while (provjeraUnosa == false);
            listaTrgovinskihArtikala.add(listaArtikala.get(odabraniArtiklIzTvornice - 1));

        }


        //stavaram objekt
        Store novaTrgovina = new Store(name, webAddress, listaTrgovinskihArtikala);
        return novaTrgovina;

    }

    /**
     * Metoda za unos podataka za svaku tvornicu
     *
     * @param unos          - varijabla za unos podataka za tvornicu
     * @param listaArtikala - odabiremo koji artikl zelimo unjeti u tvornicu
     * @return
     */


    //poljeSvihArtikala - predstavlja svih 5 artikala koje smo unjeli
    private static Factory unosTvornica(Scanner unos, List<Item> listaArtikala) {
        System.out.print("Unesite ime tvornice: ");
        String name = unos.nextLine();



        //pozivam funkciju s adresom i taj poziv funkcije spremam u varijablu address, koja je tipa/klase Address jer je funkcija unosAdrese tipa Adress, zato nije Factory iako smo u metodi tog tipa
        Address address = unosAdrese(unos); //ali to trebamo spremiti u neku varijablu

        System.out.print("Koliko želite odabrati artikala za tvornicu?: ");
        Integer brojArtikalaPotvornici = unos.nextInt();//2
        unos.nextLine();

        //Item[] poljeTvorničkiArtikala = new Item[brojArtikalaPotvornici];
        List<Item> listaTvorničkihArtikala = new ArrayList<>();
        // ovo [brojArtikalaPotvornici] definira koliko je polje veliko
        for (int i = 0; i < listaTvorničkihArtikala.size(); i++) {
            Boolean ispravanUnos = true;
            int odabraniArtikl = 0;
            do {
                System.out.println("Odaberite redni broj artikla za tvornicu: ");

                //petlja za ispis svih artikala i to onoliko puta koliko korisnik korisnik hoce artikala (koliko puta ce se izvrsiti definirano je u for petlji prije)
                for (int j = 0; j < listaArtikala.size(); j++) {  //petlja koja ce korisniku ponuditi/ispisati postojece artikle, onoliko puta koliko ima artikala
                    System.out.println("Artikl br " + (j + 1) + ". : " + listaArtikala.get(j).getName());
                    //dohvacam ime svakog artikla/objekta
                }

                Boolean odabirArtikla = false;
                do {
                    try {
                        odabraniArtikl = unos.nextInt(); //unos za redni broj pored artikla
                        unos.nextLine();
                        odabirArtikla = true;
                    } catch (InputMismatchException ex) {
                        unos.nextLine();
                        System.out.print("POGREŠKA!!! Niste unjeli brojčanu vrijednost, odaberite broj pored imena artikla: ");
                        odabirArtikla = false;
                        log.error(ex.getMessage());
                    }
                } while (odabirArtikla == false);

                //metoda koja validira odabir artikla da nije duplic
                try {
                    otkrivanjeDuplikata(listaTvorničkihArtikala, listaArtikala.get(odabraniArtikl - 1));//ako ovdje pogreska, odmah se ide u catch
                    ispravanUnos = true;//ako je bila pogreska, da sljedeci krug petlje postavimo bool na true ako je unos ok
                } catch (SameItemException e) { //obrada iznimke
                    ispravanUnos = false; //da se opet pita unos
                    System.out.println(e.getMessage());
                    log.error(e.getMessage());
                }
            } while (ispravanUnos != true);

            listaTvorničkihArtikala.add(listaArtikala.get(odabraniArtikl - 1));
            //iz poljeSvihArtikala -čupamo polje

        }

        Factory novaTvornica = new Factory(name, address, listaTvorničkihArtikala);
        return novaTvornica;


    }

    /**
     * Metoda za otkrivanje duplih artikala
     *
     * @param poljeArtikla - prima cijelo polje artikala
     * @param item         - jedan artikl usporeduje s cijelim poljem artikala da vidimo je li se vec unio taj artikl
     * @throws SameItemException - baca pogresku ako unesemo isti artikl
     */

    private static void otkrivanjeDuplikata(List<Item> poljeArtikla, Item item) throws SameItemException {
        for (Item privremenaUsporedba : poljeArtikla) { //poljeArtikala živi samo unutar ove metode
            if (privremenaUsporedba != null) {
                if (privremenaUsporedba.equals(item)) {
                    throw new SameItemException("POGREŠKA!! Artikl se ponavlja, ponovo izaberite artikl!");
                }
            }
        }
    }

    /**
     * Metoda za unos adrese, koja ce se kasnije pozivati kod tvornica i trgovina
     *
     * @param unos - varijabla za unos podataka za tvornice
     * @return
     */

    private static Address unosAdrese(Scanner unos) {
        /*private String street;
        private String houseNumber;
        private String city;
        private String postalCode;*/
        System.out.print("Unesite adresu tvornice: ");
        String street = unos.nextLine();
        System.out.print("Unesite kucni broj tvornice: ");
        String houseNumber = unos.nextLine();


        Boolean ispravanUnos = true;
        String city = "";
        /*do {
            System.out.print("Unesite grad tvornice: ");
             city = unos.nextLine(); //Split
            for (Cities privremena : Cities.values()) {
                if (city.toLowerCase(Locale.ROOT).equals(privremena.getNameCity().toLowerCase(Locale.ROOT))) {
                    ispravanUnos = true;
                    break;
                }
                else {
                    ispravanUnos = false;
                    System.out.println("Molimo ponovo unesite grad (Dubrovnik / Split / Zagreb)");

                }

            }
        } while (ispravanUnos == false);*/


        // OVAJ RADI
                        ispravanUnos = false;

                        do {
                            System.out.print("Unesite grad tvornice (Unesite: Dubrovnik / Split / Zagreb): ");
                            city = unos.nextLine();
                            for (Cities privremena : Cities.values()){

                                if (city.toLowerCase().equals(privremena.getNameCity().toLowerCase())){
                                    ispravanUnos = true;
                                    break;
                                }
                            }

                        }while (ispravanUnos == false);



        Address kreiranaAdresa = new Address(street, houseNumber, Cities.valueOf(city));
        return kreiranaAdresa;



    }


    /**
     * Metoda za unos podataka vezano uz kategorije (opis, ime)
     * Metoda također baca korisniku definirano upozorenje ako unese duplo ime kategorije
     *
     * @param unos            - spremamo podatke za kategoriju
     * @param poljeKategorija - unutra spremamo sve kategorije
     * @return
     */
    private static Category unosKategorije(Scanner unos, Category[] poljeKategorija) {//vraca objekt tipa Category, prima objekt tipa Scanner
        System.out.print("Upišite ime kategorije: ");

        //duplo ime??
        //for(Integer broj: poljebrojeva)


        String ime = "";
        Boolean provjeraUnosa = true;

        do {
            try {
                ime = unos.nextLine();
                otkrivanjeDuplogImena(poljeKategorija, ime);
                provjeraUnosa = true;

            } catch (SameCategoryException e) {
                System.out.println(e.getMessage());
                provjeraUnosa = false;
                log.error(e.getMessage());
            }
        } while (provjeraUnosa == false);

        System.out.print("Upišite opis kategorije: ");
        String opis = unos.nextLine();

        Category novaKategorija = new Category(ime, opis);
        return novaKategorija;  //vracamo taj novi objekt onome tko je pozvao funkciju
    }

    /**
     * Metoda za otkrivanje unesenog duplog imena prilikom unosa imena kategorije ili trgovine
     *
     * @param poljeKategorija
     * @param ime
     */

    private static void otkrivanjeDuplogImena(Category[] poljeKategorija, String ime) {
        for (Category privremena : poljeKategorija) {

            if (privremena != null) {
                if (ime.equals(privremena.getName())) {
                    throw new SameCategoryException("POGREŠKA!! Unjeli ste istu kategoriju, ponovite odabir");
                }
            }
        }
    }


    /**
     * Metoda za unos artikala
     *
     * @param unos            - korisnik odabire broj pored artikla, na taj način odabire koji artikl zeli staviti pod koju kategoriju
     * @param poljeKategorija - korisnik odabire kojoj kategoriji pripada odabrani artikl
     * @return
     */


    private static Item unosArtikla(Scanner unos, Category[] poljeKategorija) { //predajem polje kategorija s objektima tipa Category (ali je ono stvoreno u mainu) koje cu kasnije koristiti za poziv kategorije, da mi ih ispise


        System.out.print("Odaberite što želite unjeti: ");
        System.out.print("[1.]Hrana, ");
        System.out.print("[2.]Laptopi, ");
        System.out.print("[3.]Ostalo: ");
        String odabir = unos.nextLine();


        String odabirHrane = "";
        String odabirLaptopa = "";


        if (odabir.equals("1"))  //ako ovo koristiš moraju ići navodnici ""
        {
            System.out.println("Odaberite koju hranu zelite unjeti:");
            System.out.print("[1.] Mrkve, ");
            System.out.println("[2.] Jabuke :");
            odabirHrane = unos.nextLine();
        } else if (odabir.equals("2")) {
            System.out.println("Odabrali ste kategoriju laptopa");
            System.out.println("Želite li unjeti novi artikl pod kategorijom laptopa: DA/NE");
            odabirLaptopa = unos.nextLine();
        } else if (odabir.equals("3")) {
            System.out.println("Odabrali ste kategoriju ostalih proizvoda");
        }


        boolean ispravanUnos = true;
        int broj = 0;
        do {
            System.out.println("Odaberite redni broj kategorije kojoj pripada artikl: "); //ispis imena kateogirje, prije toga broj za odabir
            for (int i = 0; i < poljeKategorija.length; i++) { //duljina polja: nazivPolja.length

                System.out.println("Ime " + (i + 1) + ". kategorije: " + poljeKategorija[i].getName());
                System.out.println("Opis: " + poljeKategorija[i].getDescription());
            }

            try {
                broj = unos.nextInt();//broj=3   poljeKategorija[2]     //1,2 ili 3
                unos.nextLine(); //nextInt() nextBigDecimal()...
                ispravanUnos = true;
            } catch (InputMismatchException ex) {
                unos.nextLine();
                System.out.println("Pogreška !!!! Ponovo unesite broj za redni broj kategorije");
                ispravanUnos = false;
                log.error("Došlo je do pogreške pri unosu rednog broja kategorije", ex);

            }

        } while (ispravanUnos == false);  //ili ispravanUnos != true


        Category odabranaKategorija = poljeKategorija[broj - 1];  //naše poljeKategorija je tipa Category
        //ako korisnik želi odabrati 3. kategoriju, to je nama polje[2], jer polja idu od nula zato je ovo: [broj-1]


        System.out.println("Unesite potrebne podatke za artikl: ");
        System.out.print("Unesite ime artikla: ");

        String ime = "";
        Boolean provjeraUnosa = true;
        do {
            try {
                ime = unos.nextLine();
                provjeraZabranjenihArtikala(ime);
                provjeraUnosa = true;
            } catch (ForbiddenItemException e) {
                log.error(e.getMessage());
                System.out.println(e.getMessage());
                provjeraUnosa = false;
            }
        } while (provjeraUnosa == false);


        BigDecimal width = BigDecimal.valueOf(0);
        BigDecimal height = BigDecimal.valueOf(0);
        BigDecimal lenght = BigDecimal.valueOf(0);
        BigDecimal productionCost = BigDecimal.valueOf(0);
        BigDecimal sellingPrice = BigDecimal.valueOf(0);
        Discount discountAmount = null;

        provjeraUnosa = true;

        do {
            try {
                System.out.print("Unesite širinu artikla: ");
                width = unos.nextBigDecimal();
                unos.nextLine(); //nakon svakog .nextInt i .nextBigDecimal obavezno unos.nextLine
                System.out.print("Unesite visinu artikla: ");
                height = unos.nextBigDecimal();
                unos.nextLine();
                System.out.print("Unesite duljinu artikla: ");
                lenght = unos.nextBigDecimal();
                unos.nextLine();
                System.out.print("Unesi proizvodnu cijenu artikla: ");
                productionCost = unos.nextBigDecimal();
                unos.nextLine();
                System.out.print("Unesi prodajnu cijenu artikla: ");
                sellingPrice = unos.nextBigDecimal();
                unos.nextLine();
                System.out.print("Unesite popust u %: ");
                //stvaramo objekt tipa Discount
                discountAmount = new Discount(unos.nextBigDecimal());
                //za prethodnu liniju mogli smo i ovako: BigDecimal discountAmount = unos.nextBigDecimal()); pa onda napraviti objekt
                //BigDecimal discountAmount = unos.nextBigDecimal();
                unos.nextLine();
                provjeraUnosa = true;
            } catch (InputMismatchException ex) {
                unos.nextLine();
                System.out.println("POGREŠKA!!! Niste unjeli brojčanu vrijednost, molimo ponovite unos");
                provjeraUnosa = false;
                log.error("Došlo do pogreške prilikom upisa vrijednosti vezanih za artikle", ex);

            }
        } while (provjeraUnosa == false);


        if (odabirHrane.equals("1")) {
            //ako je 1 stvaramo objekt mrkve
            //pitam unos weighta
            Boolean ispravanUnosMrkve = false;
            System.out.print("Unesite težinu: ");
            do {
                try {
                    BigDecimal weight = unos.nextBigDecimal();
                    unos.nextLine();
                    ispravanUnosMrkve = true;
                    // zovemo metodu
                    Carrot mrkvaIzPerua = new Carrot(weight, ime, odabranaKategorija, width, height, lenght, productionCost, sellingPrice, discountAmount);
                    int izracunataMrkvaKcal = mrkvaIzPerua.calculateKilocalories(); //zovemo funkciju nad objektom
                    BigDecimal izracunataMrkvaPrice = mrkvaIzPerua.calculatePrice();

                    System.out.println("Odabrana količina mrkve ima ukupno " + izracunataMrkvaKcal + " kilokalorija.");
                    System.out.println("Ukupna cijena za odabranu količinu mrkve je: " + izracunataMrkvaPrice);


                    return mrkvaIzPerua;

                } catch (InputMismatchException ex) {
                    unos.nextLine();
                    System.out.print("GREŠKA!!! Molimo unesite brojčanu vrijednost: ");
                    ispravanUnosMrkve = false;
                    log.error(ex.getMessage());
                }

            } while (ispravanUnosMrkve == false);

        } else if (odabirHrane.equals("2")) {
            Boolean ispravanUnosTezine = false;
            BigDecimal weight = BigDecimal.valueOf(0);
            System.out.print("Unesite težinu: ");

            do {
                try {
                    weight = unos.nextBigDecimal();
                    ispravanUnosTezine = true;
                    unos.nextLine();
                    Apple jabukaIzMeksika = new Apple(weight, ime, odabranaKategorija, width, height, lenght, productionCost, sellingPrice, discountAmount);
                    int izracunataJabukaKcal = jabukaIzMeksika.calculateKilocalories();
                    BigDecimal izracunataJabukaPrice = jabukaIzMeksika.calculatePrice();
                    System.out.println("Odabrana količina mrkve ima ukupno " + izracunataJabukaKcal + " kilokalorija.");
                    System.out.println("Ukupna cijena za odabranu količinu mrkve je: " + izracunataJabukaPrice);
                    return jabukaIzMeksika; //novi objekt kojem cemo upisati neke posebne podatke

                } catch (InputMismatchException ex) {
                    unos.nextLine();
                    System.out.print("POGREŠKA!! Molimo unesite brojčanu vrijednost: ");
                    ispravanUnosTezine = false;
                    log.error(ex.getMessage());
                }

            } while (ispravanUnosTezine == false);


        }

        if (odabirLaptopa.equals("DA")) {
            System.out.println("Prije koliko mjeseci ste kupili laptop: ");
            Boolean unosLaptopa = false;

            do {
                try {
                    Integer brojPotrosenihMjeseci = unos.nextInt();
                    unos.nextLine();
                    unosLaptopa = true;
                    //zovemo konstruktor i predajemo sve parametre
                    //na kraju je sve potrebno return-ati tako da sve spremimo u objekt
                    Laptop noviLaptop = new Laptop(brojPotrosenihMjeseci, ime, odabranaKategorija, width, height, lenght, productionCost, sellingPrice, discountAmount);
                    Integer izracunataPreostalaGarancija = noviLaptop.garatniRok();
                    System.out.println("Do isteka garancije preostalo Vam je još " + izracunataPreostalaGarancija + " mjeseci");
                    return noviLaptop; //ovdje ga returnam, jer u protivnom ce napraviti objekt bazne klase

                } catch (InputMismatchException ex) {
                    unos.nextLine();
                    System.out.print("GREŠKA!!! Molimo unesite brojčanu vrijednost: ");
                    unosLaptopa = false;
                    log.error(ex.getMessage());
                }
            } while (unosLaptopa == false);

        } else if (odabirLaptopa.equals("Ne")) {
            System.out.println("Nastavljamo...");
        }


/**
 *   kreiram konstruktor koji će poslati podatke klasi, konstruktor mora biti tipa istog kao metoda,
 *   odnosno kreiram objekt istog tipa kao i metoda u koji spremam podatke koje ce klasa vratiti, zbog toga moraju biti istog tipa
 *   osim kad prijeđem mišem, mogu vidjeti i u klasi vidjeti koji mi podaci idu pod konstruktor
 *   sad smo sve podatke koje je korisnik unio spremili u jedan objekt klase Item koji se zove noviArtikl i to vracamo
 *  */

        Item noviArtikl = new Item(ime, odabranaKategorija, width, height, lenght, productionCost, sellingPrice, discountAmount);
        System.out.println("Cijena s popustom iznosi: " + noviArtikl.getProdajnaCijenaSpopustom());
        System.out.println("Matrijal od kojeg je napravljen vaš artikl: " + noviArtikl.getName());

        return noviArtikl;


    }

    /**
     * Metooda koja korisniku zabranjuje unos artikla koji su definirani u polju stringova
     * Metoda uspoređuje već uneseno ime artikla sa stringom koji je definiran u polju stringova
     *
     * @param ime - u ovu varijablu spremam unos za ime artikla
     */

    private static void provjeraZabranjenihArtikala(String ime) {

        String[] poljeZabranjenih = {"droga", "puška", "droga", "bomba"};

        for (String privremena : poljeZabranjenih) {

            if (ime.toLowerCase().equals(privremena)) { //stavili smo toLower Case da ih odmah pretvara u mala slova u slučaju ako dođu velika slova na unosu

                throw new ForbiddenItemException("POGREŠKA!! UNJELI STE ZABRANJENJE ARTIKLE! ");
            }

        }
    }

}

