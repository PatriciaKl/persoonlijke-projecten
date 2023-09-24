package Herkeuring;

public class Resultaat {
	private Groente groente;
	private Vraag vraag;
	private Antwoord antwoord;
	//Hieronder worden de vraag, antwoord en groente opgehaald en gevuld
	public Vraag getVraag() {
		return vraag;
	}
	public void setVraag(Vraag vraag) {
		this.vraag = vraag;
	}
	public Antwoord getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(Antwoord antwoord) {
		this.antwoord = antwoord;
	}
	public Groente getGroente() {
		return groente;
	}
	public void setGroente(Groente groente) {
		this.groente = groente;
	}
	

}
