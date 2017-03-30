package model;
 
public class Lekarz {
	 	private int nr_Lekarza;
	 	private String imie;
	    private String nazwisko;
	    private String telefon;
	    
	    public int getNr_Lekarza() {
	        return nr_Lekarza;
	    }
	    public void setNr_Lekarza(int  nr_Lekarza) {
	        this.nr_Lekarza = nr_Lekarza;
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
	    public Lekarz() {}
	    public Lekarz(int  nr_Lekarza, String imie, String nazwisko, String telefon) {
	        this. nr_Lekarza = nr_Lekarza;
	        this.imie = imie;
	        this.nazwisko = nazwisko;
	        this.telefon = telefon;
	    }
	 
	    @Override
	    public String toString() {
	        return String.format("[%.2s] ",nr_Lekarza)+String.format(" %.12s ", imie)+String.format(" %.20s ",nazwisko)+String.format(" +48 %.12s",telefon);
	    }
	}