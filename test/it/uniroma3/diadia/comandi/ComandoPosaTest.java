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

class ComandoPosaTest {
	private Stanza stanza;
	private Attrezzo bastone;
	private Giocatore giocatore;
	private Borsa borsa;
	private Partita partita;
	private IOConsole IO;
	private ComandoPosa comando;
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
		this.comando=new ComandoPosa(this.IO);
		this.giocatore.setBorsa(borsa);
		this.partita.setGiocatore(giocatore);
		this.labirinto.setStanzaCorrente(stanza);
		this.partita.setLabirinto(labirinto);
		this.comando.setParametro("bastone");
	}
	
	
	@Test
	final void testGetNome() {
		assertEquals("posa", this.comando.getNome());
	}
	
	@Test
	final void testGetParametro() {
		assertEquals("bastone", this.comando.getparametro());
	}
	
	@Test
	final void testEsegui() {
		this.giocatore.getBorsa().addAttrezzo(bastone);
		this.comando.esegui(this.partita);
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("bastone"));
	}
	
	@Test
	final void testEseguiAttrezzoNonPresente() {
		this.comando.setParametro("Tavola");
		this.borsa.addAttrezzo(bastone);
		this.comando.esegui(this.partita);
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("bastone"));
	}
	
	
	
	
	
	

}
