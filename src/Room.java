 public class Room {
        int roomNumber;
        String category; // Standard, Deluxe, Suite
        boolean isBooked;
        double price;

        public Room(int roomNumber, String category, double price) {
            this.roomNumber = roomNumber;
            this.category = category;
            this.price = price;
            this.isBooked = false;
        }
    }
