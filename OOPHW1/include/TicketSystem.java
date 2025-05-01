package OOPHW1.include;

import OOPHW1.include.includeTicketSystem.*;

import java.util.Vector;

public interface TicketSystem {

    int CheckTicketPrice(Order ticket);

    int CheckTodaySales(Vector<Order> tickets);

    int CheckTodayTicketSales(Vector<Order> tickets);

    int CheckSpecificTicketSales(TicketType type, Vector<Order> tickets);

    int CheckSpecificOrdersTicketPrice(int idx, Vector<Order> tickets);

}
