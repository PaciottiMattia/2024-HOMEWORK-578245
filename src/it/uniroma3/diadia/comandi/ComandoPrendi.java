package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nome="prendi";
	private String nomeAttrezzo;
	private IO IO;
	
	public ComandoPrendi(IO io) {
		super();
		this.IO=io;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		Borsa borsa=partita.getGiocatore().getBorsa();
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

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
