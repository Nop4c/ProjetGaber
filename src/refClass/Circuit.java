package refClass;

public class Circuit {

	private int id;
	private String descriptif;
	private String villeDepart;
	private String paysDepart;
	private String villeArrivee;
	private String paysArrivee;
	private String dateDepart;
	private int nbrPlaceDisponible;
	private int duree;
	private int prixInscription;
	
	public Circuit(int id, String descriptif, String villeDepart, String paysDepart, String villeArrivee,
			String paysArrivee, String dateDepart, int nbrPlaceDisponible, int duree, int prixInscription) {
		super();
		this.id = id;
		this.descriptif = descriptif;
		this.villeDepart = villeDepart;
		this.paysDepart = paysDepart;
		this.villeArrivee = villeArrivee;
		this.paysArrivee = paysArrivee;
		this.dateDepart = dateDepart;
		this.nbrPlaceDisponible = nbrPlaceDisponible;
		this.duree = duree;
		this.prixInscription = prixInscription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getPaysDepart() {
		return paysDepart;
	}

	public void setPaysDepart(String paysDepart) {
		this.paysDepart = paysDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public String getPaysArrivee() {
		return paysArrivee;
	}

	public void setPaysArrivee(String paysArrivee) {
		this.paysArrivee = paysArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNbrPlaceDisponible() {
		return nbrPlaceDisponible;
	}

	public void setNbrPlaceDisponible(int nbrPlaceDisponible) {
		this.nbrPlaceDisponible = nbrPlaceDisponible;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getPrixInscription() {
		return prixInscription;
	}

	public void setPrixInscription(int prixInscription) {
		this.prixInscription = prixInscription;
	}
	
	
}
