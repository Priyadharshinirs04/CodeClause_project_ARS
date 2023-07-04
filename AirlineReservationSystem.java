import java.util.Scanner;

public class AirlineReservationSystem {
    private static boolean[][] seats = new boolean[3][10]; // 3 flights with 10 seats each
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Airline Reservation System!");
        
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Reserve a seat");
            System.out.println("2. View ticket");
            System.out.println("3. Cancel ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    viewTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nFlight Options:");
        displayFlightOptions();
        
        System.out.print("Enter the flight number you wish to reserve a seat (1-3): ");
        int flightNumber = scanner.nextInt();
        
        if (flightNumber < 1 || flightNumber > 3) {
            System.out.println("Invalid flight number. Please try again.");
            return;
        }
        
        System.out.println("\nSeat Availability for Flight " + flightNumber + ":");
        displaySeatAvailability(flightNumber - 1);
        
        System.out.print("Enter the seat number you wish to reserve (1-10): ");
        int seatNumber = scanner.nextInt();
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        
        if (seats[flightNumber - 1][seatNumber - 1]) {
            System.out.println("Sorry, the seat is already occupied.");
        } else {
            seats[flightNumber - 1][seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " is successfully reserved on Flight " + flightNumber + ".");
        }
    }
    
    private static void viewTicket() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter your flight number: ");
        int flightNumber = scanner.nextInt();
        
        if (flightNumber < 1 || flightNumber > 3) {
            System.out.println("Invalid flight number. Please try again.");
            return;
        }
        
        System.out.print("Enter your seat number: ");
        int seatNumber = scanner.nextInt();
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        
        if (seats[flightNumber - 1][seatNumber - 1]) {
            System.out.println("\nTicket Details:");
            System.out.println("Flight Number: " + flightNumber);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Status: Reserved");
        } else {
            System.out.println("\nNo ticket found for the given flight and seat number.");
        }
    }
    
    private static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter your flight number: ");
        int flightNumber = scanner.nextInt();
        
        if (flightNumber < 1 || flightNumber > 3) {
            System.out.println("Invalid flight number. Please try again.");
            return;
        }
        
        System.out.print("Enter your seat number: ");
        int seatNumber = scanner.nextInt();
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        
        if (seats[flightNumber - 1][seatNumber - 1]) {
            seats[flightNumber - 1][seatNumber - 1] = false;
            System.out.println("Ticket for seat " + seatNumber + " on Flight " + flightNumber + " is successfully canceled.");
        } else {
            System.out.println("No ticket found for the given flight and seat number.");
        }
    }
    
    private static void displayFlightOptions() {
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Flight " + (i + 1));
        }
    }
    
    private static void displaySeatAvailability(int flightIndex) {
        for (int i = 0; i < seats[flightIndex].length; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            if (seats[flightIndex][i]) {
                System.out.println("Occupied");
            } else {
                System.out.println("Available");
            }
        }
    }
}
