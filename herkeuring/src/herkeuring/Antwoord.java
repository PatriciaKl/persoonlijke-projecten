package Herkeuring;

public class Antwoord {
	private Integer antwoordNr; //Dit zijn de attributen
	private Integer vraagNr;
	private String antwoordTekst;
	private Double waarde;
	
	public Antwoord(Integer antwoordNr, String antwoordTekst, Double waarde) {
		this.setAntwoordNr(antwoordNr);
		this.setAntwoordTekst(antwoordTekst);
		this.setWaarde(waarde);
	}
	public Antwoord(Integer vraagNr, Integer antwoordNr, String antwoordTekst, Double waarde) {
		this.setVraagNr(vraagNr);
		this.setAntwoordNr(antwoordNr);
		this.setAntwoordTekst(antwoordTekst);
		this.setWaarde(waarde);
	}//Hieronder worden de waardes, antwoord en vraag opgehaald en gevuld
	public Double getWaarde() {
		return waarde;
	}
	public void setWaarde(Double waarde) {
		this.waarde = waarde;
	}
	public String getAntwoordTekst() {
		return antwoordTekst;
	}
	public void setAntwoordTekst(String antwoordTekst) {
		this.antwoordTekst = antwoordTekst;
	}
	public Integer getAntwoordNr() {
		return antwoordNr;
	}
	public void setAntwoordNr(Integer antwoordNr) {
		this.antwoordNr = antwoordNr;
	}
	public void afbeeldenAntwoord(Integer antwoordTeller) { //beeldt het antwoord af
		System.out.println(antwoordTeller + ". " + this.getAntwoordTekst());
	}
	public Integer getVraagNr() {
		return vraagNr;
	}
	public void setVraagNr(Integer VraagNr) {
		this.vraagNr = VraagNr;
	}

}
