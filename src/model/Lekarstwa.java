package model;

public class Lekarstwa {
	@Override
	public String toString() {
		return "[" + kod_Lekarstwa + "] " + nazwa_Lekarstwa + ", Sklad:" + sklad
				+ ",\n Przeciwskazania:" + przeciwskazania + ", \nSkutki uboczne: " + skutki_Uboczne + "\n";
	}
	public int getKod_Lekarstwa() {
		return kod_Lekarstwa;
	}
	public void setKod_Lekarstwa(int kod_Lekarstwa) {
		this.kod_Lekarstwa = kod_Lekarstwa;
	}
	public String getNazwa_Lekarstwa() {
		return nazwa_Lekarstwa;
	}
	public void setNazwa_Lekarstwa(String nazwa_Lekarstwa) {
		this.nazwa_Lekarstwa = nazwa_Lekarstwa;
	}
	public String getSklad() {
		return sklad;
	}
	public void setSklad(String sklad) {
		this.sklad = sklad;
	}
	public String getPrzeciwskazania() {
		return przeciwskazania;
	}
	public void setPrzeciwskazania(String przeciwskazania) {
		this.przeciwskazania = przeciwskazania;
	}
	public String getSkutki_Uboczne() {
		return skutki_Uboczne;
	}
	public void setSkutki_Uboczne(String skutki_Uboczne) {
		this.skutki_Uboczne = skutki_Uboczne;
	}
	public Lekarstwa(int kod_Lekarstwa, String nazwa_Lekarstwa, String sklad, String przeciwskazania,
			String skutki_Uboczne) {
		super();
		this.kod_Lekarstwa = kod_Lekarstwa;
		this.nazwa_Lekarstwa = nazwa_Lekarstwa;
		this.sklad = sklad;
		this.przeciwskazania = przeciwskazania;
		this.skutki_Uboczne = skutki_Uboczne;
	}
	int kod_Lekarstwa;
	String nazwa_Lekarstwa, sklad, przeciwskazania,skutki_Uboczne;
}
