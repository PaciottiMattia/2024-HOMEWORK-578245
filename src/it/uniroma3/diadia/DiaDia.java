package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

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
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	
	public static IOConsole IO;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String[] istruzione; 
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = IO.leggiRiga().split(" ");
		while (processaIstruzione(istruzione)== false);
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String[] istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome() == null) {
			IO.mostraMessaggio("non hai inserito un valore corretto!\n");
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			IO.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IO.mostraMessaggio("Hai vinto!");
			return true;
		} 
		
		else if(this.partita.isFinita()) {
			IO.mostraMessaggio("Hai finito i cfu");
			return true;
		}
		
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		int numeroComandi = elencoComandi.length;
		for(int i=0; i< numeroComandi; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
		IO.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			String[] direzione2;
			IO.mostraMessaggio("Dove vuoi andare?");
			direzione2= IO.leggiRiga().split(" ");
			direzione=direzione2[0];
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		
		IO.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		IO.mostraMessaggio("CFU disponibili: "+ this.partita.getGiocatore().getCfu());
	}
	
	
	public void posa(String nomeAttrezzo) {
		Stanza stanzaCorrente=this.partita.getLabirinto().getStanzaCorrente();
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		if(borsa.hasAttrezzo(nomeAttrezzo)==true) {
			Attrezzo attrezzoPosare= borsa.getAttrezzo(nomeAttrezzo);
			if(stanzaCorrente.addAttrezzo(attrezzoPosare)) {
				IO.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato posato nella stanza "+stanzaCorrente);
				borsa.removeAttrezzo(nomeAttrezzo);
			}
			else {
				IO.mostraMessaggio("Ci sono troppi attrezzi nella stanza");
			}
		}
		else {
			IO.mostraMessaggio("L'attrezzo non è presente nella borsa");
		}
	}
	
	
	public void prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente=this.partita.getLabirinto().getStanzaCorrente();
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPrendere=stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if(borsa.addAttrezzo(attrezzoPrendere)==true) {
				IO.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato preso dalla stanza "+stanzaCorrente.getNome());
				stanzaCorrente.removeAttrezzo(attrezzoPrendere);
			}
			else {
				IO.mostraMessaggio("La borsa è piena");
			}
		}
		else {
			IO.mostraMessaggio("L'oggetto non è presente nella stanza");
		}
		
	}
	
	

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia.IO=new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}