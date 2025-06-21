import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // Create sample rooms
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3000));
        rooms.add(new Room(103, "Suite", 5000));

        int choice;
        do {
            System.out.println("\n--- Hotel Booking Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room r : rooms) {
                        if (!r.isBooked) {
                            System.out.println("Room " + r.roomNumber + " | " + r.category + " | ₹" + r.price);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomNum = sc.nextInt();
                    sc.nextLine();
                    Room selectedRoom = null;
                    for (Room r : rooms) {
                        if (r.roomNumber == roomNum && !r.isBooked) {
                            selectedRoom = r;
                            break;
                        }
                    }
                    if (selectedRoom != null) {
                        selectedRoom.isBooked = true;
                        Booking booking = new Booking(name, selectedRoom);
                        bookings.add(booking);
                        booking.printDetails();
                    } else {
                        System.out.println("Room not available or already booked.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your name to cancel booking: ");
                    String cancelName = sc.nextLine();
                    Booking toRemove = null;
                    for (Booking b : bookings) {
                        if (b.guestName.equalsIgnoreCase(cancelName)) {
                            b.room.isBooked = false;
                            toRemove = b;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        bookings.remove(toRemove);
                        System.out.println("Booking cancelled for " + cancelName);
                    } else {
                        System.out.println("No booking found for " + cancelName);
                    }
                    break;
            }

        } while (choice != 4);

        System.out.println("Thank you for using our hotel booking system!");
        sc.close();
    }
}
