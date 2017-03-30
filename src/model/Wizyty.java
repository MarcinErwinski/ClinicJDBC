package model;

public class Wizyty {
	Integer nr_Wizyty;
	String imie_Pacjenta, nazwisko_Pacjenta ,imie_Lekarza, nazwisko_Lekarza,data_Wizyty,objawy,notatki;
	
	public int getNr_Wizyty() {
		return nr_Wizyty;
	}

	public void setNr_Wizyty(int nr_Wizyty) {
		this.nr_Wizyty = nr_Wizyty;
	}

	public Wizyty(String imie_Pacjenta, String nazwisko_Pacjenta, String imie_Lekarza, String nazwisko_Lekarza, int nr_Wizyty,
			String data_Wizyty, String objawy, String notatki) {
		super();
		this.imie_Pacjenta = imie_Pacjenta;
		this.nazwisko_Pacjenta = nazwisko_Pacjenta;
		this.imie_Lekarza = imie_Lekarza;
		this.nazwisko_Lekarza = nazwisko_Lekarza;
		this.nr_Wizyty=nr_Wizyty;
		this.data_Wizyty = data_Wizyty;
		this.objawy = objawy;
		this.notatki = notatki;
	}

	public String getImie_Pacjenta() {
		return imie_Pacjenta;
	}

	public void setImie_Pacjenta(String imie_Pacjenta) {
		this.imie_Pacjenta = imie_Pacjenta;
	}

	public String getNazwisko_Pacjenta() {
		return nazwisko_Pacjenta;
	}

	public void setNazwisko_Pacjenta(String nazwisko_Pacjenta) {
		this.nazwisko_Pacjenta = nazwisko_Pacjenta;
	}

	public String getImie_Lekarza() {
		return imie_Lekarza;
	}

	public void setImie_Lekarza(String imie_Lekarza) {
		this.imie_Lekarza = imie_Lekarza;
	}

	public String getNazwisko_Lekarza() {
		return nazwisko_Lekarza;
	}

	public void setNazwisko_Lekarza(String nazwisko_Lekarza) {
		this.nazwisko_Lekarza = nazwisko_Lekarza;
	}

	public String getData_Wizyty() {
		return data_Wizyty;
	}

	public void setData_Wizyty(String data_Wizyty) {
		this.data_Wizyty = data_Wizyty;
	}

	public String getObjawy() {
		return objawy;
	}

	public void setObjawy(String objawy) {
		this.objawy = objawy;
	}

	public String getNotatki() {
		return notatki;
	}

	public void setNotatki(String notatki) {
		this.notatki = notatki;
	}

	@Override
	public String toString() {
		return  nr_Wizyty + imie_Pacjenta +  nazwisko_Pacjenta 
				+ imie_Lekarza + nazwisko_Lekarza             
				 + data_Wizyty  + objawy  + notatki ;
	}
   




}