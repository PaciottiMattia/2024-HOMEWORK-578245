package it.uniroma3.diadia;


/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;
    private String parametro;

    public Comando(String[] istruzione) {
		int numeroParole = istruzione.length;
		
		if(numeroParole > 0 && numeroParole <= 2) {  // i comandi devono avere una o due parole.
			if(numeroParole == 1)
				this.setNome(istruzione, numeroParole - 1);
		}
		if (numeroParole == 2) {
			this.setNome(istruzione, numeroParole - 2);
			this.setParametro(istruzione, numeroParole - 1);
		}
    }
    
    public void setNome(String[] istruzioni, int indice) {
		this.nome = istruzioni[indice];
	}
		
	public void setParametro(String[] istruzioni, int indice) {
		this.parametro = istruzioni[indice];
	}

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}