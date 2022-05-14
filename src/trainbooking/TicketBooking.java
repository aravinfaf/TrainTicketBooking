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

        passengerMap.put(passenger.passengerId, passenger);
        racQueue.add(passenger.passengerId);
        availableRacPositions--;
        racBerthPosition.remove(0);
        System.out.println("---- Added RAC successfully ----");
    }

    void addToWL(Passenger passenger, int wlInfo, String allottedBerth) {
        passenger.allotted = allottedBerth;
        passenger.number = wlInfo;

        passengerMap.put(passenger.passengerId, passenger);
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

    public void cancelTicket(int passengerId) {
        if (!passengerMap.containsKey(passengerId)){
            System.out.println("Unknown passenger details");
        }else{
            Passenger passenger = passengerMap.get(passengerId);
            String berth = passenger.allotted;
            int positionBooked = passenger.number;

            bookedList.remove(Integer.valueOf(passengerId));
            System.out.println("<--- Removed successfully --->");

            if (berth.equalsIgnoreCase("L")){
                availableLowerBerth++;
                lowerBerthPosition.add(positionBooked);
            }
            else if (berth.equalsIgnoreCase("U")){
                availableUpperBerth++;
                upperBerthPosition.add(positionBooked);
            }
            else if (berth.equalsIgnoreCase("M")){
                availableMiddleBerth++;
                middleBerthPosition.add(positionBooked);
            }

            if (racQueue.size() > 0) {

                Passenger passengerFromRAC = passengerMap.get(racQueue.poll());
                int positionRac = passengerFromRAC.number;
                racBerthPosition.add(positionRac);
                racQueue.remove(Integer.valueOf(passengerFromRAC.passengerId));
                availableRacPositions++;

                if (wlQueue.size() > 0) {

                Passenger passengerFromWL = passengerMap.get(wlQueue.poll());
                int positionWL = passengerFromWL.number;
                wlBerthPosition.add(Integer.valueOf(positionWL));
                wlQueue.remove(Integer.valueOf(passengerFromWL.passengerId));

                passengerFromWL.number =racBerthPosition.get(0);
                passengerFromWL.allotted = "RAC";
                availableRacPositions--;
                availableWLPositions++;
                }
            Main.bookTicket(passengerFromRAC);
            }
        }
    }

    public void printAvailable() {
        System.out.println("Lower berth "+availableLowerBerth);
        System.out.println("Middle berth "+availableMiddleBerth);
        System.out.println("Upper berth "+availableUpperBerth);
        System.out.println("RAC berth "+availableRacPositions);
        System.out.println("Waiting berth "+availableWLPositions);
    }
}
