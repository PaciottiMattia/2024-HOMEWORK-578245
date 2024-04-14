package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;



class StanzaTest {
	private Stanza stanzaNonVuota;
	private Stanza stanzaVuota;
	private Attrezzo libro;
	
	@BeforeEach 
	void setUp() {
		stanzaNonVuota= new Stanza("Stanza non vuota");
		stanzaVuota= new Stanza("Stanza vuota");
		libro= new Attrezzo("libro", 1);
		stanzaNonVuota.addAttrezzo(libro);
		this.stanzaVuota.impostaStanzaAdiacente("nord", this.stanzaNonVuota);
		this.stanzaNonVuota.impostaStanzaAdiacente("sud", this.stanzaVuota);
	}
	
	
	@Test
	final void testGetStanzaAdiacente() {
		assertEquals(this.stanzaVuota.getNome(), this.stanzaNonVuota.getStanzaAdiacente("sud").getNome());
		assertEquals(this.stanzaNonVuota.getNome(),this.stanzaVuota.getStanzaAdiacente("nord").getNome(), "nessuna stanza adiacente a sud");
	}
	
	
	@Test
	final void testHasAttrezzo() {
		assertFalse(this.stanzaVuota.hasAttrezzo("libro"), "la stanza vuota non ha l'attrezzo");
		assertTrue(this.stanzaNonVuota.hasAttrezzo("libro"), "la stanza non vuota contiene l'attrezzo");
	}
	
	
	@Test
	final void testAddAttrezzo() {
		assertTrue(this.stanzaNonVuota.addAttrezzo(libro));
	}
	
	@Test
	final void testRemoveAttrezzo() {
		assertFalse(this.stanzaVuota.removeAttrezzo(libro));
		assertTrue(this.stanzaNonVuota.removeAttrezzo(libro));
	}

}
