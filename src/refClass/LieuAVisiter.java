package refClass;

public class LieuAVisiter {

	private String nomLieu;
	private String ville;
	private String pays;
	private String descriptif;
	private String prixVisite;
	
	public LieuAVisiter(String nomLieu, String ville, String pays, String descriptif, String prixVisite) {
		super();
		this.nomLieu = nomLieu;
		this.ville = ville;
		this.pays = pays;
		this.descriptif = descriptif;
		this.prixVisite = prixVisite;
	}

	public String getNomLieu() {
		return nomLieu;
	}

	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getPrixVisite() {
		return prixVisite;
	}

	public void setPrixVisite(String prixVisite) {
		this.prixVisite = prixVisite;
	}
	
}
