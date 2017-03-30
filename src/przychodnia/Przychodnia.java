package przychodnia;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import model.Choroby;
import model.Interakcje;
import model.Leczy;
import model.Lekarstwa;
import model.Lekarz;
import model.Pacjent;
import model.Przepisane;
import model.Wizyty;

 
public class Przychodnia {
 
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:przychodnia.db";
 
    private Connection conn;
    private Statement stat;
 
    public Przychodnia() {
        try {
            Class.forName(Przychodnia.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
 
        createTables();
    }
 
   public boolean createTables()  {
        String createLekarze = "CREATE TABLE IF NOT EXISTS Lekarze (nr_Lekarza INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , imie varchar(255), nazwisko varchar(255), telefon varchar(9))";
        String createPacjenci = "CREATE TABLE IF NOT EXISTS Pacjenci (nr_Ubezpieczenia INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, imie varchar(255), nazwisko varchar(255),adres varchar(255),telefon varchar(9))";
        String createWizyty = "CREATE TABLE IF NOT EXISTS Wizyty (  NR_WIZYTY        INTEGER    NOT NULL, NR_UBEZPIECZENIA INTEGER  NOT NULL,NR_LEKARZA       INTEGER NOT NULL, DATA_WIZYTY      CHAR       NOT NULL,OBJAWY           CHAR (200) NOT NULL,NOTATKI          CHAR (200),PRIMARY KEY (NR_WIZYTY),FOREIGN KEY (NR_UBEZPIECZENIA)REFERENCES PACJENCI,FOREIGN KEY (NR_LEKARZA) REFERENCES LEKARZE)";
        String createPrzepisane = "CREATE TABLE IF NOT EXISTS Przepisane ( NR_WIZYTY INTEGER NOT NULL, KOD_LEKARSTWA INTEGER  NOT NULL,DAWKA VARCHAR NOT NULL,  JEDNOSTKA_MIARY VARCHAR NOT NULL ,DAWKOWANIE VARCHAR NOT NULL, OKRES VARCHAR NOT NULL,FOREIGN KEY (NR_WIZYTY)REFERENCES WIZYTY,FOREIGN KEY (KOD_LEKARSTWA) REFERENCES LEKARSTWA)";
    	
        try {
            stat.execute(createLekarze);
            stat.execute(createPacjenci);
            stat.execute(createWizyty);
            stat.execute(createPrzepisane);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 	
   public boolean deletePacjent(String imie , String nazwisko,String adres, String telefon) {
       try {
          stat.executeUpdate("delete from Pacjenci where imie='"+imie+"' and nazwisko='"+nazwisko+"' and adres='"+adres+"' and telefon='"+telefon+"'");
       } catch (SQLException e) {
           System.err.println("Blad przy usuwaniu pacjenta");
           e.printStackTrace();
           return false;
       }
       return true;
   }
   public boolean deleteLekarz(String imie , String nazwisko, String telefon) {
	   try {
	          stat.executeUpdate("delete from Lekarze where imie='"+imie+"' and nazwisko='"+nazwisko+"' and telefon='"+telefon+"'");
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu pacjenta");
	           e.printStackTrace();
           return false;
       }
       return true;
   }
   public boolean deleteWizyty( String nr_Wizyty) {
	   try {
		   
		   stat.executeUpdate("DELETE FROM wizyty WHERE NR_WIZYTY = '"+nr_Wizyty+"'");

				  
       	
		   
	         
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu wizyty");
	           e.printStackTrace();
        return false;
    }
    return true;
   }

   public boolean deletePrzepisane(int nr_Wizyty,String nazwa_Lekarstwa) {
try {
	 		ResultSet result3 = stat.executeQuery("SELECT kod_lekarstwa FROM LEKARSTWA WHERE nazwa_Lekarstwa='"+nazwa_Lekarstwa+"'");
	 		int kod_lekarstwa = result3.getInt("kod_lekarstwa");
	 	PreparedStatement prepStmt2 = conn.prepareStatement("DELETE FROM przepisane WHERE NR_WIZYTY = '"+nr_Wizyty+"' and KOD_LEKARSTWA='"+kod_lekarstwa+"'" );

		
	 		 
	 		 
	 		 prepStmt2.executeUpdate();
	         
	 		 
	 		 
	 		 
	           
	         
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu przepisanych lekow");
	           e.printStackTrace();
        return false;
    }
    return true;
   }
   public boolean deleteLekarstwo(String nazwa_Lekarstwa, String sklad,String przeciwskazania, String skutki_Uboczne) {
	   try {
	          stat.executeUpdate("delete from Lekarstwa where nazwa_Lekarstwa='"+nazwa_Lekarstwa+"' and sklad='"+sklad+"' and przeciwskazania='"+przeciwskazania+"' and skutki_Uboczne='"+skutki_Uboczne+"'");
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu lekarstwa");
	           e.printStackTrace();
        return false;
    }
    return true;
}
   public boolean deleteLeczy(int kod_lekarstwa, int kod_choroby, String typowa_dawka,String jednostka_miary, String typowe_dawkowanie, String typowy_okres) {
	   try {
	          stat.executeUpdate("delete from leczy where kod_lekarstwa='"+kod_lekarstwa+"' and kod_choroby='"+kod_choroby+"' and typowa_dawka='"+typowa_dawka+"' and jednostka_miary='"+jednostka_miary+"' and typowe_dawkowanie='"+typowe_dawkowanie+"' and typowy_okres='"+typowy_okres+"'");
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu leczy");
	           e.printStackTrace();
     return false;
 }
 return true;
}
   public boolean deleteChoroby(String nazwa_Choroby, String objawy,String leczenie) {
	   try {
	          stat.executeUpdate("delete from leczy where nazwa_Choroby='"+nazwa_Choroby+"' and objawy='"+objawy+"' and leczenie='"+leczenie+"'");
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu choroby");
	           e.printStackTrace();
  return false;
}
return true;
}
   public boolean deleteInterakcje(int kod_lekarstwa1, int kod_lekarstwa2, String opis ) {
	   try {
	          stat.executeUpdate("delete from interakcje where kod_lekarstwa1='"+kod_lekarstwa1+"' and kod_lekarstwa2='"+kod_lekarstwa2+"' and opis='"+opis+"'");
	       } catch (SQLException e) {
	           System.err.println("Blad przy usuwaniu interakcji");
	           e.printStackTrace();
return false;
}
return true;
}
    public boolean insertPacjent(String imie , String nazwisko,String adres, String telefon) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Pacjenci (nr_ubezpieczenia,imie,nazwisko,adres,telefon) values (?, ?, ?,?,?);");
           
            prepStmt.setString(2, imie);
            prepStmt.setString(3, nazwisko);
     
            prepStmt.setString(4, adres);
            prepStmt.setString(5, telefon);
            
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu pacjenta");
            e.printStackTrace();
            return false;
        }
        return true;
    }
   
 
    public boolean insertLekarz(String imie , String nazwisko, String telefon) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into lekarze (nr_lekarza,imie,nazwisko,telefon)values (?, ?, ?,?);");
            
            prepStmt.setString(2,imie);
            prepStmt.setString(3,nazwisko);
            prepStmt.setString(4,telefon);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu lekarza");
            return false;
        }
        return true;
    }
    
