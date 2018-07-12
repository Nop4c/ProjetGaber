package refClass;

import java.util.Calendar;

public class Reservation {

	private int id;
	private int nom;
	private int nbPlace;
	private Calendar date;
	private int circuitId;
	private int clientId;
	
	public Reservation(int id, int nbPlace, Calendar date, int circuitId, int clientId) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbPlace = nbPlace;
		this.date = date;
		this.circuitId = circuitId;
		this.clientId = clientId;
	}

	public Reservation(int nom, int nbPlace, Calendar date) {
		super();
		
		this.id = id;
		this.nom=nom;
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

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public int getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(int circuitId) {
		this.circuitId = circuitId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
