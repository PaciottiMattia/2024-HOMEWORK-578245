package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private String nome="Non valido";
	private IO IO;
	
	public ComandoNonValido(IO io) {
		this.IO=io;
	}
	@Override
	public void esegui(Partita partita) {
		this.IO.mostraMessaggio("Il comando inserito non è valido");
		
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
