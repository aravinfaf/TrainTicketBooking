package trainbooking;

import java.util.*;

public class TicketBooking {

    static int availableLowerBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableUpperBerth = 1;
    static int availableRacPositions = 1;
    static int availableWLPositions = 1;

    static List<Integer> lowerBerthPosition  = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> middleBerthPosition  = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> upperBerthPosition  = new ArrayList<Integer>(Arrays.asList(1));

    static Queue<Integer> racPosition = new LinkedList<>();
    static Queue<Integer> wlPosition = new LinkedList<>();

    static List<Integer> bookedList = new ArrayList<>();
}
