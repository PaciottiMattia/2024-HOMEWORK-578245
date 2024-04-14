package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class PartitaTest {
	private Partita partita;
	
	
	@BeforeEach
	void SetUp() {
		this.partita=new Partita();
	}
	
	@Test
	final void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	final void testisFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	final void testgetLabirinto() {
		assertNotNull(this.partita.getLabirinto());
		
	}
	
	@Test
	final void testgetGiocatore() {
		assertNotNull(this.partita.getGiocatore());
	}
	
	@Test
	final void testFinita() {
		assertFalse(this.partita.isFinita());
	}

}
