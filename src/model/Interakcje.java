package model;

public class Interakcje {

	int kod_Lekarstwa1, kod_Lekarstwa2;
	@Override
	public String toString() {
		return "kod_Lekarstwa1: " + kod_Lekarstwa1 + ", kod_Lekarstwa2:" + kod_Lekarstwa2 + ", opis:" + opis;
				
	}
	public Interakcje(int kod_Lekarstwa1, int kod_Lekarstwa2, String opis) {
		super();
		this.kod_Lekarstwa1 = kod_Lekarstwa1;
		this.kod_Lekarstwa2 = kod_Lekarstwa2;
		this.opis = opis;
	}
	public int getKod_Lekarstwa1() {
		return kod_Lekarstwa1;
	}
	public void setKod_Lekarstwa1(int kod_Lekarstwa1) {
		this.kod_Lekarstwa1 = kod_Lekarstwa1;
	}
	public int getKod_Lekarstwa2() {
		return kod_Lekarstwa2;
	}
	public void setKod_Lekarstwa2(int kod_Lekarstwa2) {
		this.kod_Lekarstwa2 = kod_Lekarstwa2;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	String opis;
}
