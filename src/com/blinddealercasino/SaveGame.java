package com.blinddealercasino;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Klasa odpowiadaj¹ca za serializacjê. Obiekt tej klasy jest serializowany przy zamkniêciu programu,
 * odpakowywany zaœ przy uruchomieniu. 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 *   
 **/

public class SaveGame implements Serializable {


	private static final long serialVersionUID = 8986260760650156085L;
	private int wartoscSalda;
	

	
	public void setWartoscSaldaDoZapisu(int wartosc){
		wartoscSalda = wartosc;
	}
		
	public int getWartoscSaldaDoOdczytu(){
		return wartoscSalda;
	}
	
	public void zapiszGre(int wartosc){
		wartoscSalda = wartosc;
	
		try{
			FileOutputStream fs = new FileOutputStream("SaveGame.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public int wczytajGre(){
		try{	
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SaveGame.ser"));
			SaveGame save = new SaveGame(); 
			save = (SaveGame) is.readObject();
			wartoscSalda = save.getWartoscSaldaDoOdczytu();			
			is.close();
			
		}catch (Exception ex) {
			wartoscSalda = 0;
		}
		
		return wartoscSalda;
	}
	
	
}
