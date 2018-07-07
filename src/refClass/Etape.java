package refClass;

import java.util.Calendar;

public class Etape {

	private int ordre;
	private Calendar dateEtape;
	private int Duree;
	
	public Etape(int ordre, Calendar dateEtape, int duree) {
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
	
}
