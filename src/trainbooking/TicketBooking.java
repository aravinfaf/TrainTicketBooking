package trainbooking;

import java.util.*;

public class TicketBooking {

    static int availableLowerBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableUpperBerth = 1;
    static int availableRacPositions = 1;
    static int availableWLPositions = 1;

    static List<Integer> lowerBerthPosition = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> middleBerthPosition = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> upperBerthPosition = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> racBerthPosition = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> wlBerthPosition = new ArrayList<Integer>(Arrays.asList(1));

    static Queue<Integer> racQueue = new LinkedList<>();
    static Queue<Integer> wlQueue = new LinkedList<>();

    static List<Integer> bookedList = new ArrayList<>();

    static Map<Integer, Passenger> passengerMap = new HashMap<>();

    void bookTicket(Passenger passenger, int berthInfo, String allottedBerth) {
        passenger.allotted = allottedBerth;
        passenger.number = berthInfo;
        bookedList.add(passenger.passengerId);
        passengerMap.put(passenger.passengerId, passenger);
        System.out.println("---- Booked Successfully ----");
    }

    void addToRAC(Passenger passenger, int racInfo, String allottedBerth) {
        passenger.allotted = allottedBerth;
        passenger.number = racInfo;

        racQueue.add(passenger.passengerId);
        availableRacPositions--;
        racBerthPosition.remove(0);
        System.out.println("---- Added RAC successfully ----");
    }

    void addToWL(Passenger passenger, int wlInfo, String allottedBerth) {
        passenger.allotted = allottedBerth;
        passenger.number = wlInfo;

        wlQueue.add(passenger.passengerId);
        availableWLPositions--;
        wlBerthPosition.remove(0);
        System.out.println("---- Added WL successfully ----");
    }

    void printBookedTickets(){
        System.out.println("Name        Age         Preference");
        for (Passenger passenger : passengerMap.values()
             ) {
            System.out.println(passenger.passengerName+"      "+passenger.age+"          "+passenger.allotted);
        }
    }
}
