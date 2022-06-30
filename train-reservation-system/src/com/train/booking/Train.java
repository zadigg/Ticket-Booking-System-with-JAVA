package com.train.booking;

import java.time.LocalDate;

public class Train {
	private int trainNumber;
	private String trainName;
	private String fromStation;
	private String toStation;
	private int seatsAvailable;
	private int fare;
	private LocalDate doj;
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(int trainNumber, String trainName, String fromStation, String toStation, int seatsAvailable, int fare,
			LocalDate doj) {
		super();
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.seatsAvailable = seatsAvailable;
		this.fare = fare;
		this.doj = doj;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
	
	
}
