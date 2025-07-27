#ifndef ISMELTABLE_HPP
#define ISMELTABLE_HPP

#include <memory>

#include "Ingot.hpp"

class ISmeltable {
public:
    virtual ~ISmeltable() = default;

    virtual std::shared_ptr<Ingot> Smelt() = 0;
};

#endif
