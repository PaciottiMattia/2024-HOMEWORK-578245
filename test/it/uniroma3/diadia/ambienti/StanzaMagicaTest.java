package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private Attrezzo bastone;
	private StanzaMagica stanza;
	private StringBuilder s;
	
	@BeforeEach
	void setUp() {
		this.bastone=new Attrezzo("bastone", 1);
		this.stanza=new StanzaMagica("labIA", 3);
		s=new StringBuilder(this.bastone.getNome());
	}
	
	
	@Test
	final void testAddAttrezzo() {
		this.stanza.addAttrezzo(bastone);
		assertTrue(this.stanza.hasAttrezzo("bastone"));
	}
	
	
	
	
	@Test
	final void testModificaAttrezzo() {
		this.stanza.addAttrezzo(bastone);
		s=this.s.reverse();
		assertTrue(this.stanza.hasAttrezzo(s.reverse().toString()));
	}

}
