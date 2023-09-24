package Herkeuring;

import java.util.Scanner;
//Op mijn werk hebben alle goederen een artikelnummer, maar het werd te
//uitgebreid om de database te laten aansluiten voor mij
public class Groente { 
	
	private String groente;
	
	public String getGroente() {
		return groente;
	}
	public void setGroente(String groente) {
		this.groente = groente;
	}
	public static Groente aanmakenGroente(Scanner scanner) { //groente wordt aangemaakt
		String groenteNaam = "";
		
		System.out.println("Welke groente ga je herkeuren? Type de naam van de groente en druk op enter.");
		do {
			groenteNaam = scanner.nextLine();
					} while(!(groenteNaam.length() > 0));
		Groente groente = new Groente();
		groente.setGroente(groenteNaam);
		return groente;
	}

}

