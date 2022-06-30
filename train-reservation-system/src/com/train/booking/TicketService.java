package com.train.booking;

import java.util.LinkedList;
import java.util.List;

public class TicketService {
	private static List<Ticket> allTickets = new LinkedList<>();

	public static void addNewTicket( int trainNumber, List<Passenger> passengerList) {
		int pnr = allTickets.size()+1;
		Train bookedTrain = TrainService.findTrain(trainNumber);
		allTickets.add(new Ticket(pnr, bookedTrain, passengerList));
		System.out.println("Tickets booked successfully ... ");
	}
	
	public static void showTicketDetails(int pnr) {
		Ticket tempTicket = null;
		for(Ticket t: allTickets) {
			if(t.getPnr() == pnr) {
				tempTicket = t;
				break;
			}
		}
		
		Train tempTrain = tempTicket.getBookedTrain();
		List<Passenger> passengerList = tempTicket.getPassengerList();
		int totalFare = tempTrain.getFare() * passengerList.size();
		System.out.println("**** YOUR BOOKING DETAILS ****");
		System.out.println("PNR=>" + tempTicket.getPnr() + " Tr.No" + tempTrain.getTrainNumber());
		System.out.println("Train Name :" + tempTrain.getTrainName());
		System.out.println("From Stattion :" + tempTrain.getFromStation() + " To Station :" + tempTrain.getToStation());
		System.out.println("DOJ :" + tempTrain.getDoj() + " Fare:" + tempTrain.getFare() + " Total Fare: " + totalFare);
		System.out.println("\nPassenger Info Below \n");
		
		System.out.println("Passenger Name       Age");
		for(Passenger p : passengerList) {
			System.out.println(p.getPassengerName()+"\t"+p.getAge());
			
		}
		System.out.println("********************************");
	}
	
	
}
