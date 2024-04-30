package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	static final protected String DescrizioneStanzaBuia="Qui c'è un buio pesto";
	private String nomeAttrezzo;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
	}
		
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzo)) {
			return super.getDescrizione();
		}
		else {
			return this.DescrizioneStanzaBuia;
		}
	}
	
	
	public String getNomeAttrezzoBuio() {
		return this.nomeAttrezzo;
	}
	
	public void setNomeAttrezzo(String nome) {
		this.nomeAttrezzo=nome;
	}

}
