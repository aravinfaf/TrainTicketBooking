package trainbooking;

import java.util.Scanner;

public class Main {

    static void bookTicket(Passenger passenger){
        TicketBooking ticketBooking = new TicketBooking();

        // Least possibility to get option
        if (TicketBooking.availableWLPositions == 0){
            System.out.println("No tickets available");
            return;
        }
        //If preferred berth available
        if (
                (passenger.berthPreference.equalsIgnoreCase("L") && TicketBooking.availableLowerBerth > 0) ||
                (passenger.berthPreference.equalsIgnoreCase("M") && TicketBooking.availableMiddleBerth > 0) ||
                (passenger.berthPreference.equalsIgnoreCase("U") && TicketBooking.availableUpperBerth > 0)
        ){
            if (passenger.berthPreference.equalsIgnoreCase("L")){
                System.out.println("Lower berth given");
                ticketBooking.bookTicket(passenger,TicketBooking.lowerBerthPosition.get(0),"L");
                TicketBooking.lowerBerthPosition.remove(0);
                TicketBooking.availableLowerBerth--;
            }
            else if (passenger.berthPreference.equalsIgnoreCase("M")){
                System.out.println("Middle berth given");
                ticketBooking.bookTicket(passenger,TicketBooking.lowerBerthPosition.get(0),"M");
                TicketBooking.middleBerthPosition.remove(0);
                TicketBooking.availableMiddleBerth--;
            }
            else if (passenger.berthPreference.equalsIgnoreCase("U")){
                System.out.println("Upper berth given");
                ticketBooking.bookTicket(passenger,TicketBooking.lowerBerthPosition.get(0),"U");
                TicketBooking.upperBerthPosition.remove(0);
                TicketBooking.availableUpperBerth--;
            }
        }
        else if(TicketBooking.availableRacPositions > 0){
            System.out.println("Added in RAC");
            ticketBooking.addToRAC(passenger,TicketBooking.lowerBerthPosition.get(0),"RAC");
        }
        else if(TicketBooking.availableWLPositions > 0){
            System.out.println("Added in WL ");
            ticketBooking.addToWL(passenger,TicketBooking.wlBerthPosition.get(0),"WL");
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("1.Book Ticket \n 2.Cancel Ticket \n 3.Available Tickets \n 4.Booked Tickets \n 5.Exit" );
            int choice = scanner.nextInt();

            switch (choice){
                case 1 : {
                    System.out.println("Enter name, age, berthPreference(L, M, U) ");
                    String name = scanner.next();
                    int age = scanner.nextInt();
                    String berth = scanner.next();

                    Passenger passenger = new Passenger(name, berth, age);
                    bookTicket(passenger);
                }
                    break;
                case 4 : {
                    System.out.println("<---- Booked Ticket Details ---->");
                    TicketBooking ticketBooking  = new TicketBooking();
                    ticketBooking.printBookedTickets();
                }
            }
        }
    }
}
