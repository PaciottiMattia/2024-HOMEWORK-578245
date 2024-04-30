package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private String nome="guarda";
	private IO IO;
	
	public ComandoGuarda(IO io) {
		super();
		this.IO=io;
	}
	
	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("Stanza corrente:"+ partita.getLabirinto().getStanzaCorrente().toString());
		IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		IO.mostraMessaggio("CFU rimanenti:"+ partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return null;
	}
	

}
