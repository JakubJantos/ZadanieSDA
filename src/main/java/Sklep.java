import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sklep {


    Zwierze z1 = new Zwierze("ssak", "Pies", 100);
    Zwierze z2 = new Zwierze("plaz", "salamandra", 25);
    Zwierze z3 = new Zwierze("gad", "agama", 98);
    Zwierze z4 = new Zwierze("ssak", "Pies", 160);
    Zwierze z5 = new Zwierze("ssak", "Kot", 400);
    Zwierze z6 = new Zwierze("ptak", "papuga", 50);
    Zwierze z7 = new Zwierze("ssak", "Kot", 250);
    Zwierze z8 = new Zwierze("insekty", "mrowki", 45);
    Zwierze z9 = new Zwierze("ptak", "papuga", 80);
    Zwierze z10 = new Zwierze("plaz", "salamandra", 35);


    private List<Zwierze> listaWszystichZwierzat = new ArrayList<>();

    private Set<Zwierze> katalogZwierzat = new HashSet<>();

    private Zamowienie zamowienie = new Zamowienie();

//dodawanie zwierząt
    public void dodajZwierze(Zwierze zwierze){
        listaWszystichZwierzat.add(zwierze);
        katalogZwierzat.addAll(listaWszystichZwierzat);
    }
//odejmowanie zwierząt
    //nie działa poprawnie usówa zwierze "pies" przypisane pod z1 popimo iź podane w parametrze jest z4 (linia 119)
    public void kupionoZwierze(Zwierze zwierze){
        listaWszystichZwierzat.remove(zwierze);
        katalogZwierzat.remove(zwierze);
    }

    public List<Zwierze> znajdzRodzaj(String rodzaj){
        List<Zwierze> znajdzRodzaj = new ArrayList<>();

        for (Zwierze zwierze : listaWszystichZwierzat){
            if (zwierze.getRodzaj().equalsIgnoreCase(rodzaj)){
                znajdzRodzaj.add(zwierze);
            }
            if (znajdzRodzaj.isEmpty()){
                System.out.println("nie mamy takiego rodzaju zwierząt");
            }
        }
        return znajdzRodzaj;
    }
//znajdowanie zwietząt po gatunku
    public List<Zwierze> znajdzGatunek(String gatunek){
        List<Zwierze> znajdzGatunek = new ArrayList<>();

        for (Zwierze zwierze : listaWszystichZwierzat){
            if (zwierze.getGatunek().equalsIgnoreCase(gatunek)){
                znajdzGatunek.add(zwierze);
            }
            if (znajdzGatunek.isEmpty()){
                System.out.println("nie mamy takiego gatunku zwierząt");
            }
        }
        return znajdzGatunek;
    }
//wypisywanie katalogu bez okreslonego gatunku
    //nie działa. :(
    //prawdopodobnie bład logiki poniższej metody. linia 72 zwraca "kot"
    public Set<Zwierze>wypiszZKataloguDostepneZwierzetaOproczGatunku(String gatunek){
        Set<Zwierze>katalogOpruczGatunku = new HashSet<>();

        for (Zwierze zwierze : katalogZwierzat){
            if (zwierze.getGatunek().equalsIgnoreCase(gatunek));
            katalogOpruczGatunku.addAll(katalogZwierzat);
            katalogOpruczGatunku.remove(zwierze);
        }
        if (katalogOpruczGatunku.isEmpty()){
            System.out.println("nie mamy tego gatunku lub został wyprzedany. Więc bez obaw :)");
        }
        return katalogOpruczGatunku;
    }
//sumowanie zwierząt danego gatunku
    public int znajdzLiczbeZwierzatDanegoGatunku(String gatunek){
        int iloscZwieratDanegoGatunku = 0;
        for (Zwierze zwierze : listaWszystichZwierzat){
            if (zwierze.getGatunek().equalsIgnoreCase(gatunek)){
            iloscZwieratDanegoGatunku += 1;
            }
        }
        return iloscZwieratDanegoGatunku;
    }
//kasa fiskalna
    public int obliczSumeZamowienia(Zwierze zwierze, int ilosc ){
        int cenaZwierzaka = zwierze.getCena();
        cenaZwierzaka = cenaZwierzaka * ilosc;
        return cenaZwierzaka;
    }



    public static void main(String[] args) {
        Sklep sklep = new Sklep();

        sklep.dodajZwierze(sklep.z1);
        sklep.dodajZwierze(sklep.z2);
        sklep.dodajZwierze(sklep.z3);
        sklep.dodajZwierze(sklep.z4);
        sklep.dodajZwierze(sklep.z5);
        sklep.dodajZwierze(sklep.z6);
        sklep.dodajZwierze(sklep.z7);
        sklep.dodajZwierze(sklep.z8);
        sklep.dodajZwierze(sklep.z9);
        sklep.dodajZwierze(sklep.z10);

        System.out.println("I.a Test: "+sklep.listaWszystichZwierzat);
        System.out.println("");
        System.out.println("I.b Test: "+sklep.katalogZwierzat);
        System.out.println("");

        sklep.kupionoZwierze(sklep.z2);
        sklep.kupionoZwierze(sklep.z4);
        sklep.kupionoZwierze(sklep.z6);

        System.out.println("II.a Test: "+sklep.listaWszystichZwierzat);
        System.out.println("");
        System.out.println("II.b Test: "+sklep.katalogZwierzat);
        System.out.println("");

        System.out.println("III Test: "+sklep.znajdzRodzaj("ssak"));
        System.out.println("");

        System.out.println("IV Test: "+sklep.znajdzGatunek("pies"));
        System.out.println("");

        System.out.println("V Test: "+ sklep.wypiszZKataloguDostepneZwierzetaOproczGatunku("pies"));
        System.out.println("");

        System.out.println("V.a Test: " + sklep.znajdzLiczbeZwierzatDanegoGatunku("pies"));
        System.out.println("");
        System.out.println("V.b Test: " + sklep.znajdzLiczbeZwierzatDanegoGatunku("pajak"));
        System.out.println("");

        System.out.println("VI Test: " + sklep.obliczSumeZamowienia(sklep.z5, 3));
    }
}
