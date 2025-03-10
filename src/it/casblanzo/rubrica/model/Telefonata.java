package it.casblanzo.rubrica.model;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.casblanzo.rubrica.exception.WrongMobileNumberException;

public class Telefonata {
    static String mobileRegex = "^3\\d{9}$";

	private String numero;
	private int durata;
	private int costo;

	public Telefonata(String numero, int durata, int costo) throws WrongMobileNumberException{
		Pattern pattern = Pattern.compile(Telefonata.mobileRegex);
        Matcher matcher = pattern.matcher(numero);
        if(!matcher.matches()) {
        	throw new WrongMobileNumberException();
        }
        this.costo = costo;
        this.durata = durata;
        this.numero= numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
	@Override
	public String toString() {
		return "numero: " + this.getNumero() 
		+ " costo:" + this.getCosto() + " durata:"+this.getDurata();
	}
}
