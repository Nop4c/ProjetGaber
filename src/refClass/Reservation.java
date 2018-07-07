package refClass;

import java.util.Calendar;

public class Reservation {

	private int id;
	private int nbPlace;
	private Calendar date;
	
	public Reservation(int id, int nbPlace, Calendar date) {
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
}
