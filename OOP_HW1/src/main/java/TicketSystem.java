import java.util.Vector;

public class TicketSystem {

    public static int CheckTicketPrice(Order ticket) {
        int price = 0; // 這裡挖空。
        if (ticket.GetQuantity() <= 0) {
            throw new IllegalArgumentException("There is at least one ticket.");
        }
        switch (ticket.GetTicketType()) {
            case ADULT:
                price = 350;
                break;
            case CHILD:
                price = 280;
                break;
            case ELDER:
                price = 240;
                break;
        }
        return (int) (price * ticket.GetQuantity() * (ticket.GetQuantity() >= 10 ? 0.8 : 1));
        // 結束挖空。
    }

    public static int CheckTodaySales(Vector<Order> tickets) {
        int prices = 0;
        for (Order ticket : tickets) {
            prices += CheckTicketPrice(ticket);
        }
        return prices;
    }

    public static int CheckTodayTicketSales(Vector<Order> tickets) {
        int total = 0;
        for (Order ticket : tickets) {
            if (ticket.GetQuantity() <= 0) {
                throw new IllegalArgumentException("There need at least one ticket.");
            }
            total += ticket.GetQuantity();
        }
        return total;
    }

    public static int CheckSpecificTicketSales(TicketType type,
            Vector<Order> tickets) {
        int total = 0;
        for (Order ticket : tickets) {
            if (ticket.GetTicketType() == type) {
                total += CheckTicketPrice(ticket);
            }
        }
        return total;
    }

    public static int CheckSpecificOrdersTicketPrice(int idx, Vector<Order> tickets) {
        if (idx < 0 || idx >= tickets.size())
            throw new IllegalArgumentException("Index out of range.");
        return CheckTicketPrice(tickets.get(idx));
    }
}
