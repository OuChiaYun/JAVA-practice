#include "TicketSystem.hpp"

int CheckTicketPrice(Order ticket){
    int price = 0; //這裡挖空。
    if(ticket.quantity <= 0){
        throw std::invalid_argument("There is at least one ticket.");
    }
    switch (ticket.type) {
        case TicketType::Adult:
            price = 350;
            break;
        case TicketType::Child:
            price = 280;
            break;
        case TicketType::Elder:
            price = 240;
            break;
    }
    return ticket.quantity<10 ? price*ticket.quantity : price*ticket.quantity*0.8;//結束挖空。
}
int CheckTodaySales(std::vector<Order> tickets){
    int prices = 0;
    for(auto i:tickets){
        prices += CheckTicketPrice(i);
    }
    return prices;
}
int CheckTodayTicketSales(std::vector<Order> tickets){
    int total = 0;
    for(auto i:tickets){
        if(i.quantity <= 0)
            throw std::invalid_argument("There need at least one ticket.");
        total += i.quantity;
    }
    return total;
}
int CheckSpecificTicketSales(TicketType type,std::vector<Order> tickets){
    int total = 0;
    for(auto i:tickets){
        if(i.type == type){
            total += CheckTicketPrice(i);
        }
    }
    return total;
}
int CheckSpecificOrdersTicketPrice(int idx,std::vector<Order> tickets){
    if(idx < 0 || idx >= tickets.size() )
        throw std::invalid_argument("Index out of range.");
    return CheckTicketPrice(tickets[idx]);
}
