package refClass;

import java.util.Calendar;

public class Etape {
	private int id;
	private int ordre;
	private String nomLieu;
	private String ville;
	private String pays;
	private Calendar dateEtape;
	private int Duree;
	


	public Etape(int id,int ordre, String nomLieu, String ville, String pays, Calendar dateEtape, int duree) {
		super();
		this.id = id;
		this.ordre = ordre;
		this.nomLieu = nomLieu;
		this.ville = ville;
		this.pays = pays;
		this.dateEtape = dateEtape;
		Duree = duree;
	}
	
	public Etape(int ordre, String nomLieu, String ville, String pays, Calendar dateEtape, int duree) {
		super();
		this.id = id;
		this.ordre = ordre;
		this.nomLieu = nomLieu;
		this.ville = ville;
		this.pays = pays;
		this.dateEtape = dateEtape;
		Duree = duree;
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

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Calendar getDateEtape() {
		return dateEtape;
	}

	public void setDateEtape(Calendar dateEtape) {
		this.dateEtape = dateEtape;
	}

	public int getDuree() {
		return Duree;
	}

	public void setDuree(int duree) {
		Duree = duree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
