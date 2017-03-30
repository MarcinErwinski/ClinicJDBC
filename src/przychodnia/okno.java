package przychodnia;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Choroby;
import model.Interakcje;
import model.Leczy;
import model.Lekarstwa;
import model.Lekarz;
import model.Pacjent;
import model.Przepisane; 
import model.Wizyty;
import przychodnia.Przychodnia;


import javax.swing.JComboBox;


import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;



public class okno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					okno frame = new okno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void pacjent(boolean sort){
		Przychodnia b = new Przychodnia();
		List<Pacjent> pacjenci;
		if (sort){
			 pacjenci = b.selectPacjenci();
		}
		else{
		 pacjenci = b.selectPacjenciPoNazwisku(textField_1.getText());}
		
		String[] nazwyKolumn = new String[] {
				"Nr ubezpieczenia",
				"Imie",
				"Nazwisko",
				"Adres",
				"Telefon"
			};
			String[][] dane1 = new String[pacjenci.size()][5];
			
			int j = 0;
			for (Pacjent l : pacjenci) {
				dane1[j][0] = Integer.toString(l.getNr_Ubezpieczenia());
				dane1[j][1] = l.getImie();
				dane1[j][2] = l.getNazwisko();
				dane1[j][3] = l.getAdres();	
				dane1[j][4] = l.getTelefon();				
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void lekarz (boolean sort){
		Przychodnia b = new Przychodnia();
		List<Lekarz> lekarze;
		if(sort){
		lekarze = b.selectLekarze();}
		else
		{lekarze = b.selectLekarzePoNazwisku(textField_1.getText());}
			
			
		
		String[] nazwyKolumn = new String[] {
				"Nr Lekarza",
				"Imie",
				"Nazwisko",
				"Telefon"
			};
			String[][] dane1 = new String[lekarze.size()][4];
			
			int j = 0;
			for (Lekarz l : lekarze) {
				dane1[j][0] = Integer.toString(l.getNr_Lekarza());
				dane1[j][1] = l.getImie();
				dane1[j][2] = l.getNazwisko();
				dane1[j][3] = l.getTelefon();				
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
			 
	}
	
	public void wizyty(){
		Przychodnia b = new Przychodnia();
		
		List<Wizyty> wizyty = b.selectWizyty();

		String[] nazwyKolumn = new String[] {
				"Nr wizyty",
				"Imie Pacjenta",
				"Nazwisko Pacjenta",
				"Imie lekarza",
				"Nazwisko lekarza",
				"data wizyty",
				"objawy",
				"notatki"
			};
			String[][] dane1 = new String[wizyty.size()][9];
			
			int j = 0;
			for (Wizyty w : wizyty) {
				dane1[j][0] = Integer.toString(w.getNr_Wizyty());
				dane1[j][3] = w.getImie_Lekarza();
				dane1[j][4] = w.getNazwisko_Lekarza();
				dane1[j][1] = w.getImie_Pacjenta();		
				dane1[j][2] = w.getNazwisko_Pacjenta();	
				dane1[j][5] = w.getData_Wizyty();
				dane1[j][6] = w.getObjawy();	
				dane1[j][7] = w.getNotatki();	
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void przepisane(){
		Przychodnia b = new Przychodnia();
		List<Przepisane> przepisane = b.selectPrzepisane();
		
		String[] nazwyKolumn = new String[] {
				"Nr wizyty",
				"nazwa_lekarstwa",
				"dawka",
				"dwakowanie",
				"jednostka",
				"okres"
			};
			String[][] dane1 = new String[przepisane.size()][6];
			
			int j = 0;
			for (Przepisane l : przepisane) {
				dane1[j][0] = Integer.toString(l.getNr_Wizyty());
				dane1[j][1] = l.getNazwa_Lekarstwa();
				dane1[j][2] = l.getDawka();
				dane1[j][3] = l.getDawkowanie();	
				dane1[j][4] = l.getJednostka_Miary();
				dane1[j][5] = l.getOkres();
				
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void lekarstwa(boolean sort){
		Przychodnia b = new Przychodnia();
		List<Lekarstwa> lekarstwa ;
		if(sort){
			 lekarstwa= b.selectLekarstwa();
		}
		else{ lekarstwa= b.selectLekarstwaPoNazwie(textField.getText());}
		
		String[] nazwyKolumn = new String[] {
				"kod lekarstwa",
				"nazwa lekarstwa",
				"przeciwskazania",
				"sklad",
				"skutki uboczne"
			};
			String[][] dane1 = new String[lekarstwa.size()][5];
			
			int j = 0;
			for (Lekarstwa l : lekarstwa) {
				dane1[j][0] = Integer.toString(l.getKod_Lekarstwa());
				dane1[j][1] = l.getNazwa_Lekarstwa();
				dane1[j][2] = l.getPrzeciwskazania();
				dane1[j][3] = l.getSklad();	
				dane1[j][4] = l.getSkutki_Uboczne();				
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void leczy(){
		Przychodnia b = new Przychodnia();
		List<Leczy> leczy = b.selectLeczy();
		
		String[] nazwyKolumn = new String[] {
				"kod choroby",
				"kod lekarstwa",
				"Typowa dawka",
				"Typowe dawkowanie",
				"Jednostka miary",
				"Typowy okres"
			};
			String[][] dane1 = new String[leczy.size()][6];
			
			int j = 0;
			for (Leczy l : leczy) {
				dane1[j][0] = Integer.toString(l.getKod_choroby());
				dane1[j][1] = Integer.toString(l.getKod_lekarstwa());
				dane1[j][2] = l.getTypowa_Dawka();
				dane1[j][3] = l.getTypowe_Dawkowanie();	
				dane1[j][4] = l.getJednostka_Miary();	
				dane1[j][5] = l.getTypowy_Okres();	
				
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void choroby(boolean sort){
		Przychodnia b = new Przychodnia();
		List<Choroby> choroby;
		if(sort){
			choroby= b.selectChoroby();
		}
		else{choroby= b.selectChorobaPoNazwie( textField.getText());}
		
		String[] nazwyKolumn = new String[] {
				"Kod",
				"Nazwa" ,
				"Lecznie",
				"Objawy"
		
			};
			String[][] dane1 = new String[choroby.size()][4];
			
			int j = 0;
			for (Choroby l : choroby) {
				dane1[j][0] = Integer.toString(l.getKod_Choroby());
				dane1[j][1] = l.getNazwa_Choroby();
				dane1[j][2] = l.getLeczenie();
				dane1[j][3] = l.getObjawy();	
							
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	public void interakcje(){
		Przychodnia b = new Przychodnia();
		List<Interakcje> interakcje = b.selectInterakcje();
		
		String[] nazwyKolumn = new String[] {
				"Kod lekarstwa 1",
				"Kod lekarstwa 2",
				"opis"
				
			};
			String[][] dane1 = new String[interakcje.size()][3];
			
			int j = 0;
			for (Interakcje l :interakcje) {
				dane1[j][0] = Integer.toString(l.getKod_Lekarstwa1());
				dane1[j][1] = Integer.toString(l.getKod_Lekarstwa2());
				dane1[j][2] = l.getOpis();
							
				j++;
			}
			
			JTable table = new JTable(dane1, nazwyKolumn);
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			 b.closeConnection();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public okno() {
		
		
		scrollPane = new JScrollPane();

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		JButton btnNewButton_1 = new JButton("Wyszukaj");
		JButton btnNewButton = new JButton("Dodaj");
		JButton btnNewButton_2 = new JButton("Usu\u0144");
		btnNewButton.setVisible(false);
		btnNewButton_2.setVisible(false);
		JComboBox<?> comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				String wybor = comboBox.getSelectedItem().toString();
				
				if (wybor.equals("Lekarze")){
				
			        lekarz(true);
			        textField.setVisible(true);
			        textField.setText("Imie");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Nazwisko");
			   
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Telefon");
			        
			        textField_3.setVisible(false);
			        
			        
			        textField_4.setVisible(false);
			        textField_5.setVisible(false);
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(true);
			        btnNewButton_2.setVisible(true);
			        btnNewButton_1.setText("Wyszukaj po nazwisku");
				}    
			  
			    if (wybor.equals("Wizyty")){
						
						wizyty();
				        
				        textField.setVisible(true);
				        textField.setText("Imie pacjenta");
				        
				        
				        textField_1.setVisible(true);
				        textField_1.setText("Nazwisko pacjenta");
				       
				        
				        textField_2.setVisible(true);
				        textField_2.setText("Imie lekarza");
				        
				        
				        textField_3.setVisible(true);
				        textField_3.setText("Nazwisko lekarza");
				       
				    
				        textField_4.setVisible(true); 
				        textField_4.setText("Data wizyty");
				        
				        
				        textField_5.setVisible(true);
				        textField_5.setText("Objawy");
				        
				        textField_6.setVisible(true);
				        textField_6.setText("Notatki");
				        
				        textField_7.setVisible(true);
				        textField_7.setText("Numer Wizyty");
				        textField_8.setVisible(false);
				        
				        btnNewButton.setVisible(true);
				        btnNewButton_1.setVisible(false);
				        btnNewButton_2.setVisible(true);
			    }
			        
			      
				
				
				if (wybor.equals("Pacjenci")){
					
					
					
					pacjent(true);
			       
			        textField.setVisible(true);
			        textField.setText("Imie");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Nazwisko");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Adres");
			        
			        textField_3.setVisible(true);
			        textField_3.setText("Telefon");
			        
			        textField_4.setVisible(false);
			       
			        
			        textField_5.setVisible(false);
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(true);
			        btnNewButton_2.setVisible(true);
			        btnNewButton_1.setText("Wyszukaj po nazwisku");
					}
				
				if (wybor.equals("Przepisane")){
				
					przepisane();
			        textField.setVisible(true);
			        textField.setText("Numer wizyty");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Nazwa lekarstwa");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Dawka");
			        
			        textField_3.setVisible(true);
			        textField_3.setText("Jednostka miary");
			        
			        textField_4.setVisible(true);
			        textField_4.setText("Dawkowanie");
			        
			        textField_5.setVisible(true);
			        textField_5.setText("Okres");
			        
			        textField_6.setVisible(false);
			        
			        
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			       
			        
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(false);
			        btnNewButton_2.setVisible(true);
					}
				
				if (wybor.equals("Lekarstwa")){
					
					lekarstwa(true);
			        
			        textField.setVisible(true);
			        textField.setText("Nazwa lekarstwa");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Sklad");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Przeciwskazania");
			        
			        textField_3.setVisible(true);
			        textField_3.setText("Skutki uboczne");
			        
			        textField_4.setVisible(false);
			        
			        
			        textField_5.setVisible(false);
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(true);
			        btnNewButton_1.setText("Wyszukaj po nazwie");
			        btnNewButton_2.setVisible(true);
				}    
				
				if (wybor.equals("Leczy")){
					
					leczy();
			        
			        textField.setVisible(true);
			        textField.setText("Kod lekarstwa");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Kod choroby");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Typowa dawka");
			        
			        textField_3.setVisible(true);
			        textField_3.setText("Jednostka miary");
			        
			        textField_4.setVisible(true);
			        textField_4.setText("Typowe dawkowanie");
			        
			        textField_5.setVisible(true);
			        textField_5.setText("Typowe okres");
			        
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(false);
			        btnNewButton_2.setVisible(true);
				}  
				
				if (wybor.equals("Choroby")){
					
					choroby(true);
			        
			        textField.setVisible(true);
			        textField.setText("Nazwa choroby");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Objawy");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Leczenie");
			        
			        textField_3.setVisible(false);
			      
			        
			        textField_4.setVisible(false);
			        textField_5.setVisible(false);
			        
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_1.setVisible(true);
			        btnNewButton_1.setText("Wyszukaj po nazwie");
			        btnNewButton_2.setVisible(true);
				}  
				if (wybor.equals("Interakcje")){
					interakcje();
			        
			        textField.setVisible(true);
			        textField.setText("Kod lekarstwa 1");
			        
			        textField_1.setVisible(true);
			        textField_1.setText("Kod lekarstwa 2");
			        
			        textField_2.setVisible(true);
			        textField_2.setText("Opis");
			        
			        textField_3.setVisible(false);
			        textField_4.setVisible(false);
			        textField_5.setVisible(false);
			        
			        textField_6.setVisible(false);
			        textField_7.setVisible(false);
			        textField_8.setVisible(false);
			        
			        btnNewButton.setVisible(true);
			        btnNewButton_2.setVisible(true);
			        btnNewButton_1.setVisible(false);
				}  
			
			}
					
	
			
		});
		
		String nazwaKolumn []= {"","Lekarze","Pacjenci","Wizyty","Przepisane","Lekarstwa","Leczy","Choroby","Interakcje",};
		comboBox.setModel(new DefaultComboBoxModel(nazwaKolumn));
		comboBox.actionPerformed(null);
		
		comboBox.setToolTipText("1");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.LEADING, 0, 424, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
		);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String wybor = comboBox.getSelectedItem().toString();
				
				if (wybor.equals("Lekarze")){
					
					Przychodnia b = new Przychodnia();
					b.insertLekarz(textField.getText() , textField_1.getText(),textField_2.getText());
					

					lekarz(true);
					}
				if (wybor.equals("Pacjenci")){
					
					Przychodnia b = new Przychodnia();
					b.insertPacjent(textField.getText() , textField_1.getText(),textField_2.getText(),textField_3.getText());
					pacjent(true);
				}
			      if (wybor.equals("Wizyty")){
						
						Przychodnia b = new Przychodnia();
						b.insertWizyty(textField.getText() , textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText(),textField_6.getText());
						
						wizyty();
						b.closeConnection();
						
						
			      }
			      if (wybor.equals("Przepisane")){
						
						Przychodnia b = new Przychodnia();
						b.insertPrzepisane(Integer.valueOf(textField.getText()) , textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText());
						
						przepisane();
						b.closeConnection();
			      }
			      if (wybor.equals("Lekarstwa")){
						
						Przychodnia b = new Przychodnia();
						b.insertLekarstwo(textField.getText() , textField_1.getText(),textField_2.getText(),textField_3.getText());
						lekarstwa(true);
			      		}
			      if (wybor.equals("Leczy")){
						
						Przychodnia b = new Przychodnia();
						b.insertLeczy(Integer.valueOf(textField.getText()) , Integer.valueOf(textField_1.getText()),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText());
						leczy();
			      		}
			
			 if (wybor.equals("Choroby")){
					
					Przychodnia b = new Przychodnia();
					b.insertChoroby(textField.getText(), textField_1.getText(),textField_2.getText());
					
					choroby(true);
		      		}
			 if (wybor.equals("Interakcje")){
					
					Przychodnia b = new Przychodnia();
					b.insertInterakcje(Integer.valueOf(textField.getText()) , Integer.valueOf(textField_1.getText()),textField_2.getText());
					interakcje();
		      		}
			}
		});
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
			}
		});
		textField.setColumns(10);
		textField.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
			}
		});
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_4.setText("");
			}
		});
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_5.setText("");
			}
		});
		textField_5.setColumns(10);
		textField_5.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_6.setText("");
			}
		});
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_7.setText("");
			}
		});
		textField_7.setColumns(10);
		textField_7.setVisible(false);
		
		textField_8 = new JTextField();
		textField_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_8.setText("");
			}
		});
		textField_8.setColumns(10);
		textField_8.setVisible(false);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wybor = comboBox.getSelectedItem().toString();
				
				if (wybor.equals("Lekarze")){
					
					Przychodnia b = new Przychodnia();
					b.deleteLekarz(textField.getText() , textField_1.getText(),textField_2.getText());

					lekarz(true);
					}
				if (wybor.equals("Pacjenci")){
					
					Przychodnia b = new Przychodnia();
					b.deletePacjent(textField.getText() , textField_1.getText(),textField_2.getText(),textField_3.getText());
					pacjent(true);
				}
			
			      if (wybor.equals("Wizyty")){
						
						Przychodnia b = new Przychodnia();
						b.deleteWizyty(textField_7.getText());
						
						wizyty();
						b.closeConnection();
			      
			      }
			      
			      if (wybor.equals("Przepisane")){
						Przychodnia b = new Przychodnia();
						b.deletePrzepisane(Integer.valueOf(textField.getText()) , textField_1.getText());
						
						przepisane();
						b.closeConnection();
			      }
			       
			      if (wybor.equals("Lekarstwa")){
						
						Przychodnia b = new Przychodnia();
						b.deleteLekarstwo(textField.getText() , textField_1.getText(),textField_2.getText(),textField_3.getText());
						lekarstwa(true);
			      		}
			      
			      if (wybor.equals("Leczy")){
						
						Przychodnia b = new Przychodnia();
						b.deleteLeczy(Integer.valueOf(textField.getText()) , Integer.valueOf(textField_1.getText()),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText());
						leczy();
			      		}
			
			 if (wybor.equals("Choroby")){
					
					Przychodnia b = new Przychodnia();
					b.deleteChoroby(textField.getText(), textField_1.getText(),textField_2.getText());
					
					choroby(true);
		      		}
			 if (wybor.equals("Interakcje")){
					
					Przychodnia b = new Przychodnia();
					b.deleteInterakcje(Integer.valueOf(textField.getText()) , Integer.valueOf(textField_1.getText()),textField_2.getText());
					interakcje();
		      		}
			
			}
		});
		
		
		
	
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
									.addComponent(textField_3)
									.addComponent(textField_6))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addComponent(textField_4, Alignment.TRAILING)
									.addComponent(textField_7))
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(75)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		btnNewButton_1.setVisible(false);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String wybor = comboBox.getSelectedItem().toString();
				
				if (wybor.equals("Pacjenci"))	
					pacjent(false);
				
				if (wybor.equals("Lekarstwa"))
					lekarstwa(false);
	
				if (wybor.equals("Lekarze"))
					lekarz(false);
			
				if (wybor.equals("Choroby"))
					choroby(false);
			
			
			}
		});
		
		
	}
}
