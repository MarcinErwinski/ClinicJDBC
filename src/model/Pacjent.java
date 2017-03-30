package model;
 
public class Pacjent {
    private int nr_Ubezpieczenia;
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    
    public int getNr_Ubezpieczenia() {
        return nr_Ubezpieczenia;
    }
    public void setNr_Ubezpieczenia(int  nr_Ubezpieczenia) {
        this.nr_Ubezpieczenia = nr_Ubezpieczenia;
    }
    
    
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie ;
    }
    
    
    
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
    public Pacjent() {}
    public Pacjent(int  nr_Ubezpieczenia, String imie, String nazwisko, String adres, String telefon) {
        this. nr_Ubezpieczenia = nr_Ubezpieczenia;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres=adres;
        this.telefon=telefon;
    }
 
    @Override
    public String toString() {
        return String.format("[%.2s] ",nr_Ubezpieczenia)+" "+String.format("[%.10s]" ,imie)+" "+String.format("[%.10s] ",nazwisko)+" "+String.format("[%.10s] ",adres)+" +48"+String.format("[%.9s] ",telefon);
    }
	
}