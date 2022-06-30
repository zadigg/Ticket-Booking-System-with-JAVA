package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AbeL Kibebe
 *
 */
public class TrainMain {
public static void main(String[] args) {
	
	System.out.println("Now Searching for trains");
	TrainService.searchTrainsBetweenStations("Addis Ababa", "BahirDar", LocalDate.now(), 10);
	BankAccount b1 = new BankAccount();
	b1.setActNumber(999);
	b1.setActBalance(10000);
	
	Passenger p1 = new Passenger(10, "Abel", 30, b1);
	Passenger p2 = new Passenger(10, "Kibebe", 32, b1);
	Passenger p3 = new Passenger(10, "Negash", 33, b1);
	
	int inititalBalance = b1.getActBalance();
	List<Passenger> passengerList = new LinkedList<>();
	passengerList.add(p1);
	passengerList.add(p2);
	passengerList.add(p3);
	
	System.out.println("Now Booking ticket for 3 passengers in train number 101...");
	TrainService.bookTickets(101, passengerList);
	System.out.println("Now printing the ticket details ...");
	
	TicketService.showTicketDetails(1);
	System.out.println("\nPassenger Info Below \n");
	
	System.out.println("\n\n");
	TrainService.searchTrainsBetweenStations("Addis Ababa", "BahirDar", LocalDate.now(), 10);
	int balanceAfterBookingTickets = b1.getActBalance();
	System.out.println("initial Balance = " + inititalBalance);
	System.out.println("Balance after booking= " + balanceAfterBookingTickets);
	
}

}
