public class Booking {
    String guestName;
    Room room;

    public Booking(String guestName, Room room) {
        this.guestName = guestName;
        this.room = room;
    }

    public void printDetails() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room No: " + room.roomNumber);
        System.out.println("Category: " + room.category);
        System.out.println("Total Price: ₹" + room.price);
        System.out.println("Payment: ₹" + room.price + " successful!");
    }
}
