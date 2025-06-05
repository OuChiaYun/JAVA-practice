public class Order {
    private TicketType type;
    private int quantity;

    public Order() {
    }

    public Order(TicketType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public void SetTicketType(TicketType type) {
        this.type = type;
    }

    public void SetQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TicketType GetTicketType() {
        return this.type;
    }

    public int GetQuantity() {
        return this.quantity;
    }
}