    public boolean insertWizyty( String imie_Pacjenta,String nazwisko_Pacjenta ,String imie_Lekarza, String nazwisko_Lekarza,String data_Wizyty,String objawy,String notatki) {
        try {
        	
        	//ResultSet result = stat.executeQuery("select nr_ubezpieczenia from pacjenci where imie=@imie_Pacjenta and nazwisko=@nazwisko_Pacjenta");
        	//ResultSet result = stat.executeQuery("select nr_ubezpieczenia from pacjenci where imie like"+  and nazwisko=?");
        	//ResultSet result = stat.executeQuery("select nr_ubezpieczenia from pacjenci where imie="+imie_Pacjenta+" and nazwisko="+nazwisko_Pacjenta);
        	
        	//System.out.println(result.getInt(1));
        	//ResultSet result1 = stat.executeQuery(("select nr_lekarza from lekarze where imie=@imie_Lekarza and nazwisko=@nazwisko_Lekarza"));
        	//ResultSet result1 = stat.executeQuery(("select nr_lekarza from lekarze where imie=? and nazwisko=?"));
        	//ResultSet result1 = stat.executeQuery("select nr_lekarza from lekarze where imie="+imie_Lekarza+" and nazwisko="+nazwisko_Lekarza);
        	
            PreparedStatement prepStmt = conn.prepareStatement("insert into  wizyty (nr_Wizyty, nr_ubezpieczenia, nr_lekarza, data_wizyty,objawy,notatki) values (?, ?, ?,?,?,?);");
          
            ResultSet result = stat.executeQuery("select nr_ubezpieczenia from pacjenci where `imie` like '%"+imie_Pacjenta+"%' and `nazwisko` like '%"+nazwisko_Pacjenta+"%'");
            prepStmt.setInt(2,result.getInt(1));
            ResultSet result1 = stat.executeQuery("select nr_lekarza from lekarze where `imie` like '%"+imie_Lekarza+"%' and `nazwisko` like '%"+nazwisko_Lekarza+"%'");
        	
            prepStmt.setInt(3, result1.getInt("nr_lekarza"));
            prepStmt.setString(4,data_Wizyty);
            prepStmt.setString(5,objawy);
            prepStmt.setString(6,notatki);
            prepStmt.executeUpdate();
            
        } catch (SQLException e) {
        	
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean insertPrzepisane(int nr_Wizyty,String nazwa_Lekarstwa, String dawka,String jednostka_Miary, String dawkowanie, String okres) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Przepisane(nr_wizyty,kod_lekarstwa,dawka,jednostka_miary,dawkowanie,okres) values (?, ?, ?,?,?,?);");
            prepStmt.setInt(1, nr_Wizyty);
            ResultSet result1 = stat.executeQuery("select kod_lekarstwa from lekarstwa where `nazwa_lekarstwa` like '"+nazwa_Lekarstwa+"'");
            prepStmt.setInt(2,result1.getInt("kod_lekarstwa"));
            prepStmt.setString(3,dawka);
            prepStmt.setString(4,jednostka_Miary);
            prepStmt.setString(5,dawkowanie);
            prepStmt.setString(6,okres);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean insertLekarstwo(String nazwa_Lekarstwa, String sklad,String przeciwskazania, String skutki_Uboczne) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Lekarstwa( kod_lekarstwa,nazwa_Lekarstwa,  sklad, przeciwskazania,  skutki_Uboczne) values (?, ?, ?,?,?);");
          
            
            prepStmt.setString(2,nazwa_Lekarstwa);
            prepStmt.setString(3,sklad);
            prepStmt.setString(4,przeciwskazania);
            prepStmt.setString(5,skutki_Uboczne);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean insertLeczy(int kod_lekarstwa, int kod_choroby, String typowa_dawka,String jednostka_miary, String typowe_dawkowanie, String typowy_okres) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Leczy( kod_lekarstwa,kod_choroby,  typowa_dawka, jednostka_miary, typowe_dawkowanie,typowy_okres) values (?, ?, ?,?,?,?);");
          
            prepStmt.setInt(1,kod_lekarstwa);
            prepStmt.setInt(2,kod_choroby);
            prepStmt.setString(3,typowa_dawka);
            prepStmt.setString(4,jednostka_miary);
            prepStmt.setString(5,typowe_dawkowanie);
            prepStmt.setString(6,typowy_okres);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertChoroby(String nazwa_Choroby, String objawy,String leczenie) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Choroby(kod_choroby,nazwa_Choroby,  objawy, leczenie) values (?,?,?,?);");
          
         
            prepStmt.setString(2,nazwa_Choroby);
            prepStmt.setString(3,objawy);
            prepStmt.setString(4,leczenie);
           
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    
    }
    public boolean insertInterakcje(int kod_lekarstwa1, int kod_lekarstwa2, String opis ) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Interakcje(kod_lekarstwa1,  kod_lekarstwa2,  opis) values (?,?,?);");
          
         
            prepStmt.setInt(1,kod_lekarstwa1);
            prepStmt.setInt(2,kod_lekarstwa2);
            prepStmt.setString(3,opis);
           
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    
    }
    
    

