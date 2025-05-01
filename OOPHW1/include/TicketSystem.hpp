#ifndef Ticket_System_HPP
#define Ticket_System_HPP

#include <string>
#include <vector>
#include <stdexcept>

enum class TicketType{
    Adult,
    Child,
    Elder,
};

struct Order{
    TicketType type;
    int quantity;
};

int CheckTicketPrice(Order ticket);
int CheckTodaySales(std::vector<Order> tickets);
int CheckTodayTicketSales(std::vector<Order> tickets);
int CheckSpecificTicketSales(TicketType type,std::vector<Order> tickets);
int CheckSpecificOrdersTicketPrice(int idx,std::vector<Order> tickets);

#endif
