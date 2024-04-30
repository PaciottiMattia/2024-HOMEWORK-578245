package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};
	private String nome="aiuto";
	private IO io;
	
	
	public ComandoAiuto(IO io) {
		super();
		this.io=io;
	}
	
	@Override
	public void esegui(Partita partita) {
		int numeroComandi = elencoComandi.length;
		for(int i=0; i< numeroComandi; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
		
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
