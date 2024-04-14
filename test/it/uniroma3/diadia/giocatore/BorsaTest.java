package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo osso;
	
	
	@BeforeEach
	void setUp() {
		this.borsa=new Borsa();
		this.osso= new Attrezzo("osso", 1);
		this.borsa.addAttrezzo(osso);
	}
	
	@Test
	final void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(osso));
	}
	
	@Test
	final void testGetAttrezzo() {
		assertEquals(this.osso, this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	final void testGetAttrezzoNonNullo() {
		assertNotNull(this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	final void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
	}
	
	@Test
	final void testGetPeso() {
		assertTrue(this.borsa.getPeso()==1);
		assertFalse(this.borsa.getPeso()==0);
	}
	
	@Test
	final void testIsEmpty() {
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	final void testRemoveAttrezzo() {
		assertNotNull(this.borsa.removeAttrezzo("osso"));
	}

}
