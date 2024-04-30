package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private String nome = "vai";
	private IO io;
		
		public ComandoVai(IO io) {
			super();
			this.io = io;
		}
	

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
				System.out.println("Dove vuoi andare?\n Devi specificare una direzione");
				return;
			}
		prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(this.direzione);
			if (prossimaStanza == null) {
				this.io.mostraMessaggio("Direzione inesistente");
				return;
			}
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(--cfu);
			
			
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio("CFU disponibili: "+ partita.getGiocatore().getCfu());
		}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
		
	}
}

