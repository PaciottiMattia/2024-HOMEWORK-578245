package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	IO IO;
	
	public FabbricaDiComandiFisarmonica(IO io) {
		super();
		this.IO=io;
	}
	
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);	
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		if (nomeComando == null)
			comando = new ComandoNonValido(this.IO);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(this.IO);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(this.IO);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(this.IO);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.IO);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(this.IO);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(this.IO);
		else comando = new ComandoNonValido(this.IO);
		
		comando.setParametro(parametro);
		return comando;
		}
}
