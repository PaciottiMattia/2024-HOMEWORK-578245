package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza biblioteca;
	private Stanza atrio;
	
	@BeforeEach
	void setUp() {
		this.labirinto=new Labirinto();
		this.labirinto.init();
		this.biblioteca=this.labirinto.getStanzaVincente();
		this.atrio=this.labirinto.getStanzaCorrente();
	}
	
	@Test
	final void testGetStanzaVincente() {
		assertEquals(this.biblioteca, this.labirinto.getStanzaVincente());
	}
	
	@Test
	final void testGetStanzaCorrenteNonNulla() {
		assertNotNull(this.labirinto.getStanzaCorrente());
	}
	
	@Test
	final void testGetStanzaCorrente() {
		assertEquals(this.atrio, this.labirinto.getStanzaCorrente());
	}
}
