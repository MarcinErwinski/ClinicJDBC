package model;

public class Leczy {
	int kod_lekarstwa,kod_choroby;
	public Leczy(int kod_lekarstwa, int kod_choroby, String typowa_Dawka, String jednostka_Miary,
			String typowe_Dawkowanie, String typowy_Okres) {
		super();
		this.kod_lekarstwa = kod_lekarstwa;
		this.kod_choroby = kod_choroby;
		this.typowa_Dawka = typowa_Dawka;
		this.jednostka_Miary = jednostka_Miary;
		this.typowe_Dawkowanie = typowe_Dawkowanie;
		this.typowy_Okres = typowy_Okres;
	}
	@Override
	public String toString() {
		return "kod lekarstwa" + kod_lekarstwa + ", kod choroby=" + kod_choroby + ", Typowa Dawka:"
				+ typowa_Dawka + " "+jednostka_Miary  + " "+ typowe_Dawkowanie
				+ " przez " + typowy_Okres;
	}
	public int getKod_lekarstwa() {
		return kod_lekarstwa;
	}
	public void setKod_lekarstwa(int kod_lekarstwa) {
		this.kod_lekarstwa = kod_lekarstwa;
	}
	public int getKod_choroby() {
		return kod_choroby;
	}
	public void setKod_choroby(int kod_choroby) {
		this.kod_choroby = kod_choroby;
	}
	public String getTypowa_Dawka() {
		return typowa_Dawka;
	}
	public void setTypowa_Dawka(String typowa_Dawka) {
		this.typowa_Dawka = typowa_Dawka;
	}
	public String getJednostka_Miary() {
		return jednostka_Miary;
	}
	public void setJednostka_Miary(String jednostka_Miary) {
		this.jednostka_Miary = jednostka_Miary;
	}
	public String getTypowe_Dawkowanie() {
		return typowe_Dawkowanie;
	}
	public void setTypowe_Dawkowanie(String typowe_Dawkowanie) {
		this.typowe_Dawkowanie = typowe_Dawkowanie;
	}
	public String getTypowy_Okres() {
		return typowy_Okres;
	}
	public void setTypowy_Okres(String typowy_Okres) {
		this.typowy_Okres = typowy_Okres;
	}
	String typowa_Dawka, jednostka_Miary, typowe_Dawkowanie, typowy_Okres;
}
