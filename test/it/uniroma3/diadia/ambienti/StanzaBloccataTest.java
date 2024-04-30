package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private Stanza stanza;
	private StanzaBloccata stanzaBloccata;
	private Attrezzo bastone;
	
	@BeforeEach
	void setUp() {
		this.bastone= new Attrezzo("bastone", 2);
		this.stanza= new Stanza("Campus");
		this.stanzaBloccata=new StanzaBloccata("Atrio", "bastone", "nord");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanza);
		this.stanzaBloccata.addAttrezzo(bastone);
	}
	
	
	@Test
	final void testGetStanzaAdiacente() {
		assertEquals(this.stanzaBloccata.getStanzaAdiacente("nord"), this.stanza);
	}
	
	@Test
	final void testGetStanzaAdiacenteBloccata() {
		this.stanzaBloccata.removeAttrezzo(bastone);
		assertEquals(this.stanzaBloccata.getStanzaAdiacente("nord"), this.stanzaBloccata);
	}
	
	@Test
	final void testGetNomeAttrezzo() {
		assertEquals(this.stanzaBloccata.getNomeAttrezzo(), "bastone");
	}
	
	@Test
	final void testGetDirezioneBloccata() {
		assertEquals(this.stanzaBloccata.getDirezioneBloccata(), "nord");
	}

}
