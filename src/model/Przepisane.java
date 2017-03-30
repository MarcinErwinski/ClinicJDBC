package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Przepisane {

	@Override
	public String toString() {
		return "[Wizyta: " + nr_Wizyty + "] Przepisane lekarstwo " + nazwa_Lekarstwa + " dawka: " + dawka
				+jednostka_Miary + " " + dawkowanie + " przez " + okres;
	}
	int nr_Wizyty;
	String nazwa_Lekarstwa,dawka,jednostka_Miary, dawkowanie,okres;
	public Przepisane(int nr_Wizyty, String nazwa_Lekarstwa, String dawka, String jednostka_Miary, String dawkowanie,
			String okres) {
		super();
		this.nr_Wizyty = nr_Wizyty;
		this.nazwa_Lekarstwa = nazwa_Lekarstwa;
		this.dawka = dawka;
		this.jednostka_Miary = jednostka_Miary;
		this.dawkowanie = dawkowanie;
		this.okres = okres;
	}
	public int getNr_Wizyty() {
		return nr_Wizyty;
	}
	public void setNr_Wizyty(int nr_Wizyty) {
		this.nr_Wizyty = nr_Wizyty;
	}
	public String getNazwa_Lekarstwa() {
		return nazwa_Lekarstwa;
	}
	public void setNazwa_Lekarstwa(String nazwa_Lekarstwa) {
		this.nazwa_Lekarstwa = nazwa_Lekarstwa;
	}
	public String getDawka() {
		return dawka;
	}
	public void setDawka(String dawka) {
		this.dawka = dawka;
	}
	public String getJednostka_Miary() {
		return jednostka_Miary;
	}
	public void setJednostka_Miary(String jednostka_Miary) {
		this.jednostka_Miary = jednostka_Miary;
	}
	public String getDawkowanie() {
		return dawkowanie;
	}
	public void setDawkowanie(String dawkowanie) {
		this.dawkowanie = dawkowanie;
	}
	public String getOkres() {
		return okres;
	}
	public void setOkres(String okres) {
		this.okres = okres;
	}
	
}
