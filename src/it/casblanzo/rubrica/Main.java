package it.casblanzo.rubrica;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.casblanzo.rubrica.exception.WrongMobileNumberException;
import it.casblanzo.rubrica.model.Sim;

/*Creare una classe Telefonata che memorizzi i seguenti dati:
 * numero
 * durata
 * costo
 * 
 * Creare una Classe Sim con i seguenti dati:
 * numero
 * importo
 * elenco ultime 10 telefonate fatte
 * elenco ultime 10 telefonate ricevute
 * 
 * aggiungere i seguenti metodi:
 * aggiungi telefonata fatta
 * aggiungi telefonata ricevuta
 * costo totale chiamate
 * durata totale chiamate
 */

public class Main {


	public void telefonata(int iTelefonata, int tentativiMax, int tentativi, Scanner tastiera, Sim sim, String tipo) {
		System.out.println("inserisci numero " + tipo + " " + iTelefonata + ": ");
		String numeroT = tastiera.next();
		System.out.println("inserisci costo " + tipo + " " + iTelefonata + ": ");
		int costoT = tastiera.nextInt();
		System.out.println("inserisci durata " + tipo + " " + iTelefonata + ": ");
		int durata = tastiera.nextInt();
		try {
			sim.aggiungiTelefonata(numeroT, durata, costoT, tipo);
		} catch (WrongMobileNumberException e) {
			System.out.println("Numero sbagliato, ripetere");
			tentativi++;
			if(tentativi>tentativiMax) {
				System.out.println("hai raggiunto il numero massimo di tentativi");
				return;
			}
			telefonata(iTelefonata, tentativiMax, tentativi, tastiera, sim, tipo);
		}
	}	

	public static void main(String[] args) {
		Main main = new Main();
		Sim s = new Sim();

		try(Scanner tastiera = new Scanner(System.in)){
			// aggiungi telefonate fatte
			int tentativiMax = 3;
			int tentativiIn = 1;
			for (int i = 1; i <= 3; i++) {
				main.telefonata(i, tentativiMax, tentativiIn, tastiera, s, Sim.TIPO_FATTA);
			}
			// aggiungi telefonate ricevute
			int tentativiOut = 1;
			for (int i = 1; i <= 3; i++) {
				main.telefonata(i, tentativiMax, tentativiOut, tastiera, s, Sim.TIPO_RICEVUTA);
			}
		}
		System.out.println("TELEFONATE FATTE:");
		s.stampaTelefonateFatte();
		System.out.println("TELEFONATE RICEVUTE:");
		s.stampaTelefonateRicevute();

		
	}

	//  usare List non Array_FATTO
	//  utilizzare regex per validare il numero in ingresso
	//  raggruppare le telefonate provenienti e fatte da e verso gli stessi numeri
	// numeri (mappe)
	// TODO stampare la mappa al posto della lista
	// TODO oltre a contare le occorrenze, sommare i costi totali e le durate totali per numero
	// TODO non limitare il numero di telefonate da inserire
	// TODO stabilire un codice di uscita dal programma

	// TODO git

}
