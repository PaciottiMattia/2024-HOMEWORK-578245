package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};

	private Partita partita;
	
	private IO IO;

	public DiaDia(IO io) {
		this.IO=io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = IO.leggiRiga();
		while (processaIstruzione(istruzione)== false);
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	*/
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(IO);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta()) {
			IO.mostraMessaggio("Hai vinto!");
			return true;
		}
		else if (this.partita.isFinita()) {
			if(this.partita.getGiocatore().getCfu()!=0) {
				return true;
			}
			else {
				IO.mostraMessaggio("Hai esaurito i CFU...");
				return true;
			}
		}
		else {
			return false;
		}
		}

	
	
	public static void main(String[] argc) {
		IO IO=new IOConsole();
		DiaDia gioco = new DiaDia(IO);
		gioco.gioca();
	}
}