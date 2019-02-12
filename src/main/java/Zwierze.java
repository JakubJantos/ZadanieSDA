
public class Zwierze {
private String rodzaj;
private String gatunek;
private int cena;

    public Zwierze(String rodzaj, String gatunek, int cena) {
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.cena = cena;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zwierze zwierze = (Zwierze) o;

        return gatunek.equals(zwierze.gatunek);
    }

    @Override
    public int hashCode() {
        return gatunek.hashCode();
    }

    @Override
    public String toString() {
        return "\n" + "Zwierze{" +
                "rodzaj='" + rodzaj + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", cena=" + cena +
                '}';
    }
}