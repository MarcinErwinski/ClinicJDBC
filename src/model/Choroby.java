package model;

public class Choroby {
	int kod_Choroby;
	@Override
	public String toString() {
		return String.format("[%.10s] ",kod_Choroby) + String.format("%.50s ",nazwa_Choroby) + " objawy:" + String.format("%.50s ",objawy)
				+ " leczenie: " + String.format("%.50s ",leczenie);
	}
	public int getKod_Choroby() {
		return kod_Choroby;
	}
	public void setKod_Choroby(int kod_Choroby) {
		this.kod_Choroby = kod_Choroby;
	}
	public String getNazwa_Choroby() {
		return nazwa_Choroby;
	}
	public void setNazwa_Choroby(String nazwa_Choroby) {
		this.nazwa_Choroby = nazwa_Choroby;
	}
	public String getObjawy() {
		return objawy;
	}
	public void setObjawy(String objawy) {
		this.objawy = objawy;
	}
	public String getLeczenie() {
		return leczenie;
	}
	public void setLeczenie(String leczenie) {
		this.leczenie = leczenie;
	}
	public Choroby(int kod_Choroby, String nazwa_Choroby, String objawy, String leczenie) {
		super();
		this.kod_Choroby = kod_Choroby;
		this.nazwa_Choroby = nazwa_Choroby;
		this.objawy = objawy;
		this.leczenie = leczenie;
	}
	String nazwa_Choroby, objawy, leczenie;
}
