package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;

class GiocatoreTest {
	private Giocatore giocatoreConBorsaVuota;
	private Giocatore giocatoreConBorsaNonVuota;
	
	private Borsa borsaVuota;
	private Borsa borsaNonVuota;
	private Attrezzo osso;
	
	
	
	@BeforeEach
	void setUp(){
		this.giocatoreConBorsaVuota= new Giocatore();
		this.giocatoreConBorsaNonVuota= new Giocatore();
		this.borsaVuota=new Borsa();
		this.borsaNonVuota=new Borsa();
		osso = new Attrezzo("osso", 1);
		this.borsaNonVuota.addAttrezzo(osso);
		this.giocatoreConBorsaVuota.setBorsa(borsaVuota);
		this.giocatoreConBorsaNonVuota.setBorsa(borsaNonVuota);
		
	}
	
	@Test
	final void testgetCfu() {
		assertTrue(this.giocatoreConBorsaNonVuota.getCfu()==20);
		assertTrue(this.giocatoreConBorsaVuota.getCfu()==20);
	}
	
	
	@Test
	final void testgetBorsa() {
		assertNotNull(this.giocatoreConBorsaNonVuota.getBorsa());
	}
}
