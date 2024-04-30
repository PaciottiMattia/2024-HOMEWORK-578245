package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita(){
		creaLabirinto();
		this.finita = false;
		this.giocatore=new Giocatore();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaLabirinto() {
    	this.labirinto=new Labirinto();
    	this.labirinto.init();
    }
    
    public Labirinto getLabirinto() {
    	return this.labirinto;
    }
    
    public void setLabirinto(Labirinto l) {
    	this.labirinto=l;
    }

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
}
