package Herkeuring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Herkeuring {
	
	private String groente;
	private List<Groente> groenten;
	private List<Vraag> vragen = new ArrayList<Vraag>();
	
	public static void main(String[] args) {
		Herkeuring herkeuring = new Herkeuring();
		//Ik wilde de lijst niet te uitgebreid maken, het moet simpel zijn
		herkeuring.setGroente("Vragenlijst herkeuring");
		//vragen worden toegevoegd
		Vraag vraag1 = new Vraag(1, "Is de temperatuur tussen de 1 en 6 graden?");
		vraag1.toevoegenAntwoord(new Antwoord(1, "Ja", 6.0));
		vraag1.toevoegenAntwoord(new Antwoord(2, "Nee", 1.0));
		
		herkeuring.addVraag(vraag1);
		
		Vraag vraag2 = new Vraag(2, "Hoe ziet de groente er in het algemeen uit?");
		vraag2.toevoegenAntwoord(new Antwoord (1, "Slecht", 1.0));
		vraag2.toevoegenAntwoord(new Antwoord (2, "Matig", 6.0));
		vraag2.toevoegenAntwoord(new Antwoord (3, "Redelijk", 7.0));
		vraag2.toevoegenAntwoord(new Antwoord (4, "Goed", 8.0));
		vraag2.toevoegenAntwoord(new Antwoord (5, "Perfect", 10.0));
		
		herkeuring.addVraag(vraag2);
		
		Vraag vraag3 = new Vraag(3, "Is er ongedierte te zien?");
		vraag3.toevoegenAntwoord(new Antwoord (1, "Ja", 1.0));
		vraag3.toevoegenAntwoord(new Antwoord (2, "Nee", 6.0));
		
		herkeuring.addVraag(vraag3);
		
		Vraag vraag4 = new Vraag(4, "Is de groente vrij van ziekte?");
		vraag4.toevoegenAntwoord(new Antwoord(1, "Ja", 6.0));
		vraag4.toevoegenAntwoord(new Antwoord(2, "Nee", 1.0));
		
		herkeuring.addVraag(vraag4);
		
		herkeuring.startHerkeuring();
	}
	//Andere klassen worden opgehaald en gevuld
	public String getGroente() {
	return this.groente;
	}
	public void setGroente(String groente) {
		this.groente = groente;
	}
	public List<Vraag> getVragen() {
		return this.vragen;
	}
	public void setVragen(List<Vraag> vragen) {
		this.vragen = vragen;
	}
	public List<Groente> getGroenten() {
		return this.groenten;
	}
	public void setGroente(List<Groente> groenten) {
		this.groenten = groenten;
	}
	public void addGroente( Groente groente) {
		if(this.groenten == null) {
			this.groenten = new ArrayList<Groente>();
		}
		this.groenten.add(groente);
	}
	public void addVraag(Vraag vraag) {
		if(this.vragen == null) {
			this.vragen = new ArrayList<Vraag>();
		}
		this.vragen.add(vraag);
	}
	public void getResultaten(List<Resultaat> resultaten) {
		//Hier wordt het resultaat berekend
		Double SomVanWaardes = 0.0;
		Integer AantalAntwoorden = resultaten.size();
		Double score;
		
		for(Resultaat resultaat : resultaten) {
			SomVanWaardes = SomVanWaardes + resultaat.getAntwoord().getWaarde();
		}
		
		score = (SomVanWaardes/AantalAntwoorden);
		
		score = (Math.round(score * 100) / 100.0);
		//De beoordeling wordt weergegeven en het antwoord wat erbij hoort
		System.out.println("\n--------------------------------------------");
		System.out.println("De kwaliteitsvragen zijn beantwoord");
		System.out.println("==============================================\n");
		System.out.println("U heeft de groente beoordeeld met een gemiddelde van: " + score);
		
		if(score>= 6.0) {
			System.out.println( "De groente is positief beoordeeld en mag verwerkt worden.");
		}
		else {
			System.out.println( "De groente is te slecht om te verwerken en moet afgekeurd worden.");
		}
	}
	public void startHerkeuring() { //Hier wordt de scanner aangeroepen
		Scanner scanner = new Scanner(System.in);
		List<Vraag> alleVragen = this.getVragen();
		if(alleVragen != null) {
			System.out.println("Beoordeling van " + this.getGroente() + "\n");
			
			Groente groente = Groente.aanmakenGroente(scanner);
			this.addGroente(groente);
			
			System.out.println("\nBeoordeling " + groente.getGroente() + ", druk op een toest om te beginnen.\n");
			try { System.in.read();
		}
			catch(Exception e) {
				
			}
			List<Resultaat> resultaten = new ArrayList<Resultaat>();
			
			for(Vraag vraag: alleVragen) {
				
				Resultaat resultaat = new Resultaat();
				resultaat.setVraag(vraag);
				resultaat.setAntwoord(vraag.stelVraag(scanner));
				resultaat.setGroente(groente);
				resultaten.add(resultaat);
			}
			this.getResultaten(resultaten);
	}
		else {
			System.out.println("Deze vragenlijst bevat geen vragen.");
		}
		scanner.close();
}
}
