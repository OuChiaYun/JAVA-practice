#ifndef CRAFTING_TABLE_HPP
#define CRAFTING_TABLE_HPP

#include <memory>

#include "Armor.hpp"
#include "ICraftable.hpp"

class CraftingTable final {
public:
    void CraftArmor();

    void SetInput(std::shared_ptr<ICraftable> input);
    std::shared_ptr<Armor> GetOutput();

private:
};

#endif
