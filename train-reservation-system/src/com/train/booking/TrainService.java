package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
	private static List<Train> allTrains = new LinkedList<>(); 
	
	static {
		allTrains.add(new Train(101,"Train-one","Addis Ababa","Hawassa",100,800,LocalDate.now()));
		allTrains.add(new Train(102,"Train-two","Hawassa","Addis Ababa",100,800,LocalDate.now()));
		allTrains.add(new Train(103,"Train-three","Addis Ababa","Hawassa",80,600,LocalDate.now()));
		allTrains.add(new Train(104,"Train-four","Hawassa","Addis Ababa",80,800,LocalDate.now()));
		allTrains.add(new Train(105,"Train-five","Addis Ababa","BahirDar",100,900,LocalDate.now()));
		allTrains.add(new Train(104,"Train-six","Bahirdar","Addis Ababa",100,900,LocalDate.now()));
	}

	public TrainService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Train findTrain(int trainNumber) {
		Train temp = null;
		for(Train t: allTrains) {
			if(t.getTrainNumber() == trainNumber)
			{
				temp = t;
				break;
			}
		}
		return temp;
	}
	
	public static void searchTrainsBetweenStations(String fromStation, String toStation, LocalDate doj, int numOfSeat) {
		List<Train> searchTrainList = new LinkedList<>();
		
		for(Train t : allTrains) {
			if(t.getFromStation().equals(fromStation) && 
					t.getToStation().equals(toStation) && 
					t.getDoj().equals(doj) &&
					t.getSeatsAvailable() > numOfSeat) {
				searchTrainList.add(t);
				
			}
		}
		if(searchTrainList.size() == 0 ) {
			System.out.println("Sorry, no matching trains available for the search criteria...");
		}else {
			System.out.println("Tr.No\tTrain Name\tFrom Station\tTo Station\tDoj\tSeats Available\tFare");
			System.out.println();
			for(Train t: searchTrainList) {
				System.out.printf("%4d%20s%15s%15s%12s%4d%5d\n", t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatsAvailable(),t.getFare());
			}
		}
	}
	
	public static void bookTickets(int trainNumbers, List<Passenger> passengerList) {
		
//		Step 1: we need to subtract the train fare for all passenger together from the bank account object
		int numOfSeats = passengerList.size();
//		Passenger tempPassenger = passengerList.get(0);
//		BankAccount account = tempPassenger.getBankAccount();
		BankAccount account = passengerList.get(0).getBankAccount();
		
		Train tempTrain = findTrain(trainNumbers);
		int fare = tempTrain.getFare();
		int totalFare = fare * numOfSeats;
		
		account.withdrawn(totalFare);
		
//		Step 2: we need to subtract the number of seats that are being booked from the actual available number of tickets
		tempTrain.setSeatsAvailable(tempTrain.getSeatsAvailable() - numOfSeats);
		
//		Step 3: we need to add one entry (one record) into tickets collection.
		TicketService.addNewTicket(trainNumbers, passengerList);
		
		
		
	}
	
	
	
	
	
	
	
}
