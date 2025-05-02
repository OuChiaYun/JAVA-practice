package OOP_HW1.test;

import java.util.Vector;

import OOP_HW1.include.TicketSystem;
import OOP_HW1.include.includeTicketSystem;
import OOP_HW1.include.includeTicketSystem.Order;
import OOP_HW1.include.includeTicketSystem.TicketType;
import OOP_HW1.src.srcTicketSystem;

public class Main {
    public static void main(String[] args) {
        // System.out.println("hello world");

        includeTicketSystem include = new includeTicketSystem();
        Order ticket = include.new Order();

        ticket.quantity = 100;
        ticket.type = TicketType.Adult;
        Vector<Order> v = new Vector<>();
        v.add(ticket);
        v.add(ticket);

        TicketSystem t = new srcTicketSystem();
        System.out.println(t.CheckTicketPrice(ticket));
        System.out.println(t.CheckTodaySales(v));
        System.out.println(t.CheckTodayTicketSales(v));
        System.out.println(t.CheckSpecificTicketSales(TicketType.Adult, v));
        System.out.println(t.CheckSpecificOrdersTicketPrice(1, v));

    }

}