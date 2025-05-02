import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrder {
    @Test
    public void Test_Order_Get_Type_Should_Return_Correct_Type(){
        includeTicketSystem include = new includeTicketSystem();
        includeTicketSystem.Order ticket = include.new Order();
        ticket.type = includeTicketSystem.TicketType.Adult;

        assertThat(ticket.type).matches(p -> p == includeTicketSystem.TicketType.Adult);
    }
}
