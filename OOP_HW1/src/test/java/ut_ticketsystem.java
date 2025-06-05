import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Vector;

public class ut_ticketsystem {
    @Test
    public void test_check_ticket_price_should_have_correct_price() {

        Order ticket = new Order(TicketType.ADULT, 1);
        int price = TicketSystem.CheckTicketPrice(ticket);

        assertThat(price).matches(q -> q == 350);
    }

    @Test
    public void test_check_ticket_price_should_throw_exception() {

        Order ticket = new Order();
        ticket.SetTicketType(TicketType.ADULT);
        ticket.SetQuantity(-1);

        Throwable thrown = catchThrowable(() -> {
            TicketSystem.CheckTicketPrice(ticket);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("There is at least one ticket.");

    }

    @Test
    public void test_check_ticket_price_should_give_a_discount() {

        Order ticket = new Order();
        ticket.SetTicketType(TicketType.ELDER);
        ticket.SetQuantity(10);

        int price = TicketSystem.CheckTicketPrice(ticket);

        assertThat(price).matches(q -> q == 1920);

    }

    @Test
    public void test_check_today_sales_have_correct_price() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        int price = TicketSystem.CheckTodaySales(tickets);

        assertThat(price).matches(q -> q == 4920);

    }

    @Test
    public void test_check_today_sales_should_throw_exception() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(-3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        Throwable thrown = catchThrowable(() -> {
            TicketSystem.CheckTodaySales(tickets);
        });

        // i consider 5th floor write wrong code.
        // he call CheckTodaySales, bt actually i think is CheckTodayTicketSales.

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("There is at least one ticket.");
    }

    @Test
    public void test_check_today_tickets_sales_have_correct_ticket_amount() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        int total = TicketSystem.CheckTodayTicketSales(tickets);

        assertThat(total).matches(q -> q == 18);
    }

    @Test
    public void test_check_today_tickets_sales_should_throw_exception() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(-3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        Throwable thrown = catchThrowable(() -> {
            TicketSystem.CheckTodayTicketSales(tickets);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("There need at least one ticket.");
    }

    @Test
    public void test_check_specific_tickets_sales_give_correct_amount() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        int price = TicketSystem.CheckSpecificTicketSales(TicketType.CHILD, tickets);

        assertThat(price).matches(q -> q == 1400);

    }

    @Test
    public void test_check_specific_orders_ticket_prices_give_correct_amount() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        int price = TicketSystem.CheckSpecificOrdersTicketPrice(0, tickets);

        assertThat(price).matches(q -> q == 2800);

    }

    @Test
    public void test_check_specific_orders_ticket_prices_throw_exception() {

        Order adult_ticket = new Order(), child_ticket = new Order(), elder_ticket = new Order();
        adult_ticket.SetQuantity(10);
        adult_ticket.SetTicketType(TicketType.ADULT);

        child_ticket.SetQuantity(5);
        child_ticket.SetTicketType(TicketType.CHILD);

        elder_ticket.SetQuantity(3);
        elder_ticket.SetTicketType(TicketType.ELDER);

        Vector<Order> tickets = new Vector<>();
        tickets.add(adult_ticket);
        tickets.add(child_ticket);
        tickets.add(elder_ticket);

        Throwable thrown = catchThrowable(() -> {
            TicketSystem.CheckSpecificOrdersTicketPrice(4, tickets);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Index out of range.");

    }
}
