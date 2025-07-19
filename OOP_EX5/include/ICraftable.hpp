#ifndef ICRAFTABLE_HPP
#define ICRAFTABLE_HPP

#include "Armor.hpp"

class ICraftable {
public:
    virtual ~ICraftable() = default;

    virtual Armor CraftArmor() = 0;
};

#endif