    public List<Lekarz> selectLekarze() {
        List<Lekarz> lekarze = new LinkedList<Lekarz>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Lekarze");
            int nr_Lekarza;
            String imie, nazwisko, telefon;
            while(result.next()) {
                nr_Lekarza = result.getInt("Nr_lekarza");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                telefon = result.getString("telefon");
                lekarze.add(new Lekarz(nr_Lekarza, imie, nazwisko, telefon));
            }
        } catch (SQLException e) {
        	//System.out.println(e.getErrorCode());
        
            e.printStackTrace();
            return null;
        }
        return lekarze;
    }
    
    public List<Lekarz> selectLekarzePoNazwisku(String nazwisko) {
        List<Lekarz> lekarze = new LinkedList<Lekarz>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Lekarze where `nazwisko` like '%"+nazwisko+"%' group by nazwisko,imie");
            int nr_Lekarza;
            String imie, telefon;
            while(result.next()) {
                nr_Lekarza = result.getInt("Nr_lekarza");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                telefon = result.getString("telefon");
                lekarze.add(new Lekarz(nr_Lekarza, imie, nazwisko, telefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lekarze;
    }
    
 
    public List<Pacjent> selectPacjenci() {
        List<Pacjent> pacjenci = new LinkedList<Pacjent>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM pacjenci");
            int nr_ubezpieczenia;
            String imie, nazwisko,adres,telefon;
            while(result.next()) {
                nr_ubezpieczenia = result.getInt("nr_ubezpieczenia");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                adres=result.getString("adres");
                telefon=result.getString("telefon");
                pacjenci.add(new Pacjent(nr_ubezpieczenia, imie, nazwisko,adres,telefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pacjenci;
    }
    
    public List<Pacjent> selectPacjenciPoNazwisku(String nazwisko) {
        List<Pacjent> pacjenci = new LinkedList<Pacjent>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM pacjenci where `nazwisko` like '%"+nazwisko+"%' group by nazwisko");
            int nr_ubezpieczenia;
            String imie, adres,telefon;					 
            while(result.next()) {
                nr_ubezpieczenia = result.getInt("nr_ubezpieczenia");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                adres=result.getString("adres");
                telefon=result.getString("telefon");
                pacjenci.add(new Pacjent(nr_ubezpieczenia, imie, nazwisko,adres,telefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pacjenci;
    }
    
    public List<Wizyty> selectWizyty() {
        List<Wizyty> wizyty = new LinkedList<>();
        try {
            ResultSet result = stat.executeQuery("SELECT pacjenci.imie as imie_pacjenta, pacjenci.NAZWISKO as nazwisko_pacjenta,lekarze.IMIE as imie_lekarza,lekarze.NAZWISKO as nazwisko_lekarza, wizyty.data_Wizyty,wizyty.NR_WIZYTY, wizyty.objawy, wizyty.notatki FROM pacjenci,lekarze,wizyty WHERE pacjenci.NR_UBEZPIECZENIA = wizyty.NR_UBEZPIECZENIA AND lekarze.NR_LEKARZA=wizyty.NR_LEKARZA");
        	//ResultSet result = stat.executeQuery("SELECT * from WIZYTY");
            int nr_Wizyty;
            String imie_Pacjenta, nazwisko_Pacjenta ,imie_Lekarza, nazwisko_Lekarza,data_Wizyty,objawy,notatki;
			
            //int nr_Wizyty,nr_Ubezpieczenia,nr_Lekarza;
        	//String data_Wizyty,objawy,notatki;
            while(result.next()) {
            	/*
            	nr_Wizyty=result.getInt("nr_wizyty");
            	nr_Ubezpieczenia=result.getInt("nr_ubezpieczenia");
            	nr_Lekarza=result.getInt("nr_lekarza");
            	
            	data_Wizyty=result.getString("data_Wizyty");
                objawy=result.getString("objawy");
                notatki=result.getString("notatki");
            	*/
                imie_Pacjenta = result.getString("imie_pacjenta");
                nazwisko_Pacjenta = result.getString("nazwisko_pacjenta");
                imie_Lekarza=result.getString("imie_lekarza");
                nazwisko_Lekarza=result.getString("nazwisko_lekarza");
                nr_Wizyty=result.getInt("nr_Wizyty");
                data_Wizyty=result.getString("data_Wizyty");
                objawy=result.getString("objawy");
                notatki=result.getString("notatki");
         
               // wizyty.add(new Wizyty (nr_Wizyty,nr_Ubezpieczenia,nr_Lekarza,data_Wizyty,objawy,notatki));
                wizyty.add(new Wizyty( imie_Pacjenta, nazwisko_Pacjenta ,imie_Lekarza, nazwisko_Lekarza,nr_Wizyty,data_Wizyty,objawy,notatki));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return wizyty;
    }
 
    
    

    public List<Przepisane> selectPrzepisane() {
        List<Przepisane> przepisane = new LinkedList<Przepisane>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Przepisane,lekarstwa where przepisane.kod_lekarstwa=lekarstwa.kod_lekarstwa ORDER BY NR_WIZYTY");
            
            int nr_Wizyty;
			String nazwa_Lekarstwa;
        	String dawka,jednostka_Miary, dawkowanie,okres;
            while(result.next()) {
              nr_Wizyty=result.getInt("nr_Wizyty");
              nazwa_Lekarstwa = result.getString("nazwa_Lekarstwa");
              dawka=result.getString("dawka");
              jednostka_Miary=result.getString("jednostka_Miary");
              dawkowanie=result.getString("dawkowanie");
              okres=result.getString("okres");
              
              przepisane.add(new Przepisane(nr_Wizyty, nazwa_Lekarstwa, dawka, jednostka_Miary, dawkowanie, okres));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return przepisane;
        
        
    }
    
    public List<Lekarstwa> selectLekarstwa() {
        List<Lekarstwa> lekarstwa = new LinkedList<Lekarstwa>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM lekarstwa");
            
            int kod_Lekarstwa;
        	String nazwa_Lekarstwa, sklad, przeciwskazania,skutki_Uboczne;
            while(result.next()) {
             kod_Lekarstwa=result.getInt("kod_Lekarstwa");
             nazwa_Lekarstwa=result.getString("nazwa_Lekarstwa");
             sklad=result.getString("sklad");
             przeciwskazania=result.getString("przeciwskazania");
             skutki_Uboczne=result.getString("skutki_Uboczne");
              lekarstwa.add(new Lekarstwa(kod_Lekarstwa, nazwa_Lekarstwa, sklad, przeciwskazania, skutki_Uboczne));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lekarstwa;
        
        
    }
    public List<Lekarstwa> selectLekarstwaPoNazwie(String nazwa_Lekarstwa) {
        List<Lekarstwa> lekarstwa = new LinkedList<Lekarstwa>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM lekarstwa where nazwa_Lekarstwa like '%"+nazwa_Lekarstwa+"%' group by nazwa_lekarstwa"); 
            
            int kod_Lekarstwa;
        	String  sklad, przeciwskazania,skutki_Uboczne;
            while(result.next()) {
             kod_Lekarstwa=result.getInt("kod_Lekarstwa");
             nazwa_Lekarstwa=result.getString("nazwa_Lekarstwa");
             sklad=result.getString("sklad");
             przeciwskazania=result.getString("przeciwskazania");
             skutki_Uboczne=result.getString("skutki_Uboczne");
              lekarstwa.add(new Lekarstwa(kod_Lekarstwa, nazwa_Lekarstwa, sklad, przeciwskazania, skutki_Uboczne));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());
            return null;
        }
        return lekarstwa;
        
        
    }
    
    public List<Interakcje> selectInterakcje() {
        List<Interakcje> interakcje = new LinkedList<Interakcje>();
        try {
        	int kod_Lekarstwa1,kod_Lekarstwa2;
        	String opis;
        	ResultSet result = stat.executeQuery("SELECT * FROM Interakcje");
           
           
            while(result.next()) {
            	 kod_Lekarstwa1=result.getInt("kod_Lekarstwa1");
            	 kod_Lekarstwa2=result.getInt("kod_Lekarstwa2");
                 opis=result.getString("opis");
                 
              

            
              interakcje.add(new Interakcje(kod_Lekarstwa1, kod_Lekarstwa2, opis));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return interakcje;
        
        
    }
    public List<Leczy> selectLeczy() {
        List<Leczy> leczy = new LinkedList<Leczy>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Leczy ");
            
            int kod_lekarstwa, kod_choroby;
            String typowa_Dawka, jednostka_Miary, typowe_Dawkowanie, typowy_Okres;
        	
            while(result.next()) {
            	 //ResultSet result1 = stat.executeQuery("SELECT nazwa_lekarstwa FROM lekarstwa,leczy where leczy.kod_lekarstwa=lekarstwa.kod_lekarstwa");
            	kod_lekarstwa=result.getInt("kod_lekarstwa");
          
            	// ResultSet result2 = stat.executeQuery("SELECT nazwa_choroby FROM choroby,leczy where leczy.kod_choroby=choroby.kod_choroby");
            	kod_choroby=result.getInt("kod_choroby");    
            
            	 typowa_Dawka=result.getString("typowa_Dawka");
            	 jednostka_Miary=result.getString("jednostka_Miary");
            	 typowe_Dawkowanie=result.getString("typowe_Dawkowanie");
            	 typowy_Okres=result.getString("typowy_Okres");
             
            	 leczy.add(new Leczy(kod_lekarstwa, kod_choroby, typowa_Dawka, jednostka_Miary, typowe_Dawkowanie, typowy_Okres));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return leczy;
        
        
    }
    public List<Choroby> selectChoroby() {
        List<Choroby> choroby = new LinkedList<Choroby>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Choroby");
            
            int kod_Choroby;
            String nazwa_Choroby, objawy, leczenie;
        	
            while(result.next()) {
           
             kod_Choroby=result.getInt("kod_Choroby");
             nazwa_Choroby=result.getString("nazwa_Choroby");
             objawy=result.getString("objawy");
             leczenie=result.getString("leczenie");
             choroby.add(new Choroby(kod_Choroby, nazwa_Choroby, objawy, leczenie));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return choroby;
        
        
    }
    public List<Choroby> selectChorobaPoNazwie(String nazwa_Choroby) {
        List<Choroby> choroby = new LinkedList<Choroby>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM choroby where nazwa_Choroby like '%"+nazwa_Choroby+"%' group by nazwa_choroby"); 
            
            int kod_Choroby;
            String  objawy, leczenie;
        	
            while(result.next()) {
           
             kod_Choroby=result.getInt("kod_Choroby");
             nazwa_Choroby=result.getString("nazwa_Choroby");
             objawy=result.getString("objawy");
             leczenie=result.getString("leczenie");
             choroby.add(new Choroby(kod_Choroby, nazwa_Choroby, objawy, leczenie));
               }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return choroby;
        
        
    }
    
        
        
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }

	

	
}