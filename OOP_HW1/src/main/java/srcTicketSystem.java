import java.util.Vector;

public class srcTicketSystem implements TicketSystem {

    public int CheckTicketPrice(includeTicketSystem.Order ticket) {
        int price = 0; // 這裡挖空。
        if (ticket.quantity <= 0) {
            throw new IllegalArgumentException("There is at least one ticket.");
        }
        switch (ticket.type) {
            case Adult:
                price = 350;
                break;
            case Child:
                price = 280;
                break;
            case Elder:
                price = 240;
                break;
        }
        return ticket.quantity < 10
                ? price * ticket.quantity
                : (int) (price * ticket.quantity * 0.8);
        // 結束挖空。
    }

    public int CheckTodaySales(Vector<includeTicketSystem.Order> tickets) {
        int prices = 0;
        for (includeTicketSystem.Order i : tickets) {
            prices += CheckTicketPrice(i);
        }
        return prices;
    }

    public int CheckTodayTicketSales(Vector<includeTicketSystem.Order> tickets) {
        int total = 0;
        for (includeTicketSystem.Order i : tickets) {
            if (i.quantity <= 0)
                throw new IllegalArgumentException("There need at least one ticket.");
            total += i.quantity;
        }
        return total;
    }

    public int CheckSpecificTicketSales(includeTicketSystem.TicketType type,
            Vector<includeTicketSystem.Order> tickets) {
        int total = 0;
        for (includeTicketSystem.Order i : tickets) {
            if (i.type == type) {
                total += CheckTicketPrice(i);
            }
        }
        return total;
    }

    public int CheckSpecificOrdersTicketPrice(int idx, Vector<includeTicketSystem.Order> tickets) {
        if (idx < 0 || idx >= tickets.size())
            throw new IllegalArgumentException("Index out of range.");
        return CheckTicketPrice(tickets.get(idx));
    }
}
