package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private String nome="posa";
	private String nomeAttrezzo;
	private IO IO;
	
	public ComandoPosa(IO io) {
		super();
		this.IO=io;
	}
	
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		Borsa borsa=partita.getGiocatore().getBorsa();
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

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getparametro() {
		return this.nomeAttrezzo;
	}

}
