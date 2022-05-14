package trainbooking;

public class Passenger {

    static int id = 1; // Auto increment
    String passengerName;
    String berthPreference; // U L M
    int age;
    int passengerId; // Unique ID
    String allotted; // Allotted berth L,M,U,RAC,WL
    int number; // Seat number 1L,1M,2L

    public Passenger(String passengerName, String berthPreference, int age) {
        this.passengerName = passengerName;
        this.berthPreference = berthPreference;
        this.age = age;
        this.passengerId = id++;
        this.allotted = "";
        this.number = -1;
    }
}
