#ifndef ORE_HPP
#define ORE_HPP

#include "Pickaxe.hpp"

class Ore {
public:
    virtual ~Ore() = default;

    virtual bool BreakableBy(Pickaxe pickaxe) = 0;
};

#endif
