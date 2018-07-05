package refClass;

public class Reservation {

	private int id;
	private int nbPlace;
	private String date;
	
	public Reservation(int id, int nbPlace, String date) {
		super();
		this.id = id;
		this.nbPlace = nbPlace;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
