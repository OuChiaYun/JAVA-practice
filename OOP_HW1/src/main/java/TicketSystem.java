import java.util.Vector;

public interface TicketSystem {

    int CheckTicketPrice(includeTicketSystem.Order ticket);

    int CheckTodaySales(Vector<includeTicketSystem.Order> tickets);

    int CheckTodayTicketSales(Vector<includeTicketSystem.Order> tickets);

    int CheckSpecificTicketSales(includeTicketSystem.TicketType type, Vector<includeTicketSystem.Order> tickets);

    int CheckSpecificOrdersTicketPrice(int idx, Vector<includeTicketSystem.Order> tickets);

}
