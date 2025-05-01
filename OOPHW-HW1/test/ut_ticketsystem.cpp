#include <gtest/gtest.h>

#include "TicketSystem.hpp"

TEST(TICKET_SYSTEM_TEST, test_check_ticket_price_should_have_correct_price){
    Order ticket;
    ticket.type = TicketType::Adult,ticket.quantity = 1;

    int price = CheckTicketPrice(ticket);

    ASSERT_EQ(price,350);
}
TEST(TICKET_SYSTEM_TEST, test_check_ticket_price_should_throw_exception){
    Order ticket;
    ticket.type = TicketType::Adult,ticket.quantity = -1;

    ASSERT_THROW(CheckTicketPrice(ticket),std::invalid_argument);
}
TEST(TICKET_SYSTEM_TEST, test_check_ticket_price_should_give_a_discount){
    Order ticket;
    ticket.type = TicketType::Elder,ticket.quantity = 10;

    int price = CheckTicketPrice(ticket);

    ASSERT_EQ(price,1920);
}

TEST(TICKET_SYSTEM_TEST, test_check_today_sales_have_correct_price){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = 3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    int price = CheckTodaySales(tickets);

    ASSERT_EQ(price,4920);
}

TEST(TICKET_SYSTEM_TEST, test_check_today_sales_should_throw_exception){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = -3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    ASSERT_THROW(CheckTodaySales(tickets),std::invalid_argument);
}

TEST(TICKET_SYSTEM_TEST, test_check_today_tickets_sales_have_correct_ticket_amount){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = 3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    int total = CheckTodayTicketSales(tickets);

    ASSERT_EQ(total,18);
}

TEST(TICKET_SYSTEM_TEST, test_check_today_tickets_sales_should_throw_exception){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = -3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    ASSERT_THROW(CheckTodayTicketSales(tickets),std::invalid_argument);
}

TEST(TICKET_SYSTEM_TEST, test_check_specific_tickets_sales_give_correct_amount){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = 3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    int price = CheckSpecificTicketSales(TicketType::Child,tickets);

    ASSERT_EQ(price,1400);
}

TEST(TICKET_SYSTEM_TEST, test_check_specific_tickets_sales_give_correct_amount_two){
    Order adult_ticket,child_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    std::vector<Order> tickets = {adult_ticket,child_ticket};

    int price = CheckSpecificTicketSales(TicketType::Elder,tickets);

    ASSERT_EQ(price,0);
}

TEST(TICKET_SYSTEM_TEST, test_check_specific_orders_ticket_prices_give_correct_amount){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = 3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    int price = CheckSpecificOrdersTicketPrice(0,tickets);

    ASSERT_EQ(price,2800);
}

TEST(TICKET_SYSTEM_TEST, test_check_specific_orders_ticket_prices_throw_exception){
    Order adult_ticket,child_ticket,elder_ticket;
    adult_ticket.quantity = 10,adult_ticket.type = TicketType::Adult;
    child_ticket.quantity = 5,child_ticket.type = TicketType::Child;
    elder_ticket.quantity = 3,elder_ticket.type = TicketType::Elder;
    std::vector<Order> tickets = {adult_ticket,child_ticket,elder_ticket};

    ASSERT_THROW(CheckSpecificOrdersTicketPrice(4,tickets),std::invalid_argument);
}
