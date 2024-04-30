package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Classe IOConsole che ha il compito di gestire l'interazione IO con l'utente tramite tastiera e schermo
 * 
 * @author Paciotti Mattia
 * @see DiaDia
 * @version 1
 * 
 */


public class IOConsole implements IO {
	
	
	/**
	 * 
	 * @param msg il parametro da stampare su schermo all'utente
	 */
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	/**
	 * 
	 * @return riga scansionata da tastiera
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	
}