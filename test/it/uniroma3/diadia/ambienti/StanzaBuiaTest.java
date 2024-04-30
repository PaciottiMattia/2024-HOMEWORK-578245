package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private String nomeAttrezzo;
	private StanzaBuia stanza;
	private Attrezzo bastone;
	
	@BeforeEach
	void setUp() {
		this.bastone=new Attrezzo("bastone", 2);
		this.stanza=new StanzaBuia("Campus", "bastone");
		this.stanza.addAttrezzo(bastone);
	}

	@Test
	final void testGetDescrizioneConAttrezzo() {
		assertNotEquals(this.stanza.getDescrizione(),"Qui c'è un buio pesto");
	}
	
	@Test
	final void testGetNomeAttrezzo() {
		assertEquals(this.stanza.getNomeAttrezzoBuio(), "bastone");
	}
	
	@Test
	final void testGetDescrizioneSenzaAttrezzo() {
		this.stanza.removeAttrezzo(bastone);
		assertEquals(this.stanza.getDescrizione(), "Qui c'è un buio pesto");
	}
	

}
