package Herkeuring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vraag {
	private Integer vraagNr;
	private String vraagTekst;
	private List<Antwoord> antwoorden;
	
	public Vraag(Integer vraagNr, String vraagTekst) {
		this.setVraagNr(vraagNr);
		this.setVraagTekst(vraagTekst);
	}
	public String getVraagTekst() { //Ophalen van de inhoud van het object
		return this.vraagTekst;
	}
	public void setVraagTekst(String vraagTekst) { //opslaan van het object
		this.vraagTekst = vraagTekst;
	}
	public Integer getVraagNr() { 
		return vraagNr;
	}
	public void setVraagNr(Integer vraagNr) {
		this.vraagNr = vraagNr;
	}
	public List<Antwoord> getAntwoorden(){
		return this.antwoorden;
	}
	public Antwoord getAntwoordViaNr(Integer antwoordNr) {
		for(Antwoord antwoord : antwoorden) {
			if(antwoord.getAntwoordNr().equals(antwoordNr)) {
				return antwoord;
			}
		}
		return null;
	}
	public void toevoegenAntwoord(Antwoord antwoord) {
		//Voegt object toe aan Antwoord
		if(this.antwoorden == null) {
			this.antwoorden = new ArrayList<Antwoord>();
		}
		if(antwoord.getVraagNr() == null) {
			antwoord.setVraagNr(this.vraagNr);
		}
		this.antwoorden.add(antwoord);
	}
	public Antwoord stelVraag(Scanner scanner) { //Stelt de vraag en geeft deze terug
		this.afbeeldenVraag();
		Integer gegevenAntwoord = this.getGroenteAntwoord(scanner);
		return getAntwoordViaNr(gegevenAntwoord);
	}
	private void afbeeldenVraag() { //beeld de vragen af met mogelijke antwoorden
		System.out.println("\n------------------------------------");
		System.out.println(this.getVraagTekst() + "\n");
		
		int count = 0;
		for(Antwoord antwoord : this.getAntwoorden()) {
			count++;
			antwoord.afbeeldenAntwoord(count);
		}
		System.out.println("\nWat is je oordeel: ");
	}
	private Integer getGroenteAntwoord(Scanner scanner) { //als het niet juist is wat de keurmeester invoert
		int input = 0;
		
		do {
			while(!scanner.hasNextInt()) {
				String newInput = scanner.next();
				System.out.print(newInput + "Dit antwoord is niet geldig, vul een getal in wat aangegeven staat bij de antwoorden.");
			}
			input = scanner.nextInt();
			
			if(!this.isAntwoordGeldig(input)) {
				System.out.print("Dit antwoord is niet geldig, vul een getal in wat aangegeven staat bij de antwoorden.");
			}
		
		}
		while(!this.isAntwoordGeldig(input));//controleren of het antwoord voldoet
		return input;
	}
	private boolean isAntwoordGeldig(int input) {
		int vraagTeller = this.antwoorden.size();
		if(0 < input && input <= vraagTeller) {
			return true;
		}
		return false;
	}
	
}
