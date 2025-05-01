package OOPHW1.test;

import java.util.Vector;

import OOPHW1.include.TicketSystem;
import OOPHW1.include.includeTicketSystem;
import OOPHW1.include.includeTicketSystem.Order;
import OOPHW1.include.includeTicketSystem.TicketType;
import OOPHW1.src.srcTicketSystem;

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