public class Order {
    private TicketType type;
    private int quantity;

    public Order() {
    }

    public Order(TicketType t, int q) {
        type = t;
        quantity = q;
    }

    public void setTicketType(TicketType t) {
        type = t;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public TicketType getTicketType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
