package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class ComandoPrendiTest {

	private Stanza stanza;
	private Attrezzo bastone;
	private Giocatore giocatore;
	private Borsa borsa;
	private Partita partita;
	private IOConsole IO;
	private ComandoPrendi comando;
	private Labirinto labirinto;
	
	
	@BeforeEach
	void setUp() {
		this.IO=new IOConsole();
		this.stanza=new Stanza("campus");
		this.bastone=new Attrezzo("bastone", 1);
		this.giocatore=new Giocatore();
		this.borsa=new Borsa();
		this.partita=new Partita();
		this.labirinto=new Labirinto();
		this.comando=new ComandoPrendi(this.IO);
		this.giocatore.setBorsa(borsa);
		this.partita.setGiocatore(giocatore);
		this.labirinto.setStanzaCorrente(stanza);
		this.partita.setLabirinto(labirinto);
		this.comando.setParametro("bastone");
		this.stanza.addAttrezzo(bastone);
	}
	
	
	@Test
	final void testGetNome() {
		assertEquals("prendi", this.comando.getNome());
	}
	
	@Test
	final void testGetParametro() {
		assertEquals("bastone", this.comando.getParametro());
	}
	
	@Test
	final void testEsegui() {
		this.comando.esegui(this.partita);
		assertNotNull(this.partita.getGiocatore().getBorsa().getAttrezzo("bastone"));
	}
	
	@Test
	final void testEseguiAttrezzoNonPresente() {
		this.comando.esegui(this.partita);
		assertNull(this.partita.getLabirinto().getStanzaCorrente().getAttrezzo("bastone"));
	}

	

}
