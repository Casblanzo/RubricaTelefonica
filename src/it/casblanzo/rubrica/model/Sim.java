package it.casblanzo.rubrica.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.casblanzo.rubrica.exception.WrongMobileNumberException;

public class Sim {

	ArrayList<Telefonata> telefonateFatte = new ArrayList<>();
	ArrayList<Telefonata> telefonateRicevute = new ArrayList<>();
	
	Map<String, Integer> telefonateFatteMap= new HashMap<>();
	Map<String, Integer> telefonateRicevuteMap= new HashMap<>();


	public static final String TIPO_FATTA = "fatta";
	public static final String TIPO_RICEVUTA = "ricevuta";

	public static final String operatore = "Vodafone";

	public void aggiungiTelefonata(String numero, int durata, int costo, String tipo) throws WrongMobileNumberException {
		Telefonata telefonata = new Telefonata(numero, durata, costo);
		if (tipo.equals(TIPO_FATTA)) {
			telefonateFatte.add(telefonata);
			if(telefonateFatteMap.containsKey(telefonata.getNumero())) {
				telefonateFatteMap.put(telefonata.getNumero(), 
						telefonateFatteMap.get(telefonata.getNumero()) + 1);
			}
			else {
				telefonateFatteMap.put(telefonata.getNumero(), 1);
			}
		} else {
			telefonateRicevute.add(telefonata);
		}
	}

	public void stampaTelefonateFatte() {
		for(Telefonata telefonata : telefonateFatte) {
			System.out.println(telefonata);
		}
	}

	public void stampaTelefonateRicevute() {
		for(Telefonata telefonata : telefonateRicevute) {
			System.out.println(telefonata);
		}
	}

	public static String getOperatore() {
		return operatore;
	}
}
