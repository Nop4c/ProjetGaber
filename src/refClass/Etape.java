package refClass;

public class Etape {

	private int ordre;
	private String dateEtape;
	private int Duree;
	
	public Etape(int ordre, String dateEtape, int duree) {
		super();
		this.ordre = ordre;
		this.dateEtape = dateEtape;
		Duree = duree;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getDateEtape() {
		return dateEtape;
	}

	public void setDateEtape(String dateEtape) {
		this.dateEtape = dateEtape;
	}

	public int getDuree() {
		return Duree;
	}

	public void setDuree(int duree) {
		Duree = duree;
	}
	
}
