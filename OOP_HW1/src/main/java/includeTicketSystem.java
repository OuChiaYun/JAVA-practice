public class includeTicketSystem {

    public enum TicketType {
        Adult,
        Child,
        Elder,
    }

    public class Order {
        public TicketType type;
        public int quantity;
    }

    public includeTicketSystem() {
    }

}
