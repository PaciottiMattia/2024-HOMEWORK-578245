package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String nomeAttrezzo;
	private String nomeDirezione;
	
	public StanzaBloccata(String nome, String nomeAttrezzo, String nomeDirezione) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
		this.nomeDirezione=nomeDirezione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(this.hasAttrezzo(nomeAttrezzo)) {
			return super.getStanzaAdiacente(dir);
		}
		else {
			return this;
		}
		
	}
	
	@Override
	public String getDescrizione() {
		return "Stanza bloccata direzione: \n"+this.getDirezioneBloccata()+"Attrezzo per sbloccare: "+this.getNomeAttrezzo();
	}
	
	
	public String getNomeAttrezzo() {
		return this.nomeAttrezzo;
	}
	
	public void setNomeattrezzo(String nomeAttrezzo) {
		this.nomeAttrezzo=nomeAttrezzo;
	}
	
	public String getDirezioneBloccata() {
		return this.nomeDirezione;
	}
	
	public void setDirezioneBloccata(String nomeDirezione){
		this.nomeDirezione=nomeDirezione;
	}
	
}